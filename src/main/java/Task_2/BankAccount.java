package Task_2;

public class BankAccount {
    String owner;
    int balance;

    BankAccount(String owner, int balance) {
        this.balance = balance;
        this.owner = owner;
    }

    String getOwner() {
        return this.owner;
    }

    void setOwner(String newOwner) {
        this.owner = newOwner;
    }

    void deposit(int amount) {
        this.balance += amount;
    }

    void withdraw(int amount) {
        this.balance -= amount;
    }

    void printBalance() {
        System.out.println("Balance " + this.balance);
    }
}
