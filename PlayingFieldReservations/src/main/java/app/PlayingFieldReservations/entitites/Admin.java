package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;


@Entity
public class Admin extends User {

	
	private int id;
	
	public Admin() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
