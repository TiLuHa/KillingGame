package payload.response;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.OneToOne;

import iz.netzwerk.src.Model.Mission;
import iz.netzwerk.src.Model.Player;

public class GamePlayerResponse {
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
	}
}
