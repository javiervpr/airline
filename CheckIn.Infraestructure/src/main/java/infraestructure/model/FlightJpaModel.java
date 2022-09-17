package infraestructure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "flights")
public class FlightJpaModel {

    @Id
    @Column(nullable = false)
    private UUID code;
}
