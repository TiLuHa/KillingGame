package payload.response;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import iz.netzwerk.src.Model.Account;
import iz.netzwerk.src.Model.Game;
import iz.netzwerk.src.Model.GameKillingMethod;
import iz.netzwerk.src.Model.Player;

public class GameResponse {
	public Long Id;
	public String name;
	public List<GameKillingMethod> killingMethods;
	public Date startsAt;
	public Date endsAt;
	public String code;
	public Account creator;
	public List<GamePlayerResponse> players;
	public List<GamePlayerResponse> leaders;
	
	public GameResponse()
	{}
	
	public GameResponse(Game g)
	{
		this.Id = g.getId();
		this.name = g.getName();
		this.killingMethods = g.getKillingMethods();
		this.startsAt = g.getStartTime();
		this.endsAt = g.getEndTime();
		this.code = g.getCode();
		this.creator = g.getCreator();
		this.leaders = new LinkedList<>();
		this.players = new LinkedList<>();
	}

	public GameResponse(Game g, List<Player> leaders)
	{
		this(g);
		leaders.forEach((l) -> this.leaders.add(new GamePlayerResponse(l)));
	}
	
	public GameResponse(Game g, List<Player> players, List<Player> leaders)
	{
		this(g, leaders);
		players.forEach((p) -> this.players.add(new GamePlayerResponse(p)));
	}
}
