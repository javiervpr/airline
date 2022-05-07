package infraestructure.utils;

import infraestructure.model.BaggageJpaModel;
import model.Baggage;

import java.util.Collections;
import java.util.List;

public class BaggageUtils {

    public static BaggageJpaModel baggageToJpaEntity(Baggage baggage) {
        BaggageJpaModel model = new BaggageJpaModel();
        model.setWeight(baggage.getWeight());
        model.setType(baggage.getType().toString());
        model.setId(baggage.getId());
        return model;
    }

    public static List<BaggageJpaModel> baggagesToJpaEntities(List<Baggage> baggages) {
        if (baggages == null) return Collections.emptyList();
        return baggages.stream().map( BaggageUtils::baggageToJpaEntity ).toList();
    }
}
