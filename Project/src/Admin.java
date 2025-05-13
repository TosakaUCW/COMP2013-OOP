// Admin.java

import java.util.List;

public class Admin extends Person implements Schedulable {

    private AppointmentManager manager;

    public Admin(String name, String email) {
        super(name, email);
        this.manager = AppointmentManager.getInstance();
    }

    @Override
    public boolean bookAppointment(String date, String time, String serviceType) {
        try {
            Appointment appt = new Appointment(this, serviceType, date, time);
            return manager.addAppointment(appt);
        } catch (DoubleBookingException | InvalidAppointmentException e) {
            System.err.println("Booking failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean cancelAppointment(int appointmentID) {
        return manager.deleteAppointment(appointmentID);
    }

    public List<Appointment> viewAllAppointments() {
        return manager.getAllAppointments();
    }

    public boolean manageAppointments() {
        // Implement admin-specific management tasks here
        return true;
    }
}
