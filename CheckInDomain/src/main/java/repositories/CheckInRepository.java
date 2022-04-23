package repositories;

import model.CheckIn;

import java.util.UUID;

public interface CheckInRepository {
    UUID update(CheckIn checkIn);
}
