package app.PlayingFieldReservations.services;

import java.util.ArrayList;
import java.util.List;

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
	
	public String cancelReservation(long reservationId, int fieldId) { //TODO: check if there is such reservation
			Reservation toCancel = reservationRepository.findById(reservationId);
			String reservationPeriod = toCancel.getReservationDuration();

			//duration should be removed from state
			fieldService.changeFieldState(fieldId, "Свободно"); //this is wrong
			reservationRepository.delete(toCancel);
			return "Резервацията е успешно отменена!";
		}
	
    public String getReservationHistory(String madeBy){
    	String outputString = "";
    	List<Reservation> allReservations = reservationRepository.findAll();
    	List<Reservation> reservationsByUser = new ArrayList<>();
    	
    	for (Reservation reservation : allReservations) {
    		String nameString = reservation.getMadeBy();
    		System.out.println(nameString);
    		System.out.println(madeBy);
			if(reservation.getMadeBy().equals(madeBy)) {
				reservationsByUser.add(reservation);
			}
		}
    	System.out.println(reservationsByUser);
    	if(reservationsByUser.isEmpty()) {
    		outputString = "Все още нямате направени резервации!";
    	}else {
    		for (Reservation reservation : reservationsByUser) {
    			outputString = outputString + reservation.toString() + ", ";
    		}
    	}
    	return outputString;
    }
    
    public Iterable<Reservation> viewAllReservations () { //works
        if (reservationRepository.findAll().isEmpty()) {
            return null;
        } else {
            return reservationRepository.findAll();
        }
    }
	
}
