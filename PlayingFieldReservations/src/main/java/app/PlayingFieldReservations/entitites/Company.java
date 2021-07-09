package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company extends User {

	@Id @GeneratedValue
	private int companyId;
	private String companyName;
	private String email;
	private int companyPhoneNumber;
	private String adress;
	
	public Company(String username, String password, int companyId, String companyName, String email, int companyPhoneNumber, String adress) {
		super(username, password);
		this.companyId = companyId;
		this.companyName = companyName;
		this.email = email; 
		this.companyPhoneNumber = companyPhoneNumber;
		this.adress = adress;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCompanyPhoneNumber() {
		return companyPhoneNumber;
	}

	public void setCompanyPhoneNumber(int companyPhoneNumber) {
		this.companyPhoneNumber = companyPhoneNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
}
