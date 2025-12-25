package HospitalPatientManagementSystemSimulation;

public class TreatmentRequest {

    int patientId;
    long arrivalTime;
    boolean isPriority;

    public TreatmentRequest(int patientId, boolean isPriority) {
        this.patientId = patientId;
        this.isPriority = isPriority;
        this.arrivalTime = System.currentTimeMillis();
    }



    @Override
    public String toString() {
        return "Patient ID: " + patientId + " | Time: " + arrivalTime;
    }
}

// TreatmentQueue.java (Linked List tabanlı Queue)

