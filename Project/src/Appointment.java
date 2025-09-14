// Appointment.java

public class Appointment {

    // Static variable to keep track of the last used appointment ID
    private static int idCounter = 0;

    // Instance variables
    private int appointmentID;
    private Person customer;
    private String serviceType;
    private String date;
    private String time;

    // Constructor for creating a new appointment
    public Appointment(Person customer, String serviceType, String date, String time) throws InvalidAppointmentException {
        if (date == null || time == null || serviceType == null || customer == null) {
            throw new InvalidAppointmentException("Date, time, service type, and customer must be provided.");
        }
        // Check if the date and time are valid
        this.appointmentID = ++idCounter;
        this.customer = customer;
        this.serviceType = serviceType;
        this.date = date;
        this.time = time;
    }

    // Constructor for creating an appointment with a specific ID (for loading from a file)
    Appointment(int appointmentID, Person customer, String serviceType, String date, String time) {
        this.appointmentID = appointmentID;
        this.customer = customer;
        this.serviceType = serviceType;
        this.date = date;
        this.time = time;
        // Ensure that the static counter idCounter is always greater than the current maximum ID
        if (appointmentID > idCounter) {
            idCounter = appointmentID;
        }
    }

    // Getters
    public int getAppointmentID() {
        return appointmentID;
    }

    public String getDetails() {
        // Format the appointment details as a string
        return "Appointment #" + appointmentID + ": " + serviceType + " on " + date + " at " + time + " for " + customer.getName();
    }

    public String getDate() {
        // Return the date in a specific format
        return date;
    }

    public String getTime() {
        // Return the time in a specific format
        return time;
    }

    public String getServiceType() {
        // Return the service type
        return serviceType;
    }

    public Person getCustomer() {
        // Return the customer associated with the appointment
        return customer;
    }

    // Added setters to allow updating date/time
    public void setDate(String date) {
        if (date == null) {
            // Throw an exception if date is null
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.date = date;
    }

    // Setter for time
    public void setTime(String time) {
        if (time == null) {
            // Throw an exception if time is null
            throw new IllegalArgumentException("Time cannot be null");
        }
        this.time = time;
    }

    // Setter for service type
    public void setServiceType(String serviceType) {
        if (serviceType == null) {
            // Throw an exception if service type is null
            throw new IllegalArgumentException("Service type cannot be null");
        }
        this.serviceType = serviceType;
    }
}
