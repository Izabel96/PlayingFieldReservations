package app.PlayingFieldReservations.entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private long id;
    private String madeBy;
    private String fieldName;
    private String reservationDuration;

    public Reservation() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getReservationDuration() {
        return reservationDuration;
    }

    public void setReservationDuration(String reservationDuration) {
        this.reservationDuration = reservationDuration;
    }
}
