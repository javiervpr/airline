package dtos;

public class PaymentCompleteDto {
    public String id;
    public Body body;
}

class AccountReceivable {
    public String id;
    public OriginalValue originalValue;
    public CurrentValue currentValue;
}

class CurrentValue {
    public float data;
}

class OriginalValue {
    public float data;
}

class ReservationStatus {
    public String data;
}

class ReservationNumber {
    public String data;
}

class Payment {
    public String id;
    public TransactionNumber transactionNumber;
    public Amount amount;
    public String booking;
    public String date;
    public String _id;
    public float __v;
}

class Amount {
    public float data;
}

class TransactionNumber {
    public float data;
}