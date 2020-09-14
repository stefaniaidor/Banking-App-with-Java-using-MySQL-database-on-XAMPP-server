import java.util.Scanner;

public class BankingApplication {


    public static void main(String[] args){

        //Account member1 = new Account("Smith", "XZ345D");
        //member1.showMenu();
        DBConnect connect = new DBConnect();
        connect.getData();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your NAME and your ID from the list above: ");

        String name = scanner.next();
        String id = scanner.next();



        Account member1 = new Account(name, id);
        member1.showMenu();
    }

    static class Account{

        String customerName;
        String customerId;
        int balance;
        int previousTransaction;

        public Account(String custName, String custId) {
            customerName=custName;
            customerId=custId;

        }

        void deposit(int amount){

            if(amount !=0)
            {
                balance=balance+amount;
                previousTransaction=amount;
            }
            else
                if(amount == 0)
                {
                    System.out.println("The amount of money cannot be deposited. Try again!");
                }

        }

        void withdraw(int amount){

            if(amount !=0)
            {
                balance=balance-amount;
                previousTransaction= -amount;
            }
            else
            if(amount == 0)
            {
                System.out.println("The amount of money cannot be removed. Try again!");
            }

        }

        void getPreviousTransaction(){
            if(previousTransaction > 0)
            {
                System.out.println("Deposited: " +previousTransaction);
            }
            else
                if(previousTransaction < 0)
                {
                    System.out.println("Withdrawn: " +Math.abs(previousTransaction));
                }
                else
                {
                    System.out.println("No transaction occured!");
                }
        }

        void showMenu(){

            char option = '\0';
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome " +customerName);
            System.out.println("Your ID is " + customerId);
            System.out.println("\n");
            System.out.println("A. Check balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");

            do{
                System.out.println(".....................................");
                System.out.println("Please, enter an option!");
                System.out.println(".....................................");
                option = scanner.next().charAt(0);
                System.out.println("\n");

                switch(option){


                    case 'A':
                        System.out.println(".....................................");
                        System.out.println("Balance: " +balance);
                        System.out.println(".....................................");
                        System.out.println("\n");
                        break;

                    case 'B':
                        System.out.println(".....................................");
                        System.out.println("Enter the amount you want to deposit: ");
                        int amount = scanner.nextInt();
                        deposit(amount);
                        System.out.println(".....................................");
                        System.out.println("\n");
                        break;

                    case 'C':
                        System.out.println(".....................................");
                        System.out.println("Enter the amount you want to withdraw: ");
                        int amount2 = scanner.nextInt();
                        withdraw(amount2);
                        System.out.println(".....................................");
                        System.out.println("\n");
                        break;

                    case 'D':
                        System.out.println(".....................................");
                        System.out.println("Previous Transaction ");
                        getPreviousTransaction();
                        System.out.println(".....................................");
                       System.out.println("\n");
                        break;

                    case 'E':
                        System.out.println(".....................................");
                        System.out.println("Thank you for using our services!");
                        break;


                    }

            } while(option != 'E');

        }

    }
}
