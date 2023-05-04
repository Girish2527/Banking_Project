import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Online Banking System");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int userInput = 1;
        Scanner input = new Scanner(System.in);
        while (userInput == 1) {
            System.out.println("Press 1 to Savings Account \nPress 2 to Current Account ");
            userInput = input.nextInt();
            if (userInput == 1) {
                System.out.println("Enter Customer Name and Account Number to verify savings account");
                SavingsAccount savingsAccount = new SavingsAccount();
                savingsAccount.getUserNameAndAccountNo();
                savingsAccount.isAvailable();
                int choice = -1;
                while(choice!=0|| savingsAccount.isAvailable()){
                    savingsAccount.displayFeatures();
                    choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Your Account Balance is " + savingsAccount.getBalance()+" .Rs");
                            break;
                        case 2:
                            System.out.println("Enter amount to deposit :");
                            double depositAmount = input.nextDouble();
                            savingsAccount.deposit(depositAmount);
                            break;
                        case 3:
                            System.out.println("Enter amount to withdraw:");
                            double withdrawAmount = input.nextDouble();
                            savingsAccount.withDraw(withdrawAmount);
                            break;
                        case 4:
                            System.out.println("Interest calculated and added to your account. Current balance: "+savingsAccount.calculateInterest());
                            break;
                        case 5:
                            if (savingsAccount.getBalance() < savingsAccount.minimumBalance()) {
                                System.out.println("Your balance is below the minimum balance requirement. Penalty charges may apply.");
                                System.out.println("You have to maintain above "+savingsAccount.minimumBalance()+" to avoid penalty charges");
                            } else {
                                System.out.println("Your account is in good standing with respect to the minimum balance requirement.");
                            }
                            break;
                        case 0:
                            System.out.println("Exiting the Features. Thank you!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else if (userInput == 2) {
                System.out.println("Current Account Online Facility Currently Not Available Contact Home Branch....");
            } else {
                System.out.println("Invalid Account Selection Try Again....");
            }
        }
    }
}
