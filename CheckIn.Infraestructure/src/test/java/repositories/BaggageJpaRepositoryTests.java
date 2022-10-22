package repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import builder.BaggageBuilder;
import infraestructure.model.BaggageJpaModel;
import infraestructure.model.CheckInJpaModel;
import infraestructure.repositories.baggage.BaggageCrudRepository;
import infraestructure.repositories.baggage.BaggageJpaRepository;
import infraestructure.repositories.check.in.CheckInCrudRepository;
import infraestructure.utils.BaggageUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Baggage;
import model.CheckIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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

  @Test
  void testUpdate() {
    assertDoesNotThrow(() -> {
      Baggage baggage = new BaggageBuilder()
        .withCheckInId(CHECK_IN_ID)
        .withWeight(20)
        .build();

      CheckInJpaModel checkInJpaModel = new CheckInJpaModel();
      checkInJpaModel.setId(CHECK_IN_ID);

      BaggageJpaModel baggageJpaModel = new BaggageJpaModel();
      baggageJpaModel.setId(baggage.getId());
      baggageJpaModel.setWeight(baggage.getWeight());
      baggageJpaModel.setType(baggage.getType().toString());
      baggageJpaModel.setCheckIn(checkInJpaModel);

      BaggageJpaRepository jpaRepository = new BaggageJpaRepository();
      jpaRepository.setBaggageCrudRepository(baggageCrudRepository);
      jpaRepository.setCheckInCrudRepository(checkInCrudRepository);

      when(checkInCrudRepository.findById(any()))
        .thenReturn(Optional.of(checkInJpaModel));
      when(baggageCrudRepository.save(any())).thenReturn(baggageJpaModel);
      try (
        MockedStatic<BaggageUtils> theMock = Mockito.mockStatic(
          BaggageUtils.class
        )
      ) {
        theMock
          .when(() -> BaggageUtils.baggageToJpaEntity(any(), any()))
          .thenReturn(baggageJpaModel);

        UUID result = jpaRepository.update(baggage);
        assertNotNull(result);
      }
    });
  }

  @Test
  void testFindByCheckIn() {
    assertDoesNotThrow(() -> {
      Baggage baggage = new BaggageBuilder()
        .withCheckInId(CHECK_IN_ID)
        .withWeight(20)
        .build();

      CheckInJpaModel checkInJpaModel = new CheckInJpaModel();
      checkInJpaModel.setId(CHECK_IN_ID);

      BaggageJpaModel baggageJpaModel = new BaggageJpaModel();
      baggageJpaModel.setId(baggage.getId());
      baggageJpaModel.setWeight(baggage.getWeight());
      baggageJpaModel.setType(baggage.getType().toString());
      baggageJpaModel.setCheckIn(checkInJpaModel);
      List<BaggageJpaModel> baggageJpaModels = new ArrayList<>();
      baggageJpaModels.add(baggageJpaModel);

      when(checkInCrudRepository.findById(any()))
        .thenReturn(Optional.of(checkInJpaModel));
      when(baggageCrudRepository.findByCheckIn(any()))
        .thenReturn(baggageJpaModels);

      BaggageJpaRepository jpaRepository = new BaggageJpaRepository();
      jpaRepository.setBaggageCrudRepository(baggageCrudRepository);
      jpaRepository.setCheckInCrudRepository(checkInCrudRepository);

      try (
        MockedStatic<BaggageUtils> theMock = Mockito.mockStatic(
          BaggageUtils.class
        )
      ) {
        theMock
          .when(() -> BaggageUtils.jpaToBaggage(any()))
          .thenReturn(baggage);

        List<Baggage> baggages = jpaRepository.findByCheckInId(CHECK_IN_ID);
        assertNotNull(baggages);
      }
    });
  }
}
