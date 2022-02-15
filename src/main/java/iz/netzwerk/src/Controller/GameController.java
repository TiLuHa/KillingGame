package iz.netzwerk.src.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iz.netzwerk.src.Model.Game;
import iz.netzwerk.src.helper.Helper;
import iz.netzwerk.src.repositories.GameRepository;
import payload.request.GameRequest;
import payload.response.GameResponse;

@RestController
@RequestMapping("/api/games")
public class GameController
{
	@Autowired
	GameRepository repo;
	
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
	public ResponseEntity<?> createGame(@RequestBody GameRequest gameRequest)
	{
		return ResponseEntity.ok(repo.save(new Game(gameRequest.name, helper.generateUniqueGameCode())));
	}
	
}
