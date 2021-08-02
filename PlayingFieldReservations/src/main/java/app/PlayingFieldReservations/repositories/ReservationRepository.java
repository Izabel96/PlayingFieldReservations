package app.PlayingFieldReservations.repositories;

import app.PlayingFieldReservations.entitites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation returnReservation(Reservation reservation);
}
