package app.PlayingFieldReservations.entitites;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@MappedSuperclass
public abstract class User {
	
	private String username;
	private String password;
	private String email;
	private int phoneNumber;
	@Id
	//@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @ManyToMany 
    @JoinTable( 
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id")) 
    private Set<Role> roles = new HashSet<>();
    
    public void addRole(Role role) {
        this.roles.add(role);
}
	
	public User() {
		super();
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
