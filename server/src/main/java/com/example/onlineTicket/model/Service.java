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
@Table(name="service")
public class Service implements Serializable {
	public Service() {
	}
	
	@Column(name="id", nullable=false, unique=true, length=11)	
	@Id	
	@GeneratedValue(generator="SERVICE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="SERVICE_ID_GENERATOR", strategy="identity")	
	private int id;
	
	@Column(name="service_type", nullable=true, length=255)	
	private String serviceType;
	
	@ManyToMany(mappedBy="service", targetEntity=Bus.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set busno = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setServiceType(String value) {
		this.serviceType = value;
	}
	
	public String getServiceType() {
		return serviceType;
	}
	
	public void setBusno(java.util.Set value) {
		this.busno = value;
	}
	
	public java.util.Set getBusno() {
		return busno;
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
			sb.append("Service[ ");
			sb.append("Id=").append(getId()).append(" ");
			sb.append("ServiceType=").append(getServiceType()).append(" ");
			sb.append("Busno.size=").append(getBusno().size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
