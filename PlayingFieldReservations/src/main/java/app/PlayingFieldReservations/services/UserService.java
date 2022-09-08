package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Service;



@Service
public class UserService {
	@Autowired
	FieldService fieldService;
	@Autowired
	ReservationRepository reservationRepository;

	public String reserveField(String madeBy, int id, String duration) {
		return fieldService.reserve(madeBy, id, duration);
	}
	
	public String cancelReservation(long reservationId, int fieldId) {
		Reservation toCancel =  reservationRepository.findById(reservationId);

		fieldService.changeFieldState(fieldId, "Свободно");
		reservationRepository.delete(toCancel);
		return "Резервацията е успешно отменена!";
	}
}
