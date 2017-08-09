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
@Table(name="route")
public class Route implements Serializable {
	public Route() {
	}
	
	@Column(name="id", nullable=false, unique=true, length=255)	
	@Id	
	@GeneratedValue(generator="ROUTE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ROUTE_ID_GENERATOR", strategy="com.example.onlineTicket.config.generator.RouteIdGenerator")
	private String id;
	
	@Column(name="source", nullable=true, length=255)	
	private String source;
	
	@Column(name="destination", nullable=true, length=255)	
	private String destination;
	
	@Column(name="fare", nullable=true, length=11)	
	private Integer fare;
	
	@ManyToMany(targetEntity=BoardingPoint.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="boarding_point_route", joinColumns={ @JoinColumn(name="routeid") }, inverseJoinColumns={ @JoinColumn(name="boarding_pointid") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set boarding_point = new java.util.HashSet();
	
	@ManyToMany(mappedBy="route", targetEntity=Schedule.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set schedule = new java.util.HashSet();
	
	@OneToMany(mappedBy="route", targetEntity=Reservation.class)	
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
	
	public void setSource(String value) {
		this.source = value;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setDestination(String value) {
		this.destination = value;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setFare(int value) {
		setFare(new Integer(value));
	}
	
	public void setFare(Integer value) {
		this.fare = value;
	}
	
	public Integer getFare() {
		return fare;
	}
	
	public void setBoarding_point(java.util.Set value) {
		this.boarding_point = value;
	}
	
	public java.util.Set getBoarding_point() {
		return boarding_point;
	}
	
	
	public void setSchedule(java.util.Set value) {
		this.schedule = value;
	}
	
	public java.util.Set getSchedule() {
		return schedule;
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
			sb.append("Route[ ");
			sb.append("Id=").append(getId()).append(" ");
			sb.append("Source=").append(getSource()).append(" ");
			sb.append("Destination=").append(getDestination()).append(" ");
			sb.append("Fare=").append(getFare()).append(" ");
			sb.append("Boarding_point.size=").append(getBoarding_point().size()).append(" ");
			sb.append("Schedule.size=").append(getSchedule().size()).append(" ");
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
