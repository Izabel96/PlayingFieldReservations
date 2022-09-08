package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.PlayingFieldReservations.entitites.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findCompanyByCompanyPhoneNumber(int companyPhoneNumber);

    Company findByEmail(String email);
    Company findById(long id);
    void deleteById(long id);
}
