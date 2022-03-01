package iz.netzwerk.src.Controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iz.netzwerk.src.Model.KillingMethod;
import iz.netzwerk.src.repositories.KillingMethodRepository;
import payload.request.KillingMethodRequest;
import payload.response.KillingMethodResponse;

@RestController
@RequestMapping("/api/killingmethods")
public class KillingMethodController
{
	@Autowired
	KillingMethodRepository repo;
	
	@GetMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<KillingMethodResponse> getMethods()
	{
		ArrayList<KillingMethodResponse> tmp = new ArrayList<KillingMethodResponse>();
		repo.findAll().forEach((km) -> tmp.add(new KillingMethodResponse(km)));
		return tmp;
	}
	
	@PostMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	public KillingMethodResponse addMethod(@RequestBody KillingMethodRequest killingMethodRequest)
	{
		KillingMethod tmp = new KillingMethod(killingMethodRequest.description, killingMethodRequest.gameUnique);
		tmp = repo.save(tmp);
		return new KillingMethodResponse(tmp);
	}
	
	@GetMapping("/{Id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> getMethod(@PathVariable(value = "Id") Long id)
	{
		Optional<KillingMethod> tmp = repo.findById(id);
		
		if (tmp.isEmpty())
			return (ResponseEntity<?>) new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		
		return ResponseEntity.ok(tmp.get());
	}
}
