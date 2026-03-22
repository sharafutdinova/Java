package Task_3;

public class Company {
    static String companyName;
    final int employeeID;
    String employeeName;

    static {
        companyName = "Best company";
    }

    Company(int employeeID, String employeeName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
    }

    static void printCompanyName() {
        System.out.println("Company name is " + companyName);
    }

    String getEmployeeName() {
        return this.employeeName;
    }

    void setEmployeeName(String newEmployeeName) {
        this.employeeName = newEmployeeName;
    }
}

