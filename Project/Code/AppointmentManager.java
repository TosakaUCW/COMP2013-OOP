// AppointmentManager.java

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentManager {

    private List<Appointment> appointments;
    private static AppointmentManager instance = new AppointmentManager();

    private AppointmentManager() {
        appointments = new ArrayList<>();
    }

    public static AppointmentManager getInstance() {
        return instance;
    }

    public synchronized boolean addAppointment(Appointment appointment) throws DoubleBookingException {
        // Check for double booking: same date, time, and service type
        for (Appointment a : appointments) {
            if (a.getDate().equals(appointment.getDate())
                    && a.getTime().equals(appointment.getTime())
                    && a.getServiceType().equals(appointment.getServiceType())) {
                throw new DoubleBookingException("An appointment for this service at the specified date and time already exists.");
            }
        }
        appointments.add(appointment);
        return true;
    }

    public synchronized boolean updateAppointment(int appointmentID, String newDate, String newTime) {
        Appointment appt = findAppointment(appointmentID);
        if (appt == null) {
            return false;
        }
        // Check for conflict
        for (Appointment a : appointments) {
            if (a.getAppointmentID() != appointmentID
                    && a.getDate().equals(newDate)
                    && a.getTime().equals(newTime)
                    && a.getServiceType().equals(appt.getServiceType())) {
                return false;
            }
        }
        // Use setters instead of direct field access
        appt.setDate(newDate);
        appt.setTime(newTime);
        return true;
    }

    public synchronized boolean deleteAppointment(int appointmentID) {
        Appointment appt = findAppointment(appointmentID);
        if (appt != null) {
            appointments.remove(appt);
            return true;
        }
        return false;
    }

    public synchronized Appointment findAppointment(int appointmentID) {
        for (Appointment a : appointments) {
            if (a.getAppointmentID() == appointmentID) {
                return a;
            }
        }
        return null;
    }

    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }

    public List<Appointment> getAppointmentsSortedById() {
        return appointments.stream()
                .sorted(Comparator.comparingInt(Appointment::getAppointmentID))
                .collect(Collectors.toList());
    }

    /**
     * Sort by datetime (assuming date="yyyy-MM-dd", time="HH:mm")
     */
    public List<Appointment> getAppointmentsSortedByDateTime() {
        return appointments.stream()
                .sorted(Comparator
                        .comparing(Appointment::getDate)
                        .thenComparing(Appointment::getTime))
                .collect(Collectors.toList());
    }

    /**
     * Filter all appointments for a certain customer
     */
    public List<Appointment> getAppointmentsByCustomer(String customerName) {
        return appointments.stream()
                .filter(a -> a.getCustomer().getName().equalsIgnoreCase(customerName))
                .collect(Collectors.toList());
    }
}
