package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import app.PlayingFieldReservations.entitites.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findCustomerByPhoneNumber(int phoneNumber);
    void deleteByCustomerId(long customerId);

}
