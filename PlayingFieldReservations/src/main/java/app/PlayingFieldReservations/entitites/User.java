package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class User {
	
	private String username;
	@Id
	private String password;

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
