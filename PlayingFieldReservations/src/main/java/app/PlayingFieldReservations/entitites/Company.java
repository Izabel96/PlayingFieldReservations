package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;


@Entity
public class Company extends User {

	
	private long companyId;
	private String companyName;
	private String email;
	private int companyPhoneNumber;
	private String address;
	
	public Company() {
		super();
	}


	public long getCompanyId() {
		return super.getId();
	}

	public void setCompanyId(int companyId) {
		super.setId();
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
		return address;
	}

	public void setAdress(String adress) {
		this.address = adress;
	}
	
}
