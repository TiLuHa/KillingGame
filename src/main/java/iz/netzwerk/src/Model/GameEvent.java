package iz.netzwerk.src.Model;

import java.util.Date;
import java.time.*;

import javax.persistence.*;

@Entity
public class GameEvent {
	@Id
	private String name;

	@Column
	private LocalDateTime when;
	
	@Column
	private LocalDateTime next;
	
	@Column
	private long intervallInMS;
	
	public GameEvent()
	{
		this.name = "Not assigned";
		this.when = null;
		this.next = null;
		this.intervallInMS = 0;
	}

	public GameEvent(String name)
	{
		this.name = name;
		this.when = null;
		this.next = null;
		this.intervallInMS = 0;
	}
	
	public GameEvent(String name, LocalDateTime when)
	{
		this.name = name;
		this.when = when;
		this.next = null;
		this.intervallInMS = 0;
	}
	
	public GameEvent(String name, LocalDateTime when, long intervall)
	{
		this.name = name;
		this.when = when;
		this.next = when;
		this.intervallInMS = intervall;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public LocalDateTime getDate()
	{
		return this.when;
	}
	
	public LocalDateTime getNext()
	{
		return this.next;
	}
	
	public long getIntervall()
	{
		return this.intervallInMS;
	}
	
	public boolean update()
	{
		if (next == null)
			return false;
		
		if (next.isBefore(LocalDateTime.now()))
		{
			next = next.plusNanos(intervallInMS * 1000);
			return true;
		}
		
		return false;
	}
}
