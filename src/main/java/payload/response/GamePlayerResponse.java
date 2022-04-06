package payload.response;

import java.util.Date;

import iz.netzwerk.src.Model.Player;

public class GamePlayerResponse {
	public long id;
	public String nickName;
	public Date diedAt;
	public long score;
	
	public GamePlayerResponse()
	{}
	
	public GamePlayerResponse(Player p)
	{
		this.nickName = p.getNickName();
		this.score = p.getScore();
		this.diedAt = p.getDiedAt();
		this.id = p.getId();
	}
}
