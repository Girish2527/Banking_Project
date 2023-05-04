import java.util.Scanner;

public abstract class Account {

    protected int accountNumber;
    protected String customerName;
    protected double balance;
    protected String customerAddress;

    public abstract void deposit(double amount) ;
    public abstract void withDraw(double amount) ;

    public abstract boolean isAvailable() ;
    public abstract void displayFeatures();


    public int getAccountNumber() { return accountNumber; }

    public String getCustomerName() { return customerName; }

    public double getBalance() { return balance;   }

    public String getCustomerAddress() { return customerAddress;   }
}
