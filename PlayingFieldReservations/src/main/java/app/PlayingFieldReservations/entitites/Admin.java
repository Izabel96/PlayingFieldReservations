package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;


@Entity
public class Admin extends User {
	
	private String firstName;
	private String lastName;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Admin() {
		super();
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId() {
		super.setId();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {
		super.setUsername(username);
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		super.setPassword(password);
	}
}
