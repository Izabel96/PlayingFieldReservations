package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.PlayingFieldReservations.entitites.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByName(String name);

}
