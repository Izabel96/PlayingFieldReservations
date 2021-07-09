package app.PlayingFieldReservations.repositories;

import org.springframework.data.repository.CrudRepository;

import app.PlayingFieldReservations.entitites.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
