package payload.response;

import iz.netzwerk.src.Model.KillingMethod;

public class KillingMethodResponse {
	public Long Id;
	public String description;
	public boolean gameUnique;
	
	public KillingMethodResponse(){}
	
	public KillingMethodResponse(KillingMethod km)
	{
		this.Id = km.getId();
		this.description = km.getDescription();
		this.gameUnique = km.getGameUniqunes();
	}
}
