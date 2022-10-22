package repositories;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import builder.SeatBuilder;
import infraestructure.model.SeatJpaModel;
import infraestructure.repositories.seat.SeatCrudRepository;
import infraestructure.repositories.seat.SeatJpaRepository;
import infraestructure.utils.BaggageUtils;
import infraestructure.utils.SeatUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Seat;
import model.SeatStatus;
import model.SeatType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SeatJpaRepositoryTests {

  @Mock
  private SeatCrudRepository seatCrudRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testUpdate() {
    assertDoesNotThrow(() -> {
      UUID flightId = UUID.randomUUID();
      Seat seat = new SeatBuilder()
        .withFlightId(flightId)
        .withStatus(SeatStatus.FREE)
        .withType(SeatType.ECONOMY)
        .build();
      SeatJpaModel seatJpaModel = new SeatJpaModel();
      seatJpaModel.setCode(UUID.randomUUID());
      seatJpaModel.setType(SeatType.ECONOMY.toString());
      seatJpaModel.setStatus(SeatStatus.FREE.toString());
      seatJpaModel.setFlightId(flightId);
      seatJpaModel.setRowColumn("5_1");

      SeatJpaRepository seatJpaRepository = new SeatJpaRepository();
      seatJpaRepository.setSeatCrudRepository(seatCrudRepository);

      when(seatCrudRepository.save(any())).thenReturn(seatJpaModel);
      try (
        MockedStatic<SeatUtils> theMock = Mockito.mockStatic(SeatUtils.class)
      ) {
        theMock
          .when(() -> SeatUtils.seatToJpaEntity(any()))
          .thenReturn(seatJpaModel);

        seatJpaRepository.update(seat);
      }
    });
  }
}
