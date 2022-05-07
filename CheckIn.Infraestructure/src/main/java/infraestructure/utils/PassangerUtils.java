package infraestructure.utils;

import core.BusinessRuleValidationException;
import infraestructure.model.PassangerJpaModel;
import model.Passanger;

public class PassangerUtils {

    public static PassangerJpaModel passangerToJpaEntity(Passanger passanger) {
        PassangerJpaModel passangerJpaModel = new PassangerJpaModel();
        passangerJpaModel.setBirthday(passanger.getBirthday());
        passangerJpaModel.setCi(passanger.getCi());
        passangerJpaModel.setId(passanger.getId());
        passangerJpaModel.setLastname(passanger.getLastname());
        passangerJpaModel.setName(passanger.getName());
        passangerJpaModel.setNeedAssistance(passanger.isNeedAssistance());
        return passangerJpaModel;
    }

    public static Passanger jpaModelToPassanger(PassangerJpaModel jpaModel) throws BusinessRuleValidationException {
        return new Passanger(jpaModel.getId(), jpaModel.getName(), jpaModel.getLastname(), jpaModel.getBirthday(),jpaModel.getCi(),jpaModel.isNeedAssistance());
    }
}
