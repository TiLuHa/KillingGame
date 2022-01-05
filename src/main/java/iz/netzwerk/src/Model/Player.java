package iz.netzwerk.src.Model;

import java.util.Date;
import java.util.List;

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
	
	@OneToMany
	private List<Game> adminOfGames;
}
