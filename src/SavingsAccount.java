import java.util.Scanner;

public class SavingsAccount extends Account implements AccountType {
    private final double minimumBalance = 500;

    public void getUserNameAndAccountNo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your UserName : ");
        super.customerName = input.nextLine();
        System.out.println("Enter Your Account Number :");
        super.accountNumber = input.nextInt();
    }


    @Override
    public double calculateInterest() {
        double interestRate = 0.025;
        double interest = balance * interestRate;
        return balance+=interest;

    }

    @Override
    public double minimumBalance() {
        return minimumBalance;
    }

    @Override
    public void deposit(double depositAmount) {
        balance = balance + depositAmount;
        System.out.println("Amount Rs."+depositAmount+" Successfully Deposited to your Account Number  "+ getAccountNumber());
    }

    @Override
    public void withDraw(double withDrawAmount) {
        if (balance - withDrawAmount >= minimumBalance) {
            balance = balance - withDrawAmount;
            System.out.println("Amount Rs."+withDrawAmount+" Withdrawn successfully...");
        } else {
            System.out.println("Insufficient Balance...");
        }
    }

    @Override
    public boolean isAvailable() {
        Bank bank = new Bank();
        if (bank.customerVerification(accountNumber, customerName)) {
            System.out.println("Customer Account Verified");
        } else{
            System.out.println("Account Not Available Contact Your Home Branch.....");
            getUserNameAndAccountNo();
            isAvailable();
        }
        return false;
    }
    @Override
    public void displayFeatures() {
        System.out.println("\nAvailable Features For You : ");
        System.out.println("\npress 1 to Check Balance");
        System.out.println("press 2 to Deposit Money");
        System.out.println("press 3 to Withdraw Money");
        System.out.println("Press 4 to Calculate Interest");
        System.out.println("Press 5 to Check Minimum Balance");
        System.out.println("press 0 to Exit");
    }
}

