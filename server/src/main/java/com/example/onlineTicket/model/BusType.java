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
@Table(name="bus_type")
public class BusType implements Serializable {
	public BusType() {
	}
	
	@Column(name="id", nullable=false, unique=true, length=255)	
	@Id	
	@GeneratedValue(generator="BUSTYPE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BUSTYPE_ID_GENERATOR", strategy="native")	
	private String id;
	
	@Column(name="bus_type", nullable=true, length=255)	
	private String busType;
	
	@OneToMany(mappedBy="bus_type", targetEntity=Bus.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set bus = new java.util.HashSet();
	
	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return id;
	}
	
	public String getORMID() {
		return getId();
	}
	
	public void setBusType(String value) {
		this.busType = value;
	}
	
	public String getBusType() {
		return busType;
	}
	
	public void setBus(java.util.Set value) {
		this.bus = value;
	}
	
	public java.util.Set getBus() {
		return bus;
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
			sb.append("BusType[ ");
			sb.append("Id=").append(getId()).append(" ");
			sb.append("BusType=").append(getBusType()).append(" ");
			sb.append("Bus.size=").append(getBus().size()).append(" ");
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
