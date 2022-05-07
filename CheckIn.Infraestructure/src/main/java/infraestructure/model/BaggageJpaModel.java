package infraestructure.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "baggages")
public class BaggageJpaModel {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private String type;

    @ManyToOne()
//    @JoinColumn(name = , nullable = false)
    private CheckInJpaModel checkIn;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
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
