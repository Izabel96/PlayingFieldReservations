package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;
@Entity
public class Company extends User {

	
	private String companyName;
	private String address;
	
	public Company() {
		super();
	}



	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getAdress() {
		return address;
	}

	public void setAdress(String adress) {
		this.address = adress;
	}



	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}



	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}



	@Override
	public int getPhoneNumber() {
		// TODO Auto-generated method stub
		return super.getPhoneNumber();
	}



	@Override
	public void setPhoneNumber(int phoneNumber) {
		// TODO Auto-generated method stub
		super.setPhoneNumber(phoneNumber);
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}



	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		super.setUsername(username);
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}



	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}






	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}


	@Override
	public void setId() {
		// TODO Auto-generated method stub
		super.setId();
	}
	
	
	
}
