package HospitalPatientManagementSystemSimulation;

import java.util.HashMap;
import java.util.ArrayList;

public class HospitalSystem {
    private PatientList patients = new PatientList();
    private TreatmentQueue normalQueue = new TreatmentQueue();
    private TreatmentQueue priorityQueue = new TreatmentQueue(); // Acil vakalar için
    private DischargeStack discharges = new DischargeStack();
    private HashMap<Integer, Patient> patientLookup = new HashMap<>();

    // 1. Yeni Hasta Ekleme (Hızlı lookup için HashMap'e de ekliyoruz)
    public void addPatient(Patient p) {
        patients.addPatient(p);
        patientLookup.put(p.id, p);
    }

    public void addTreatmentRequest(int patientId, boolean isPriority) {
        TreatmentRequest req = new TreatmentRequest(patientId, isPriority);
        if (isPriority) {
            priorityQueue.enqueue(req);
        } else {
            normalQueue.enqueue(req);
        }
    }





    // 3. Tedavi Sürecini İşletme (Önce Priority Kuyruğu)
    public void processTreatment() {
        TreatmentRequest req = null;

        if (priorityQueue.size() > 0) {
            req = priorityQueue.dequeue();
            System.out.println("Processing PRIORITY patient: " + req.patientId);
        } else if (normalQueue.size() > 0) {
            req = normalQueue.dequeue();
            System.out.println("Processing normal patient: " + req.patientId);
        }

        if (req != null) {
            discharges.push(new DischargeRecord(req.patientId));
            patients.removePatient(req.patientId);     // Linked List’ten sil
            patientLookup.remove(req.patientId);        // HashMap’ten sil
        } else {
            System.out.println("No patients in queue.");
        }
    }
    // 4. Sıralama Algoritması (Bubble Sort - Severity'ye göre)
    public void sortPatientsBySeverity() {
        // Linked List'i kolay sıralamak için geçici bir listeye alalım
        ArrayList<Patient> list = new ArrayList<>(patientLookup.values());
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).severity < list.get(j + 1).severity) {
                    // Swap (Büyükten küçüğe - En ağır hasta başa)
                    Patient temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        System.out.println("--- Patients Sorted by Severity (High to Low) ---");
        for (Patient p : list) System.out.println(p);
    }

    public void printStatus() {
        System.out.println("\n--- Current System State ---");
        System.out.println("Pending Priority: " + priorityQueue.size());
        System.out.println("Pending Normal: " + normalQueue.size());
        discharges.printStack();


    }




}