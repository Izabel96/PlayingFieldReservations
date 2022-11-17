package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import app.PlayingFieldReservations.entitites.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
    User findByEmail(String email);
    User findByPhoneNumber(int phoneNumber);
    User findById (long id);
    void deleteById(long id);

}
