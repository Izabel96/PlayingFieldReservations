package app.PlayingFieldReservations.repositories;

import app.PlayingFieldReservations.entitites.Reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByFieldNameAndReservationDuration(String fieldName, String reservationDuration);
    Reservation findById(long reservationId);
}
