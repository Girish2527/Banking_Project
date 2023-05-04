public class CurrentAccount extends Account implements AccountType{

    private final double overDraftLimit=25000;

    public CurrentAccount() {


    }


    @Override
    public double calculateInterest() {

        return 0.0;
    }

    @Override
    public double minimumBalance() {

        return -overDraftLimit;
    }

    @Override
    public void deposit(double depositAmount) {
        balance = balance + depositAmount;
    }

    @Override
    public void withDraw(double withDrawAmount) {
        if (balance+overDraftLimit>=withDrawAmount){
            balance = balance - withDrawAmount;
        }else {
            System.out.println("Insufficient Balance...");
        }
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void displayFeatures() {

    }
}
