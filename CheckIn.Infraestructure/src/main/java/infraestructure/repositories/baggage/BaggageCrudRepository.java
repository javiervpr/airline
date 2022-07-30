package infraestructure.repositories.baggage;

import infraestructure.model.BaggageJpaModel;
import infraestructure.model.CheckInJpaModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaggageCrudRepository
  extends CrudRepository<BaggageJpaModel, UUID> {
  @Query(
    "SELECT baggageJpaModel from BaggageJpaModel as baggageJpaModel where baggageJpaModel.checkIn = :checkIn"
  )
  List<BaggageJpaModel> findByCheckIn(CheckInJpaModel checkIn);
}
