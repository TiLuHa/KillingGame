package iz.netzwerk.src.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import iz.netzwerk.src.Model.Account;
import iz.netzwerk.src.Security.JwtUtils;
import iz.netzwerk.src.repositories.AccountRepository;
import payload.response.AccountResponse;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository repo;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@GetMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> getAccounts()
	{
		List<AccountResponse> tmp = new ArrayList<>();
		repo.findAll().forEach((acc) -> tmp.add(new AccountResponse(acc)));
		return ResponseEntity.ok(tmp);
	}
	
	@GetMapping("/{Id}")
	@PreAuthorize("hasAuthority('ADMIN') or principal.getId() == #id")
	ResponseEntity<?> getAccountById(@PathVariable("Id") Long id)
	{	
		Optional<Account> acc = repo.findById(id);
		
		if (acc.isEmpty())
			return (ResponseEntity<?>) new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		
		return ResponseEntity.ok(new AccountResponse(acc.get()));
	}
}