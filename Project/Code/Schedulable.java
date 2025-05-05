// Schedulable.java

public interface Schedulable {

    boolean bookAppointment(String date, String time, String serviceType);

    boolean cancelAppointment(int appointmentID);
}
