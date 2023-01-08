package app.PlayingFieldReservations.repositories;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import app.PlayingFieldReservations.entitites.Role;
import app.PlayingFieldReservations.entitites.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Boolean existsByEmail(String email);
    Optional<Users> findByEmail(String email);
    Users findByPhoneNumber(int phoneNumber);
    Users findById (long id);
    void deleteById(long id);
    //Iterable<Users> findByRole(Set<Role> roles);
    List<Users> findByRolesIn(Set<Role> roles);

}
