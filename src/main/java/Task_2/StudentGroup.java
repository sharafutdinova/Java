package Task_2;

public class StudentGroup {
    String groupName;
    int studentCount;

    StudentGroup(String groupName, int studentCount) {
        this.groupName = groupName;
        this.studentCount = studentCount;
    }

    String getGroupName() {
        return this.groupName;
    }

    int getStudentCount() {
        return this.studentCount;
    }

    void setGroupName(String newName) {
        this.groupName = newName;
    }

    void setStudentCount(int newCount) {
        this.studentCount = newCount;
    }

    void printInfo() {
        System.out.println("Group name is " + this.groupName + " student count = " + this.studentCount);
    }
}
