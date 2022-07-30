package infraestructure.model;

import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "baggages")
public class BaggageJpaModel {

  @Id
  @Column(nullable = false)
  private UUID id;

  @Column(nullable = false)
  private float weight;

  @Column(nullable = false)
  private String type;

  @ManyToOne
  private CheckInJpaModel checkIn;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public float getWeight() {
    return weight;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public CheckInJpaModel getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(CheckInJpaModel checkIn) {
    this.checkIn = checkIn;
  }
}
