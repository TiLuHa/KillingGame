package iz.netzwerk.src.helper;

import java.util.Random;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import iz.netzwerk.src.repositories.GameRepository;

@Component
public class Helper {
	
	@Autowired
	GameRepository gameRepo;
	
	
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
