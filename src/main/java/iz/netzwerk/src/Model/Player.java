package iz.netzwerk.src.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Player {
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(nullable = false)
	private String nickName;
	
	@OneToOne
	private Mission mission;
	
	@Column
	private Date missionRequestedAt;
	
	@Column
	private Date diedAt;
	
	public Player()
	{}
	
	public Player(String nickName)
	{
		this.nickName = nickName;
	}

	public Long getId() {
		return Id;
	}

	public String getNickName() {
		return nickName;
	}

	public Mission getMission() {
		return mission;
	}

	public Date getMissionRequestedAt() {
		return missionRequestedAt;
	}

	public Date getDiedAt() {
		return diedAt;
	}
}
