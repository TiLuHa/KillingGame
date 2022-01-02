package payload.response;

import java.util.List;

import iz.netzwerk.src.Model.Account;
import iz.netzwerk.src.Model.AccountFlags;
import iz.netzwerk.src.Model.AccountRoles;

public class AccountResponse {
	public Long Id;
	public String loginName;
	public String email;
	public List<AccountFlags> flags;
	public List<AccountRoles> roles;
	
	public AccountResponse(){}
	
	public AccountResponse(Account acc){
		this.Id = acc.getId();
		this.loginName = acc.getLoginName();
		this.email = acc.getEmail();
		this.flags = acc.getFlags();
		this.roles = acc.getRoles();
	}

}
