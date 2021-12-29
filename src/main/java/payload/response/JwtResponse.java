package payload.response;

import java.util.List;

public class JwtResponse {
	public String token;
	public String type = "Bearer";
	public Long id;
	public String loginName;
	public String email;
	public List<String> roles;
	
	public JwtResponse (String token, Long id, String loginName, String email, List<String> roles) {
		this.token = token;
		this.id = id;
		this.loginName = loginName;
		this.email = email;
		this.roles = roles;
	}
}
