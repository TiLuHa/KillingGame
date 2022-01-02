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
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.bind.annotation.*;

import iz.netzwerk.src.JwtUtils;
import iz.netzwerk.src.UserDetailsImpl;
import iz.netzwerk.src.Model.Account;
import iz.netzwerk.src.repositories.AccountRepository;
import payload.response.AccountResponse;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	@Autowired
	private AccountRepository repo;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> getAccounts(SecurityContextHolderAwareRequestWrapper w)
	{
		List<AccountResponse> tmp = new ArrayList<>();
		repo.findAll().forEach((acc) -> tmp.add(new AccountResponse(acc)));
		return ResponseEntity.ok(tmp);
	}
	
	@RequestMapping(value = {""},  params = "name", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> getAccountByNameAdmin(@RequestParam("name") String name)
	{	
		Optional<Account> acc = repo.findByName(name);
		
		if (acc.isEmpty())
			return (ResponseEntity<?>) new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		
		return ResponseEntity.ok(new AccountResponse(acc.get()));
	}
	
	@GetMapping("")
	AccountResponse getAccount(Principal p)
	{
		UserDetailsImpl userDetails = (UserDetailsImpl) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
		Account tmp = repo.findById(userDetails.getId()).orElseThrow();
		return new AccountResponse(tmp);
	}
}