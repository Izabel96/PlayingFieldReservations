package app.PlayingFieldReservations.services;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PDLOverrideSupported;

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

	public String reserveField(String madeBy, int id, String duration) { //works
		return fieldService.reserve(madeBy, id, duration);
	}
	
	public String cancelReservation(long reservationId, int fieldId) { //TODO: fix state issue
			Reservation toCancel = reservationRepository.findById(reservationId);
			if(toCancel == null) {
				return "Няма резервация с този номер!";
			}else {
				String reservationPeriod = toCancel.getReservationDuration();
				//duration should be removed from state
				String stateToRemove = "Резервирано за " + reservationPeriod;
				fieldService.changeFieldState(fieldId, stateToRemove); //this is wrong
				reservationRepository.delete(toCancel);
				return "Резервацията е успешно отменена!";
			}
		}
	
    public String getReservationHistory(String madeBy){ //works
    	String outputString = "";
    	List<Reservation> allReservations = reservationRepository.findAll();
    	List<Reservation> reservationsByUser = new ArrayList<>();
    	
    	for (Reservation reservation : allReservations) {
			if(reservation.getMadeBy().equals(madeBy)) {
				reservationsByUser.add(reservation);
			}
		}
    	if(reservationsByUser.isEmpty()) {
    		outputString = "Все още нямате направени резервации!";
    	}else {
    		for (Reservation reservation : reservationsByUser) {
    			String toString = "Резервация с номер " + reservation.getId() + " за игрище " 
    		+ reservation.getFieldName() + "за периода: " + reservation.getReservationDuration();
    			outputString = outputString + toString;
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
