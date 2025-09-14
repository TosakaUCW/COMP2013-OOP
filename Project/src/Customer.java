// Customer.java

public class Customer extends Person implements Schedulable {

    private AppointmentManager manager;

    public Customer(String name, String email) {
        super(name, email);
        this.manager = AppointmentManager.getInstance();
    }

    // Constructor for loading from a file
    @Override
    public boolean bookAppointment(String date, String time, String serviceType) {
        try {
            // Check if the date and time are valid
            Appointment appt = new Appointment(this, serviceType, date, time);
            return manager.addAppointment(appt);
        } catch (DoubleBookingException | InvalidAppointmentException e) {
            // Handle exceptions
            System.err.println("Booking failed: " + e.getMessage());
            return false;
        }
    }

    // Method to update an appointment
    @Override
    public boolean cancelAppointment(int appointmentID) {
        return manager.deleteAppointment(appointmentID);
    }
}
