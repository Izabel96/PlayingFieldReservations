package app.PlayingFieldReservations.entitites;

import javax.persistence.*;


@MappedSuperclass
public abstract class User {
	
	private String username;
	private String password;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

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

	public long getId(){
		return id;
	}
	public void setId(){
		this.id = id;
	}
	
	
}
