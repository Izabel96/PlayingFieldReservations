package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    private String name;

    public Role() { }
    
    public Role(String name) {
        this.name = name;
    }
     
    public Role(Long roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }
 
    public Role(Long roleId) {
        this.roleId = roleId;
    }
    
     
 
    public Long getRoleId() {
		return roleId;
	}

	public void setId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return this.name;
    }
}
	

