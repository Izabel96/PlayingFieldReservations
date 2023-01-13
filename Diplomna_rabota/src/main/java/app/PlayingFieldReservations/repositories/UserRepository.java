package app.PlayingFieldReservations.repositories;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import app.PlayingFieldReservations.entitites.Role;
import app.PlayingFieldReservations.entitites.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    //Boolean existsByEmail(String email);
    Users findByEmail(String email);
    Users findByUsername(String username);
    Users findByPhoneNumber(int phoneNumber);
    Users findById (long id);
    void deleteById(long id);
    List<Users> findByRolesIn(Set<Role> roles);

}
