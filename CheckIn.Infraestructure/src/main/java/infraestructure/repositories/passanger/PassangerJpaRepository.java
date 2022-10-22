package infraestructure.repositories.passanger;

import core.BusinessRuleValidationException;
import dtos.PassangerDto;
import infraestructure.model.PassangerJpaModel;
import infraestructure.utils.PassangerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.Passanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import repositories.PassangerRepository;

@Repository
public class PassangerJpaRepository implements PassangerRepository {

  @Autowired
  private PassangerCrudRepository passangerCrudRepository;

  @Override
  public UUID update(Passanger passanger) {
    PassangerJpaModel jpaModel = PassangerUtils.passangerToJpaEntity(passanger);
    return passangerCrudRepository.save(jpaModel).getId();
  }

  @Override
  public Passanger get(UUID id) throws BusinessRuleValidationException {
    PassangerJpaModel jpaModel = passangerCrudRepository
      .findById(id)
      .orElse(null);
    if (jpaModel == null) return null;
    return PassangerUtils.jpaModelToPassanger(jpaModel);
  }

  @Override
  public List<Passanger> getAll() throws BusinessRuleValidationException {
    List<PassangerJpaModel> jpaModels = Streamable.of(passangerCrudRepository.findAll()).toList();
    List<Passanger> passengers = new ArrayList<>();
    for (PassangerJpaModel jpaModel: jpaModels) {
      passengers.add(PassangerUtils.jpaModelToPassanger(jpaModel));
    }
    return passengers;
  }
}
