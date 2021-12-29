package iz.netwerk.src.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iz.netwerk.src.JwtUtils;
import iz.netwerk.src.Model.Account;
import payload.request.LoginRequest;
import payload.request.RegisterRequest;
import payload.response.MessageResponse;
import iz.netwerk.src.repositories.AccountRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AccountRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.loginName, loginRequest.password));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return ResponseEntity.ok(jwtUtils.generateJwtResponse(jwtUtils.generateJwtToken(authentication), authentication));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterRequest signUpRequest) {
		if (!userRepository.findByName(signUpRequest.loginName).isEmpty()) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (!userRepository.findByEmail(signUpRequest.email).isEmpty()) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		Account user = new Account(signUpRequest.loginName,
							 encoder.encode(signUpRequest.password),
							 signUpRequest.email);

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
