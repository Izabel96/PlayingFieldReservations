package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import app.PlayingFieldReservations.entitites.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
