package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double workerBaseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(departmentName));


        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract #" + (i+1) + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractData = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hour = sc.nextInt();
            HourContract contract = new HourContract(contractData, valuePerHour, hour);
            worker.addContract(contract);
            System.out.println();

        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        String[] datas = monthAndYear.split("/");
        int month = Integer.parseInt(datas[0]);
        int year = Integer.parseInt(datas[1]);

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + worker.income(year, month));






        sc.close();
    }
}