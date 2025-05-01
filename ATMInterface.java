
import java.util.Scanner;
import java.util.ArrayList;

class ATM {
    private double balance;
    private ArrayList<String> transactionHistory;

    public ATM(){
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs " + balance);
    }
    public void depositMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
        } else {
            balance += amount;
            transactionHistory.add("Deposited Rs " + amount);
            System.out.println("Successfully deposited Rs: " + amount);
        }
    }

    public void withdrawMoney(double amount){
       if(amount <= 0){
           System.out.println("Invalid Withdraw amount");
           }
       else if(amount > balance){
           System.out.println("Insufficient Balance");
       }
       else{
           balance -= amount;
           transactionHistory.add("Withdraw Rs " + amount);
           System.out.println("Successfully withdrew Rs: " + amount);
       }
    }

    public void viewTransactionHistory(){
        if(transactionHistory.isEmpty()){
            System.out.println("No transaction yet");
        }
        else {
            System.out.println("Transaction History: ");
            for(String transaction : transactionHistory){
                System.out.println("-" + transaction);
            }
        }
    }
}

public class ATMInterface{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();
        int choice;

        System.out.println("===== Welcome to JAVA ATM =====");

        do{
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            while(!sc.hasNextInt()){
                System.out.println("Please enter a valid number.");

                sc.next(); // consume invalid input
            }
            choice = sc.nextInt();
            if(choice == 1){
                atm.checkBalance();
            }
            else if(choice == 2){
                System.out.println("Enter amount to deposit");
                double depositamount = sc.nextDouble();
                atm.depositMoney(depositamount);
            }
            else if(choice == 3){
                System.out.println("Enter amount to withdraw");
                double withdrawamount = sc.nextDouble();
                atm.withdrawMoney(withdrawamount);
            }
            else if(choice == 4){
                atm.viewTransactionHistory();
            }
            else if(choice == 5){
                System.out.println("Thank you for using Java ATM, Have a great day!");
            }
            else{
                System.out.println("Invalid choice! Try again");
            }
        } while(choice != 5);

           sc.close();
    }
}
