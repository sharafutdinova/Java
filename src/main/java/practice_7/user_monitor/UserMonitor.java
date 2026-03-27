package practice_7.user_monitor;

import java.util.HashSet;

public class UserMonitor {
    private HashSet<String> sessions;

    public UserMonitor() {
        sessions = new HashSet<>();
    }

    public void addSession(String session) {
        sessions.add(session);
    }

    public HashSet<String> getSessions() {
        return this.sessions;
    }

    public void printSessions() {
        sessions.forEach(System.out::println);
    }
}
