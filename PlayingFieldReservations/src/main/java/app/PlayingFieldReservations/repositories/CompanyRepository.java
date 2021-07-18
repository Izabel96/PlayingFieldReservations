package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import app.PlayingFieldReservations.entitites.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findById(int companyId);
}
