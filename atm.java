import java.util.Scanner;

class atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 0; 
        int choice;

        do {
            System.out.println("Enter your choice:\n1--Deposit\n2--Withdraw\n3--Check Balance\n4--Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter the amount to deposit:");
                    int deposit = sc.nextInt(); 
                    balance += deposit; 
                    System.out.println("You have deposited: " + deposit);
                    break;
                }
                case 2: {
                    System.out.println("Enter the amount to withdraw:");
                    int withdraw = sc.nextInt(); 
                    if (withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("You have withdrawn: " + withdraw);
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Your current balance is: " + balance); 
                    break;
                }
                case 4: {
                    System.out.println("Thank you for using ATM");
                    break;
                }
                default: {
                    System.out.println("Invalid choice! Please try again.");
                }
            }
        } while (choice != 4);

    }
}