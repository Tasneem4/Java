
import java.util.List;
import java.util.Scanner;

public class BankingSystemApp {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingService service = new BankingServiceImpl();

        while (true) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. View Account Transactions");
            System.out.println("6. Add Beneficiary");
            System.out.println("7. View Customer Accounts");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Customer ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Address: ");
                    String address = sc.nextLine();
                    System.out.print("Contact: ");
                    String contact = sc.nextLine();
                    service.addCustomer(new Customer(cid, name, address, contact));
                    System.out.println("Customer added.");
                    break;

                case 2:
                    System.out.print("Account ID: ");
                    int accid = sc.nextInt();
                    System.out.print("Customer ID: ");
                    int custId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Account Type: ");
                    String type = sc.nextLine();
                    System.out.print("Initial Balance: ");
                    double bal = sc.nextDouble();
                    service.addAccount(new Account(accid, custId, type, bal));
                    System.out.println("Account added.");
                    break;

                case 3:
                    System.out.print("Account ID: ");
                    int accID = sc.nextInt();
                    System.out.print("Amount to deposit: ");
                    double deposit = sc.nextDouble();
                    Account acc = service.findAccountById(accID);
                    if (acc != null) {
                        acc.setBalance(acc.getBalance() + deposit);
                        service.addTransaction(new Transaction((int) (Math.random() * 10000), accID, "DEPOSIT", deposit));
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Account ID: ");
                    int accID2 = sc.nextInt();
                    System.out.print("Amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    Account acc2 = service.findAccountById(accID2);
                    if (acc2 != null && acc2.getBalance() >= withdraw) {
                        acc2.setBalance(acc2.getBalance() - withdraw);
                        service.addTransaction(new Transaction((int) (Math.random() * 10000), accID2, "WITHDRAW", withdraw));
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Account not found or insufficient balance.");
                    }
                    break;

                case 5:
                    System.out.print("Account ID: ");
                    int accTx = sc.nextInt();
                    List<Transaction> txList = service.getTransactionsByAccountId(accTx);
                    if (txList.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        for (Transaction tx : txList) {
                            System.out.println(tx);
                        }
                    }
                    break;

                case 6:
                    System.out.print("Beneficiary ID: ");
                    int bid = sc.nextInt();
                    System.out.print("Customer ID: ");
                    int bcust = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Beneficiary Name: ");
                    String bname = sc.nextLine();
                    System.out.print("Account Number: ");
                    String bacc = sc.nextLine();
                    System.out.print("Bank Details: ");
                    String bbank = sc.nextLine();
                    service.addBeneficiary(new Beneficiary(bid, bcust, bname, bacc, bbank));
                    System.out.println("Beneficiary added.");
                    break;

                case 7:
                    System.out.print("Customer ID: ");
                    int cId = sc.nextInt();
                    List<Account> accList = service.getAccountsByCustomerId(cId);
                    for (Account a : accList) {
                        System.out.println(a);
                    }
                    break;

                case 8:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
