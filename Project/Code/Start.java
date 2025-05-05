// Start.java

public class Start {

    public static void main(String[] args) {
        // 创建用户
        Customer customer = new Customer("Alice", "alice@example.com");
        Admin admin = new Admin("Bob", "bob@example.com");

        // 客户预约
        System.out.println("Attempt to book: " + (customer.bookAppointment("2025-05-10", "10:00", "Haircut") ? "成功" : "失败"));

        // 管理员查看所有预约
        System.out.println("\n当前所有预约:");
        for (Appointment appt : admin.viewAllAppointments()) {
            System.out.println(appt.getDetails());
        }

        // 客户取消预约
        boolean canceled = customer.cancelAppointment(1);
        System.out.println("\n取消预约: " + (canceled ? "成功" : "失败"));

        // 管理员查看取消后的预约
        System.out.println("\n取消后预约列表:");
        for (Appointment appt : admin.viewAllAppointments()) {
            System.out.println(appt.getDetails());
        }
    }
}
