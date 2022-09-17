package repositories;

import builder.BaggageBuilder;
import infraestructure.model.BaggageJpaModel;
import infraestructure.model.CheckInJpaModel;
import infraestructure.repositories.baggage.BaggageCrudRepository;
import infraestructure.repositories.baggage.BaggageJpaRepository;
import infraestructure.repositories.check.in.CheckInCrudRepository;
import infraestructure.utils.BaggageUtils;
import model.Baggage;
import model.CheckIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

class BaggageJpaRepositoryTests {

    @Mock
    BaggageCrudRepository baggageCrudRepository;
    @Mock
    CheckInCrudRepository checkInCrudRepository;

    private static final UUID FLIGHT_ID = UUID.randomUUID();
    private static final UUID CHECK_IN_ID = UUID.randomUUID();
    private static final UUID SEAT_ECONOMY_FREE_CODE = UUID.randomUUID();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void testUpdate() {
//        assertDoesNotThrow(() -> {
//            Baggage baggage = new BaggageBuilder()
//                    .withCheckInId(CHECK_IN_ID)
//                    .withWeight(20)
//                    .build();
//
//            CheckInJpaModel checkInJpaModel = new CheckInJpaModel();
//            checkInJpaModel.setId(CHECK_IN_ID);
//
//            BaggageJpaModel baggageJpaModel = new BaggageJpaModel();
//            baggageJpaModel.setId(baggage.getId());
//            baggageJpaModel.setWeight(baggage.getWeight());
//            baggageJpaModel.setType(baggage.getType().toString());
//            baggageJpaModel.setCheckIn(checkInJpaModel);
//
//
//
//            BaggageJpaRepository jpaRepository = new BaggageJpaRepository();
//            jpaRepository.setBaggageCrudRepository(baggageCrudRepository);
//            jpaRepository.setCheckInCrudRepository(checkInCrudRepository);
//
//            when(checkInCrudRepository.findById(anyObject())).thenReturn(Optional.of(checkInJpaModel));
//            when(BaggageUtils.baggageToJpaEntity(any(), any())).thenReturn(baggageJpaModel);
//            when(baggageCrudRepository.save(anyObject())).thenReturn(checkInJpaModel);
//
//            UUID result = jpaRepository.update(baggage);
//            assertEquals(checkInJpaModel.getId(), result);
//        });
//
//    }

}
