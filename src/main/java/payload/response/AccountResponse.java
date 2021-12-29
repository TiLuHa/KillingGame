package payload.response;

import java.util.List;

import iz.netwerk.src.Model.Account;
import iz.netwerk.src.Model.AccountFlags;
import iz.netwerk.src.Model.AccountRoles;

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
