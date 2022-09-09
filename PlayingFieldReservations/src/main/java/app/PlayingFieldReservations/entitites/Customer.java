package app.PlayingFieldReservations.entitites;

import javax.persistence.*;


@Entity
public class Customer extends User {

	private long customerId;
	private String firstName;
	private String lastName;
	private String email;
	private int phoneNumber;

	public Customer() {
		super();
	}

	public long getCustomerId() {
		return super.getId();
	}

	public void setCustomerId(long customerId) {
		super.setId();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
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
