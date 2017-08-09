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
@Table(name="schedule")
public class Schedule implements Serializable {
	public Schedule() {
	}
	
	@Column(name="id", nullable=false, unique=true, length=255)	
	@Id	
	@GeneratedValue(generator="SCHEDULE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="SCHEDULE_ID_GENERATOR", strategy="native")	
	private String id;
	
	@Column(name="`date`", nullable=true, length=255)	
	private String date;
	
	@Column(name="departure_time", nullable=true, length=255)	
	private String departureTime;
	
	@ManyToMany(targetEntity=Route.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="route_schedule", joinColumns={ @JoinColumn(name="scheduleid") }, inverseJoinColumns={ @JoinColumn(name="routeid") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set route = new java.util.HashSet();
	
	@ManyToMany(mappedBy="schedule", targetEntity=Bus.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set busno = new java.util.HashSet();
	
	@OneToMany(mappedBy="schedule", targetEntity=Reservation.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set reservation = new java.util.HashSet();
	
	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return id;
	}
	
	public String getORMID() {
		return getId();
	}
	
	public void setDate(String value) {
		this.date = value;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDepartureTime(String value) {
		this.departureTime = value;
	}
	
	public String getDepartureTime() {
		return departureTime;
	}
	
	public void setRoute(java.util.Set value) {
		this.route = value;
	}
	
	public java.util.Set getRoute() {
		return route;
	}
	
	
	public void setBusno(java.util.Set value) {
		this.busno = value;
	}
	
	public java.util.Set getBusno() {
		return busno;
	}
	
	
	public void setReservation(java.util.Set value) {
		this.reservation = value;
	}
	
	public java.util.Set getReservation() {
		return reservation;
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
			sb.append("Schedule[ ");
			sb.append("Id=").append(getId()).append(" ");
			sb.append("Date=").append(getDate()).append(" ");
			sb.append("DepartureTime=").append(getDepartureTime()).append(" ");
			sb.append("Route.size=").append(getRoute().size()).append(" ");
			sb.append("Busno.size=").append(getBusno().size()).append(" ");
			sb.append("Reservation.size=").append(getReservation().size()).append(" ");
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
