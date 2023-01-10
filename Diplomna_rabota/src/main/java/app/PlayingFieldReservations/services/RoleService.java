package app.PlayingFieldReservations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.PlayingFieldReservations.entitites.Role;
import app.PlayingFieldReservations.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	public void addRole(Role role) {
		if((roleRepository.findAll().contains(role))) {
			throw new IllegalArgumentException("Тази роля вече съществува!");
		}else {
			roleRepository.save(role);
		}
	}
	
	public Iterable<Role> getAllRoles(){
		if(roleRepository.findAll() == null){
			System.out.println("Няма добавени роли.");
			return null;
		}
		return roleRepository.findAll();
	}
	
}
