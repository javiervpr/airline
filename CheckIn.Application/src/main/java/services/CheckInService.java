package services;

import org.springframework.stereotype.Service;

@Service
public interface CheckInService {
  void assignSeat(int seatId);
  void tagBaggage(float weight);
}
