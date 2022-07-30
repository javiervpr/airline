package infraestructure.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "check_in")
public class CheckInJpaModel {

  @Id
  @Column(nullable = false)
  private UUID id;

  @Column(nullable = false)
  private UUID flightId;

  @Column(nullable = false)
  private Date date;

  @OneToOne(optional = true)
  private SeatJpaModel seat;

  @OneToOne
  private PassangerJpaModel passanger;

  @OneToMany(mappedBy = "checkIn", cascade = CascadeType.REMOVE)
  private List<BaggageJpaModel> baggages = new ArrayList<>();

  public CheckInJpaModel() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public UUID getFlightId() {
    return flightId;
  }

  public void setFlightId(UUID flightId) {
    this.flightId = flightId;
  }

  public SeatJpaModel getSeat() {
    return seat;
  }

  public void setSeat(SeatJpaModel seat) {
    this.seat = seat;
  }

  public PassangerJpaModel getPassanger() {
    return passanger;
  }

  public void setPassanger(PassangerJpaModel passanger) {
    this.passanger = passanger;
  }

  public List<BaggageJpaModel> getBaggages() {
    return baggages;
  }

  public void setBaggages(List<BaggageJpaModel> baggages) {
    this.baggages = baggages;
  }
}
