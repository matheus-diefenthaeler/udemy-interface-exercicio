package services;

public interface OnlinePaymentService {

    Double paymentFee(Double ammount);
    Double interest(Double ammount, Integer months);


}
