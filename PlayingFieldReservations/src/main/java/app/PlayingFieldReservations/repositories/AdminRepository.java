package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.PlayingFieldReservations.entitites.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Boolean existsByEmail(String email);
    Admin findByEmail(String email);

}
