package app.PlayingFieldReservations.entitites;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	
	public Field() {
		super();
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
		String convertedPrice = String.format("%.2f", price);
		String newLine = System.lineSeparator();
		return String.format("Спортно игрище " + fieldName + ": идентификационен номер: " + fieldId + ",  локация: " + location + ", вид: " + type
				+ ", състояние: " + state + ", цена: " + convertedPrice + ", контакт: " + contactInformation
				+ ", работно време: " + workingHours + newLine);
	}
	
	
	
	
	
}
