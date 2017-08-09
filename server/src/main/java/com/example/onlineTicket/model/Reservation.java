/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="reservation")
public class Reservation implements Serializable {
	public Reservation() {
	}
	
	@Column(name="id", nullable=false, unique=true, length=255)	
	@Id	
	@GeneratedValue(generator="RESERVATION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="RESERVATION_ID_GENERATOR", strategy="native")	
	private String id;
	
	@ManyToOne(targetEntity=Seat.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="seatid", referencedColumnName="id", nullable=false) })	
	private Seat seat;
	
	@ManyToOne(targetEntity=Schedule.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="scheduleid", referencedColumnName="id", nullable=false) })	
	private Schedule schedule;
	
	@ManyToOne(targetEntity=Passenger.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="passengerid", referencedColumnName="id", nullable=false) })	
	private Passenger passenger;
	
	@ManyToOne(targetEntity=Route.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="routeid", referencedColumnName="id", nullable=false) })	
	private Route route;
	
	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return id;
	}
	
	public String getORMID() {
		return getId();
	}
	
	public void setPassenger(Passenger value) {
		this.passenger = value;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}
	
	public void setRoute(Route value) {
		this.route = value;
	}
	
	public Route getRoute() {
		return route;
	}
	
	public void setSeat(Seat value) {
		this.seat = value;
	}
	
	public Seat getSeat() {
		return seat;
	}
	
	public void setSchedule(Schedule value) {
		this.schedule = value;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getId());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Reservation[ ");
			sb.append("Id=").append(getId()).append(" ");
			if (getSeat() != null)
				sb.append("Seat.Persist_ID=").append(getSeat().toString(true)).append(" ");
			else
				sb.append("Seat=null ");
			if (getSchedule() != null)
				sb.append("Schedule.Persist_ID=").append(getSchedule().toString(true)).append(" ");
			else
				sb.append("Schedule=null ");
			if (getPassenger() != null)
				sb.append("Passenger.Persist_ID=").append(getPassenger().toString(true)).append(" ");
			else
				sb.append("Passenger=null ");
			if (getRoute() != null)
				sb.append("Route.Persist_ID=").append(getRoute().toString(true)).append(" ");
			else
				sb.append("Route=null ");
			sb.append("]");
			return sb.toString();
		}
	}
	
	@Transient	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
