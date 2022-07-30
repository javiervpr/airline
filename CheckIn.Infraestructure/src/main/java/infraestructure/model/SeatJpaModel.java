package infraestructure.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class SeatJpaModel {

  @Id
  @Column(nullable = false)
  private UUID code;

  @Column(nullable = false)
  private String type;

  @Column(nullable = false)
  private String status;

  @Column(nullable = false)
  private UUID flightId;

  public UUID getCode() {
    return code;
  }

  public void setCode(UUID code) {
    this.code = code;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public UUID getFlightId() {
    return flightId;
  }

  public void setFlightId(UUID flightId) {
    this.flightId = flightId;
  }
}
