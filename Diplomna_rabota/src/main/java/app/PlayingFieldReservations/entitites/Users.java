package app.PlayingFieldReservations.entitites;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Users {
	
	private String username;
	private String password;
	private String email;
	private int phoneNumber;
	private String firstName;
	private String lastName;
	private boolean active;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( 
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id")) 
    private Set<Role> roles = new HashSet<>();
    
    public void addRole(Role role) {
        this.roles.add(role);
}
    public Set<Role> getRoles(){
    	return roles;
    }
	
	public Users() {
		super();
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return String.format("Потребител с id: " + id + " има: " + "потребителско име: " + username + ", имейл: " 
	+ email + ", роли: " + roles + ", име: " + firstName + 
	", фамилия: " + lastName + ", статус:" + active);
	}
	
}
