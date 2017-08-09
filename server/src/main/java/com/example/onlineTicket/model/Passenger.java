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
@Table(name="passenger")
public class Passenger implements Serializable {
	public Passenger() {
	}
	
	@Column(name="id", nullable=false, unique=true, length=255)	
	@Id	
	@GeneratedValue(generator="PASSENGER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PASSENGER_ID_GENERATOR", strategy="native")	
	private String id;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@Column(name="address", nullable=true, length=255)	
	private String address;
	
	@Column(name="gender", nullable=true, length=1)	
	private Boolean gender;
	
	@Column(name="mobile_no", nullable=true, length=255)	
	private String mobileNo;
	
	@Column(name="email", nullable=true, length=255)	
	private String email;
	
	@OneToOne(optional=false, targetEntity=BoardingPoint.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="boarding_pointid", referencedColumnName="id", nullable=false) })	
	private BoardingPoint boarding_point;
	
	@OneToMany(mappedBy="passenger", targetEntity=Reservation.class)	
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
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setGender(boolean value) {
		setGender(new Boolean(value));
	}
	
	public void setGender(Boolean value) {
		this.gender = value;
	}
	
	public Boolean getGender() {
		return gender;
	}
	
	public void setMobileNo(String value) {
		this.mobileNo = value;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setBoarding_point(BoardingPoint value) {
		this.boarding_point = value;
	}
	
	public BoardingPoint getBoarding_point() {
		return boarding_point;
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
			sb.append("Passenger[ ");
			sb.append("Id=").append(getId()).append(" ");
			sb.append("Name=").append(getName()).append(" ");
			sb.append("Address=").append(getAddress()).append(" ");
			sb.append("Gender=").append(getGender()).append(" ");
			sb.append("MobileNo=").append(getMobileNo()).append(" ");
			sb.append("Email=").append(getEmail()).append(" ");
			if (getBoarding_point() != null)
				sb.append("Boarding_point.Persist_ID=").append(getBoarding_point().toString(true)).append(" ");
			else
				sb.append("Boarding_point=null ");
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
