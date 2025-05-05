// AppointmentManager.java

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentManager {

    private List<Appointment> appointments;
    private static final String CSV_FILE = "appointments.csv";

    private static AppointmentManager instance = new AppointmentManager();

    private AppointmentManager() {
        // Load from CSV on startup
        try {
            appointments = CsvUtil.readCsv(CSV_FILE, fields -> {
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String email = fields[2];
                String service = fields[3];
                String date = fields[4];
                String time = fields[5];
                Person cust = new Customer(name, email);
                // Using the new constructor, the signature matches: (int, Person, String, String, String)
                return new Appointment(id, cust, service, date, time);
            });
        } catch (IOException e) {
            System.err.println("Failed to load appointments: " + e.getMessage());
            appointments = new ArrayList<>();
        }
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
        saveAll();
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
        saveAll();
        return true;
    }

    public synchronized boolean deleteAppointment(int appointmentID) {
        Appointment appt = findAppointment(appointmentID);
        if (appt != null) {
            appointments.remove(appt);
            saveAll();
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

    /**
     * Write the current list back to CSV
     */
    private void saveAll() {
        try {
            CsvUtil.writeCsv(CSV_FILE, appointments, appt -> new String[]{
                String.valueOf(appt.getAppointmentID()),
                appt.getCustomer().getName(),
                appt.getCustomer().getEmail(), // Person.java 中已有 getEmail()
                appt.getServiceType(),
                appt.getDate(),
                appt.getTime()
            });
        } catch (IOException e) {
            System.err.println("Failed to save appointments: " + e.getMessage());
        }
    }
}
