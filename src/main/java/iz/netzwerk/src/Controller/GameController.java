package iz.netzwerk.src.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iz.netzwerk.src.Model.AccountGamePlayerMapping;
import iz.netzwerk.src.Model.AccountRoles;
import iz.netzwerk.src.Model.Game;
import iz.netzwerk.src.Model.Player;
import iz.netzwerk.src.Security.UserDetailsImpl;
import iz.netzwerk.src.helper.Helper;
import iz.netzwerk.src.repositories.AccountGamePlayerRepository;
import iz.netzwerk.src.repositories.AccountRepository;
import iz.netzwerk.src.repositories.GameRepository;
import iz.netzwerk.src.repositories.PlayerRepository;
import payload.request.GameJoinRequest;
import payload.request.GameRequest;
import payload.response.GameResponse;

@RestController
@RequestMapping("/api/games")
public class GameController
{
	@Autowired
	GameRepository repo;
	
	@Autowired
	AccountGamePlayerRepository AGPrepo;
	
	@Autowired
	AccountRepository ACCrepo;
	
	@Autowired
	PlayerRepository playerRepo;
	
	@Autowired
	Helper helper;
	
	@GetMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<GameResponse> getGames()
	{
		List<GameResponse> tmp = new ArrayList<>();
		repo.findAll().forEach((game) -> tmp.add(new GameResponse(game)));;
		return tmp;
	}
	
	@PostMapping("")
	public ResponseEntity<?> createGame(@RequestBody GameRequest gameRequest, Principal p)
	{
		UserDetailsImpl details = (UserDetailsImpl) ((UsernamePasswordAuthenticationToken)p).getPrincipal();
		
		return ResponseEntity.ok(repo.save(new Game(gameRequest.name, helper.generateUniqueGameCode(), ACCrepo.findById(details.getId()).get())));
	}
	
	@PostMapping("/join")
	public ResponseEntity<?> addPlayerToGame(@RequestParam(value = "code") String gameCode, @RequestBody GameJoinRequest gameJoinRequest, Principal p)
	{	
		Optional<Game> game = repo.findByCode(gameCode);
		
		if (game.isEmpty())
			return (ResponseEntity<?>) new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		
		UserDetailsImpl details = (UserDetailsImpl) ((UsernamePasswordAuthenticationToken)p).getPrincipal();
		
		if (  gameJoinRequest.claimLeaderShip 
		   && details.getId() != game.get().getCreator().getId() 
		   && !details.getAuthorities().contains(new SimpleGrantedAuthority(AccountRoles.ADMIN.name()))
		   )
		{
			return (ResponseEntity<?>) new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
		}
		
		return ResponseEntity.ok(AGPrepo.save(new AccountGamePlayerMapping( ACCrepo.findById(details.getId()).get()
				                                                          , game.get()
				                                                          , playerRepo.save(new Player(gameJoinRequest.nickName))
				                                                          , gameJoinRequest.claimLeaderShip)
											 )
				                );
	}
	
}
