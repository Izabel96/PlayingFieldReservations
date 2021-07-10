package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;


@Entity
public class Admin extends User {

	
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
