package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Calendar cal = Calendar.getInstance();

        System.out.println("Enter contract data:");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (dd/MM/yyyy):");
        Date date = sdf.parse(sc.nextLine());
        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();

        Contract c1 = new Contract(number, date, contractValue);

        System.out.println("Enter number of installments ");
        int installment = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(c1, installment);

        System.out.println("Instalments:");


        for(Installment x : c1.getInstallments()){
            System.out.println(x);
        }

        sc.close();

    }
}
