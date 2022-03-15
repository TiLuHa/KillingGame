package iz.netzwerk.src.helper;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import iz.netzwerk.src.Model.Account;
import iz.netzwerk.src.Model.AccountGame;
import iz.netzwerk.src.Model.AccountGamePlayerMapping;
import iz.netzwerk.src.Model.Game;
import iz.netzwerk.src.Model.Player;
import iz.netzwerk.src.Security.UserDetailsImpl;
import iz.netzwerk.src.repositories.AccountGamePlayerRepository;
import iz.netzwerk.src.repositories.GameRepository;
import iz.netzwerk.src.repositories.PlayerRepository;
import payload.response.GameResponse;

@Component
public class Helper {
	
	@Autowired
	GameRepository gameRepo;
	
	@Autowired
	AccountGamePlayerRepository agpRepo;
	
	@Autowired
	PlayerRepository playerRepo;
	
	public GameResponse assembleGameResponse(Game g)
	{
		List<Player> players = (List<Player>) playerRepo.findAllById(agpRepo.getLeaderIdsOfGame(g.getId()));
		List<Player> leaders = (List<Player>) playerRepo.findAllById(agpRepo.getPlayerIdsOfGame(g.getId()));
		return new GameResponse(g, players, leaders);
	}
	
	public List<Player> getLeadersOfGame(Game g)
	{
		return (List<Player>) playerRepo.findAllById(agpRepo.getLeaderIdsOfGame(g.getId()));
	}
	
	public UserDetailsImpl getUserDetails(Principal p)
	{
		return (UserDetailsImpl) ((UsernamePasswordAuthenticationToken)p).getPrincipal();
	}
	
	public Optional<Player> isAccountPartOfGame(Game g, Account a)
	{
		List<Long> ids = agpRepo.getAccountIdsOfGame(g.getId());
		
		for (Long id : ids)
			if (id == a.getId())
				return Optional.ofNullable(agpRepo.findById(new AccountGame(a, g)).get().player);
		
		return Optional.empty();
	}
	
	private String generateGameCode() {	
		byte[] array = new byte[3];
	    new Random().nextBytes(array);
	    return new String(DatatypeConverter.printHexBinary(array));
	}
	
	
	public boolean isGameCodePresent(String code) {
		return gameRepo.findByCode(code).isPresent();
	}
	
	public String generateUniqueGameCode() {
		String code = generateGameCode();
		
		while (isGameCodePresent(code))
			code = generateGameCode();
		
		return code;
	}
}
