package practice_7.user_monitor;

public class Main {
    public static void main(String[] args) {
        UserMonitor userMonitor = new UserMonitor();
        userMonitor.addSession("1223");
        userMonitor.addSession("23");
        userMonitor.addSession("123");
        userMonitor.addSession("1223");
        userMonitor.addSession("23");
        userMonitor.printSessions();
    }
}
