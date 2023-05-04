public class FixedDepositAccount extends Account implements AccountType{

    public FixedDepositAccount() {

    }

    @Override
    public double calculateInterest() {
        double interestRate = 0.04;
        int term = 12;
        return balance* interestRate * term;
    }

    @Override
    public double minimumBalance() {
        return 0.0;
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Cannot make deposits to a fixed deposit account");
    }

    @Override
    public void withDraw(double amount) {
        System.out.println("Cannot withdraw from a fixed deposit account before maturity");
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void displayFeatures() {

    }
}
