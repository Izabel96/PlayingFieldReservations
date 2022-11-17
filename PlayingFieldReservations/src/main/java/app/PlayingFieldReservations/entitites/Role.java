package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Role() { }
    
    public Role(String name) {
        this.name = name;
    }
     
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public Role(Long id) {
        this.id = id;
    }
    
     
 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	

