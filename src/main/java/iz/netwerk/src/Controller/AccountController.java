package iz.netwerk.src.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import iz.netwerk.src.Model.Account;
import iz.netwerk.src.repositories.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	private AccountRepository repo;
	
	@GetMapping("/accounts")
	List<Account> getAccounts()
	{
		return (List<Account>) repo.findAll();
	}

	@RequestMapping(value = {"/account"},  params = "id", method = RequestMethod.GET)
	Optional<Account> getAccountById(@RequestParam("id") Long id)
	{
		return repo.findById(id);
	}
	
	@RequestMapping(value = {"/account"},  params = "name", method = RequestMethod.GET)
	Optional<Account> getAccountByName(@RequestParam("name") String name)
	{
		return repo.findByName(name);
	}
	
	@PostMapping("/account/register")
	Account newAccount(@RequestBody Account newAccount)
	{
		return repo.save(newAccount);
	}
	
	@PatchMapping(value = {"/account"}, params = "id")
	int patchAccount(@RequestBody Account patchAccount, @RequestParam("id") Long id)
	{
		Optional<Account> tmp = repo.findById(id);
		int changedEntrys = 0;
		
		if (tmp.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		if (!(patchAccount.password == null))
			changedEntrys += repo.updatePassword(patchAccount.password, tmp.orElseThrow().Id);
		
		if (!(patchAccount.loginName == null))
			changedEntrys += repo.updateLoginName(patchAccount.loginName, tmp.orElseThrow().Id);
		
		if (!(patchAccount.email == null))
			changedEntrys += repo.updateEmail(patchAccount.email, tmp.orElseThrow().Id);
		
		return changedEntrys;
	}
}