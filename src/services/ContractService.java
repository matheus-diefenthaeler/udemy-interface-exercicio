package services;

import entities.Contract;
import entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){
        double installmenteValue = contract.getTotalValue()/months;

        for(int i = 1; i<=months; i++){
            Date date = addMonths(contract.getDate(), i);
            double updateQuote = installmenteValue + onlinePaymentService.interest(installmenteValue,i);
            double fullQuote = updateQuote + onlinePaymentService.paymentFee(updateQuote);
            contract.addInstallment(new Installment(date, fullQuote));
        }
    }

    private Date addMonths(Date date, int n){

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }
}
