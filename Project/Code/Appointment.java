// Appointment.java

public class Appointment {

    private static int idCounter = 0;

    private int appointmentID;
    private Person customer;
    private String serviceType;
    private String date;
    private String time;

    public Appointment(Person customer, String serviceType, String date, String time) throws InvalidAppointmentException {
        if (date == null || time == null || serviceType == null || customer == null) {
            throw new InvalidAppointmentException("Date, time, service type, and customer must be provided.");
        }
        this.appointmentID = ++idCounter;
        this.customer = customer;
        this.serviceType = serviceType;
        this.date = date;
        this.time = time;
    }
    
    Appointment(int appointmentID, Person customer, String serviceType, String date, String time) {
        this.appointmentID = appointmentID;
        this.customer      = customer;
        this.serviceType   = serviceType;
        this.date          = date;
        this.time          = time;
        // Ensure that the static counter idCounter is always greater than the current maximum ID
        if (appointmentID > idCounter) {
            idCounter = appointmentID;
        }
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public String getDetails() {
        return "Appointment #" + appointmentID + ": " + serviceType + " on " + date + " at " + time + " for " + customer.getName();
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getServiceType() {
        return serviceType;
    }

    public Person getCustomer() {
        return customer;
    }

    // Added setters to allow updating date/time
    public void setDate(String date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.date = date;
    }

    public void setTime(String time) {
        if (time == null) {
            throw new IllegalArgumentException("Time cannot be null");
        }
        this.time = time;
    }
}
