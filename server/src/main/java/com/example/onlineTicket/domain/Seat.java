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
@Table(name="seat")
public class Seat implements Serializable {
	public Seat() {
	}
	
	@Column(name="id", nullable=false, unique=true, length=255)	
	@Id	
	@GeneratedValue(generator="SEAT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="SEAT_ID_GENERATOR", strategy="com.example.onlineTicket.config.generator.SeatIdGenerator")
	private String id;
	
	@Column(name="seat_name", nullable=true, length=255)	
	private String seatName;
	
	@Column(name="seat_map_value_x", nullable=true, length=255)	
	private Integer seatMapValueX;
	
	@Column(name="seat_map_value_y", nullable=true, length=255)	
	private Integer seatMapValueY;
	
	@ManyToOne(targetEntity=Bus.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="busno", referencedColumnName="no", nullable=false) })	
	private Bus busno;
	
	@OneToMany(mappedBy="seat", targetEntity=Reservation.class)	
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
	
	public void setSeatName(String value) {
		this.seatName = value;
	}
	
	public String getSeatName() {
		return seatName;
	}
	
	public void setSeatMapValueX(int value) {
		setSeatMapValueX(new Integer(value));
	}
	
	public void setSeatMapValueX(Integer value) {
		this.seatMapValueX = value;
	}
	
	public Integer getSeatMapValueX() {
		return seatMapValueX;
	}
	
	public void setSeatMapValueY(int value) {
		setSeatMapValueY(new Integer(value));
	}
	
	public void setSeatMapValueY(Integer value) {
		this.seatMapValueY = value;
	}
	
	public Integer getSeatMapValueY() {
		return seatMapValueY;
	}
	
	public void setBusno(Bus value) {
		this.busno = value;
	}
	
	public Bus getBusno() {
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
			sb.append("Seat[ ");
			sb.append("Id=").append(getId()).append(" ");
			sb.append("SeatName=").append(getSeatName()).append(" ");
			sb.append("SeatMapValueX=").append(getSeatMapValueX()).append(" ");
			sb.append("SeatMapValueY=").append(getSeatMapValueY()).append(" ");
			if (getBusno() != null)
				sb.append("Busno.Persist_ID=").append(getBusno().toString(true)).append(" ");
			else
				sb.append("Busno=null ");
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
