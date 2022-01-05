package payload.response;

import java.util.Date;
import java.util.List;

import iz.netzwerk.src.Model.Game;
import iz.netzwerk.src.Model.GameKillingMethod;

public class GameResponse {
	public Long Id;
	public String name;
	public List<GameKillingMethod> killingMethods;
	public Date startsAt;
	public Date endsAt;
	
	public GameResponse(Game g)
	{
		this.Id = g.getId();
		this.name = g.getName();
		this.killingMethods = g.getKillingMethods();
		this.startsAt = g.getStartTime();
		this.endsAt = g.getEndTime();
	}
}
