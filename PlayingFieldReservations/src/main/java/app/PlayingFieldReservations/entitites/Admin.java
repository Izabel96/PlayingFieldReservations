package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin extends User {

	@Id @GeneratedValue
	private int id;
	
	public Admin(String username, String password, int id) {
		super(username, password);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
