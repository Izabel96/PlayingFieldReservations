package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import app.PlayingFieldReservations.entitites.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findById(int customerId);

}
