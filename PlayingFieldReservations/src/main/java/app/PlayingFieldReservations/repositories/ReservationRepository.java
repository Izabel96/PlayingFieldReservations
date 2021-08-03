package app.PlayingFieldReservations.repositories;

import app.PlayingFieldReservations.entitites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findByMadeBy(String madeBy);
    Reservation findById(long reservationId);
}
