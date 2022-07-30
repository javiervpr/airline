package infraestructure.repositories.passanger;

import core.BusinessRuleValidationException;
import infraestructure.model.PassangerJpaModel;
import infraestructure.utils.PassangerUtils;
import java.util.UUID;
import model.Passanger;
import org.springframework.beans.factory.annotation.Autowired;
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
}
