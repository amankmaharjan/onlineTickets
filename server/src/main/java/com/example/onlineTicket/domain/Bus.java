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
@Table(name="bus")
public class Bus implements Serializable {
	public Bus() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Bus))
			return false;
		Bus bus = (Bus)aObj;
		if ((getNo() != null && !getNo().equals(bus.getNo())) || (getNo() == null && bus.getNo() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getNo() == null ? 0 : getNo().hashCode());
		return hashcode;
	}
	
	@Column(name="no", nullable=false, unique=true, length=255)	
	@Id	
	private String no;
	
	@Column(name="seat_row", nullable=true, length=255)	
	private Integer seatRow;
	
	@Column(name="seat_column", nullable=true, length=255)	
	private Integer seatColumn;
	
	@ManyToOne(targetEntity=BusType.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="bus_typeid", referencedColumnName="id", nullable=false) })	
	private BusType bus_type;
	
	@ManyToMany(targetEntity=Service.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="service_bus", joinColumns={ @JoinColumn(name="busno") }, inverseJoinColumns={ @JoinColumn(name="serviceid") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set service = new java.util.HashSet();
	
	@ManyToMany(targetEntity=Schedule.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="schedule_bus", joinColumns={ @JoinColumn(name="busno") }, inverseJoinColumns={ @JoinColumn(name="scheduleid") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set schedule = new java.util.HashSet();
	
	@OneToMany(mappedBy="busno", targetEntity=Seat.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set seat = new java.util.HashSet();
	
	public void setNo(String value) {
		this.no = value;
	}
	
	public String getNo() {
		return no;
	}
	
	public String getORMID() {
		return getNo();
	}
	
	public void setSeatRow(int value) {
		setSeatRow(new Integer(value));
	}
	
	public void setSeatRow(Integer value) {
		this.seatRow = value;
	}
	
	public Integer getSeatRow() {
		return seatRow;
	}
	
	public void setSeatColumn(int value) {
		setSeatColumn(new Integer(value));
	}
	
	public void setSeatColumn(Integer value) {
		this.seatColumn = value;
	}
	
	public Integer getSeatColumn() {
		return seatColumn;
	}
	
	public void setService(java.util.Set value) {
		this.service = value;
	}
	
	public java.util.Set getService() {
		return service;
	}
	
	
	public void setSchedule(java.util.Set value) {
		this.schedule = value;
	}
	
	public java.util.Set getSchedule() {
		return schedule;
	}
	
	
	public void setBus_type(BusType value) {
		this.bus_type = value;
	}
	
	public BusType getBus_type() {
		return bus_type;
	}
	
	public void setSeat(java.util.Set value) {
		this.seat = value;
	}
	
	public java.util.Set getSeat() {
		return seat;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getNo());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Bus[ ");
			sb.append("No=").append(getNo()).append(" ");
			sb.append("SeatRow=").append(getSeatRow()).append(" ");
			sb.append("SeatColumn=").append(getSeatColumn()).append(" ");
			if (getBus_type() != null)
				sb.append("Bus_type.Persist_ID=").append(getBus_type().toString(true)).append(" ");
			else
				sb.append("Bus_type=null ");
			sb.append("Service.size=").append(getService().size()).append(" ");
			sb.append("Schedule.size=").append(getSchedule().size()).append(" ");
			sb.append("Seat.size=").append(getSeat().size()).append(" ");
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
