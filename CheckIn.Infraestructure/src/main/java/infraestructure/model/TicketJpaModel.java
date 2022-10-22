package infraestructure.model;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public class TicketJpaModel {

    @Id
    @Column(nullable = false)
    private UUID id;

    @OneToOne
    PassangerJpaModel passenger;

    @Column(nullable = false)
    UUID flightId;

    @Column(nullable = false)
    UUID bookingId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PassangerJpaModel getPassenger() {
        return passenger;
    }

    public void setPassenger(PassangerJpaModel passenger) {
        this.passenger = passenger;
    }

    public UUID getFlightId() {
        return flightId;
    }

    public void setFlightId(UUID flightId) {
        this.flightId = flightId;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }
}
