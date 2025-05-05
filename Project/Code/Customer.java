// Customer.java

public class Customer extends Person implements Schedulable {

    private AppointmentManager manager;

    public Customer(String name, String email) {
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
}
