package application;

import entities.Contract;
import entities.Installment;

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
        Integer number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (dd/MM/yyyy):");
        Date date = sdf.parse(sc.nextLine());
        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();
        System.out.println("Enter number of installments ");
        int installment = sc.nextInt();

        Contract c1 = new Contract(number, date, contractValue);

        double installmenteValue = contractValue/installment;

        cal.setTime(date);

        for(int i = 1 ; i<=installment; i++){
        double aux = 0;
        double total = 0;
        aux = installmenteValue * (Math.pow(1.01,i));
        total = aux * 1.02;

        cal.add(Calendar.MONTH,1);

        date = cal.getTime();

            c1.addInstallment(new Installment(date,total));

        }

        System.out.println("Instalments: ");

        for(Installment i : c1.getInstallments()){
            System.out.println(i);
        }
        sc.close();

    }
}
