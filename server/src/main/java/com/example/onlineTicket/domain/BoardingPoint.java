package com.example.onlineTicket.domain; /**
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
@Table(name="boarding_point")
public class BoardingPoint implements Serializable {
	public BoardingPoint() {
	}
	
	@Column(name="id", nullable=false, unique=true, length=255)	
	@Id	
	@GeneratedValue(generator="BOARDINGPOINT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BOARDINGPOINT_ID_GENERATOR", strategy="com.example.onlineTicket.config.generator.BoardingPointIdGenerator")
	private String id;
	
	@Column(name="address", nullable=true, length=255)	
	private String address;
	
	@ManyToMany(mappedBy="boarding_point", targetEntity=Route.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set route = new java.util.HashSet();
	
	@OneToOne(optional=false, mappedBy="boarding_point", targetEntity=Passenger.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private Passenger passenger;
	
	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return id;
	}
	
	public String getORMID() {
		return getId();
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setRoute(java.util.Set value) {
		this.route = value;
	}
	
	public java.util.Set getRoute() {
		return route;
	}
	
	
	public void setPassenger(Passenger value) {
		this.passenger = value;
	}
	
	public Passenger getPassenger() {
		return passenger;
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
			sb.append("BoardingPoint[ ");
			sb.append("Id=").append(getId()).append(" ");
			sb.append("Address=").append(getAddress()).append(" ");
			sb.append("Route.size=").append(getRoute().size()).append(" ");
			if (getPassenger() != null)
				sb.append("Passenger.Persist_ID=").append(getPassenger().toString(true)).append(" ");
			else
				sb.append("Passenger=null ");
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
