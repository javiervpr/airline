package dtos;

import annotations.Generated;

@Generated
public class PaymentCompleteDto {

  public String id;
  public Body body;
}

@Generated
class AccountReceivable {

  public String id;
  public OriginalValue originalValue;
  public CurrentValue currentValue;
}

@Generated
class CurrentValue {

  public float data;
}

@Generated
class OriginalValue {

  public float data;
}

@Generated
class ReservationStatus {

  public String data;
}

@Generated
class ReservationNumber {

  public String data;
}

@Generated
class Payment {

  public String id;
  public TransactionNumber transactionNumber;
  public Amount amount;
  public String booking;
  public String date;
  public String _id;
  public float __v;
}

@Generated
class Amount {

  public float data;
}

@Generated
class TransactionNumber {

  public float data;
}
