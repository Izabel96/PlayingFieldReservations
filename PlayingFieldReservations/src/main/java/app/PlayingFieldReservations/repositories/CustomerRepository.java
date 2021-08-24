package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import app.PlayingFieldReservations.entitites.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findById(long customerId);
    void deleteByCustomerId(long customerId);

}
