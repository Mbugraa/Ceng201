package HospitalPatientManagementSystemSimulation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalSystem hospital = new HospitalSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Hospital Management System ");

        while (running) {
            System.out.println("\n1. New patient register");
            System.out.println("2. Create Treatment Request");
            System.out.println("3. Treatment Process (Next Patient)");
            System.out.println("4. Sort all patients by importance.");
            System.out.println("5. Show the system ");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name and Surname : ");
                    String name = scanner.nextLine();
                    System.out.print("Importance (1-10): ");
                    int severity = scanner.nextInt();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();

                    hospital.addPatient(new Patient(id, name, severity, age));
                    System.out.println("Patient has been registered");
                    break;

                case 2:
                    System.out.print("Patient ID: ");
                    int pId = scanner.nextInt();
                    System.out.print("Emergency? (true/false): ");
                    boolean isPriority = scanner.nextBoolean();

                    hospital.addTreatmentRequest(pId, isPriority);
                    System.out.println("Request added to queue.");
                    break;

                case 3:
                    hospital.processTreatment();
                    break;

                case 4:
                    hospital.sortPatientsBySeverity();
                    break;

                case 5:
                    hospital.printStatus();
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting to system..");
                    break;

                default:
                    System.out.println("Unvalid choice!");
            }
        }
    }}