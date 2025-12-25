package HospitalPatientManagementSystemSimulation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalSystem hospital = new HospitalSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Hastane Yönetim Sistemine Hoş Geldiniz ===");

        while (running) {
            System.out.println("\n1. Yeni Hasta Kaydı");
            System.out.println("2. Tedavi İsteği Oluştur");
            System.out.println("3. Tedavi İşle (Sıradaki Hasta)");
            System.out.println("4. Tüm Hastaları Ciddiyete Göre Sırala");
            System.out.println("5. Sistem Durumunu Görüntüle");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Hasta ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("İsim Soyisim: ");
                    String name = scanner.nextLine();
                    System.out.print("Ciddiyet (1-10): ");
                    int severity = scanner.nextInt();
                    System.out.print("Yaş: ");
                    int age = scanner.nextInt();

                    hospital.addPatient(new Patient(id, name, severity, age));
                    System.out.println("Hasta sisteme kaydedildi.");
                    break;

                case 2:
                    System.out.print("Hasta ID: ");
                    int pId = scanner.nextInt();
                    System.out.print("Acil durum mu? (true/false): ");
                    boolean isPriority = scanner.nextBoolean();

                    hospital.addTreatmentRequest(pId, isPriority);
                    System.out.println("Talep kuyruğa eklendi.");
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
                    System.out.println("Sistemden çıkılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
        scanner.close();
    }
}