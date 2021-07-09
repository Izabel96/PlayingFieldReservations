package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Field {
	@Id @GeneratedValue
	
	private int fieldId;
	private String fieldName;
	private String location;
	private String type;
	private String state;
	private double price;
	private String contactInformation;
	private String workingHours;
	
	
	
	public Field(int fieldId, String fieldName, String location, String type, String state, double price, String contactInformation,
			String workingHours) {
		super();
		this.fieldId = fieldId;
		this.fieldName = fieldName;
		this.location = location;
		this.type = type;
		this.state = state;
		this.price = price;
		this.contactInformation = contactInformation;
		this.workingHours = workingHours;
	}
	
	
	public int getFieldId() {
		return fieldId;
	}


	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}


	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}


	@Override
	public String toString() {
		return "Field [fieldId=" + fieldId + ", fieldName=" + fieldName + ", location=" + location + ", type=" + type
				+ ", state=" + state + ", price=" + price + ", contactInformation=" + contactInformation
				+ ", workingHours=" + workingHours + "]";
	}
	
	
	
	
	
}
