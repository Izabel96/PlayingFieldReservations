package app.PlayingFieldReservations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.repositories.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	FieldService fieldService;
	@Autowired
	ReservationRepository reservationRepository;

	public String reserveField(String madeBy, int id, String duration) {
		return fieldService.reserve(madeBy, id, duration);
	}
	
	public String cancelReservation(long reservationId, int fieldId) {
			Reservation toCancel = reservationRepository.findById(reservationId);
			String reservationPeriod = toCancel.getReservationDuration();

			fieldService.changeFieldState(fieldId, "Свободно");
			reservationRepository.delete(toCancel);
			return "Резервацията е успешно отменена!";
		}
	
    public Iterable<Reservation> getReservationHistory(String madeBy){
        return reservationRepository.findAllByMadeBy(madeBy);
    }
    
    public Iterable<Reservation> viewAllReservations () { //works
        if (reservationRepository.findAll().isEmpty()) {
            return null;
        } else {
            return reservationRepository.findAll();
        }
    }
	
}
