// AppointmentSchedulerUI.java

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class AppointmentSchedulerUI extends JFrame {

    private AppointmentManager manager = AppointmentManager.getInstance();
    private DefaultTableModel tableModel;

    // Filter by customer name
    // Sort by appointment ID or date/time
    private JTextField filterField;
    private JComboBox<String> sortCombo;

    public AppointmentSchedulerUI() {
        setTitle("Online Appointment Scheduler");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Book", createBookPanel());
        tabs.add("View", createViewPanel());
        tabs.add("Cancel", createCancelPanel());
        tabs.add("Update", createUpdatePanel());

        tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // When the "View" tab is selected, refresh the list (will automatically apply current filter/sort settings)
                if (tabs.getSelectedIndex() == 1) {
                    loadAppointments();
                }
            }
        });

        add(tabs);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createBookPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();

        // Date selector
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd"));

        // Time selector
        SpinnerDateModel timeModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(timeModel);
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "HH:mm"));

        JTextField serviceField = new JTextField();
        JButton bookBtn = new JButton("Book");

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        panel.add(dateSpinner);
        panel.add(new JLabel("Time (HH:MM):"));
        panel.add(timeSpinner);
        panel.add(new JLabel("Service Type:"));
        panel.add(serviceField);
        panel.add(new JLabel());
        panel.add(bookBtn);

        bookBtn.addActionListener(e -> {
            String date = new SimpleDateFormat("yyyy-MM-dd").format(dateSpinner.getValue());
            String time = new SimpleDateFormat("HH:mm").format(timeSpinner.getValue());
            Customer cust = new Customer(nameField.getText(), emailField.getText());
            if (cust.bookAppointment(date, time, serviceField.getText())) {
                JOptionPane.showMessageDialog(this, "Booked successfully!");
            }
        });

        return panel;
    }

    private JPanel createViewPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();
        filterField = new JTextField(10);
        sortCombo = new JComboBox<>(new String[]{
            // "默认顺序", "按 ID 排序", "按 时间 排序"
            "Default order", "Sort by ID", "Sort by time"
        });
        JButton applyBtn = new JButton("Apply Filter / Sort");

        topPanel.add(new JLabel("Customer Name:"));
        topPanel.add(filterField);
        topPanel.add(new JLabel("sort by:"));
        topPanel.add(sortCombo);
        topPanel.add(applyBtn);

        applyBtn.addActionListener(e -> loadAppointments());

        panel.add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(
                new String[]{"ID", "Customer", "Service", "Date", "Time"}, 0
        );
        JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> loadAppointments());
        panel.add(refresh, BorderLayout.SOUTH);

        loadAppointments();

        return panel;
    }

    /**
     * Load and display the appointment list, filtering (customer name) and
     * sorting (ID or time) according to the values ​​of filterField and
     * sortCombo.
     */
    private void loadAppointments() {
        tableModel.setRowCount(0);

        // 1. Get all appointments
        List<Appointment> list = manager.getAllAppointments();

        // 2. Filter: by customer name
        String customer = filterField.getText().trim();
        if (!customer.isEmpty()) {
            list = list.stream()
                    .filter(a -> a.getCustomer().getName()
                    .equalsIgnoreCase(customer))
                    .collect(Collectors.toList());
        }

        // 3. Sorting: Select according to the drop-down box
        String mode = (String) sortCombo.getSelectedItem();
        if ("Sort by ID".equals(mode)) {
            list = list.stream()
                    .sorted(Comparator.comparingInt(Appointment::getAppointmentID))
                    .collect(Collectors.toList());
        } else if ("Sort by time".equals(mode)) {
            list = list.stream()
                    .sorted(Comparator
                            .comparing(Appointment::getDate)
                            .thenComparing(Appointment::getTime))
                    .collect(Collectors.toList());
        }
        // "Default order" remains as is

        // 4. Fill in the form
        for (Appointment a : list) {
            tableModel.addRow(new Object[]{
                a.getAppointmentID(),
                a.getCustomer().getName(),
                a.getServiceType(),
                a.getDate(),
                a.getTime()
            });
        }
    }

    private JPanel createCancelPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JTextField idField = new JTextField(10);
        JButton cancelBtn = new JButton("Cancel");

        panel.add(new JLabel("Appointment ID:"));
        panel.add(idField);
        panel.add(cancelBtn);

        cancelBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                boolean result = manager.deleteAppointment(id);
                if (result) {
                    JOptionPane.showMessageDialog(this, "Canceled successfully!");
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Cancel failed: no appointment with ID " + id,
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid ID format",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        return panel;
    }

    private JPanel createUpdatePanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        JTextField idField = new JTextField();

        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
        dateSpinner.setEditor(
                new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd")
        );

        SpinnerDateModel timeModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(timeModel);
        timeSpinner.setEditor(
                new JSpinner.DateEditor(timeSpinner, "HH:mm")
        );
        JTextField serviceField = new JTextField();
        JButton updateBtn = new JButton("Update");

        panel.add(new JLabel("Appointment ID:"));
        panel.add(idField);
        panel.add(new JLabel("New Date:"));
        panel.add(dateSpinner);
        panel.add(new JLabel("New Time:"));
        panel.add(timeSpinner);
        panel.add(new JLabel("New Service Type:"));
        panel.add(serviceField);
        panel.add(new JLabel());
        panel.add(updateBtn);

        updateBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String newDate = new SimpleDateFormat("yyyy-MM-dd")
                        .format(dateSpinner.getValue());
                String newTime = new SimpleDateFormat("HH:mm")
                        .format(timeSpinner.getValue());
                String newService = serviceField.getText().trim();
                boolean ok = manager.updateAppointment(id, newDate, newTime, newService);
                if (ok) {
                    JOptionPane.showMessageDialog(this, "Updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Update failed: conflict or ID not found",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Appointment ID",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppointmentSchedulerUI::new);
    }
}
