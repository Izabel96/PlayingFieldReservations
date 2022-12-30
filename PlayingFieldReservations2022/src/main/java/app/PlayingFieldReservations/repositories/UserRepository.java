package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;



import app.PlayingFieldReservations.entitites.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Boolean existsByEmail(String email);
    Users findByEmail(String email);
    Users findByPhoneNumber(int phoneNumber);
    Users findById (long id);
    void deleteById(long id);

}
