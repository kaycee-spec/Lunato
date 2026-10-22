package com.mycompany.week10_oopmidterm_labactivity5;

import java.util.Scanner;

// ==========================================
// FILE 1: Account.java (Combined as base class)
// ==========================================
abstract class Week10_oopmidterm_labactivity5 {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(openingBalance, 0);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double fee = calculateWithdrawalFee();
        double totalDeduction = amount + fee;
        if (totalDeduction > balance) {
            return false;
        }
        balance -= totalDeduction;
        return true;
    }

    public abstract double calculateWithdrawalFee();
    public abstract String getAccountType();
}

// ==========================================
// FILE 2: SavingsAccount.java
// ==========================================
class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double calculateWithdrawalFee() {
        return 0.0;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}

// ==========================================
// FILE 3: CheckingAccount.java
// ==========================================
class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double calculateWithdrawalFee() {
        return 10.0;
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
}

// ==========================================
// FILE 4: BankingApp.java (Main Class)
// ==========================================
public class BankingApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the OOP Banking System.\n");
        double openingBalance = readNonNegativeBalance();

        SavingsAccount savingsAccount = new SavingsAccount("SAV-001", openingBalance);
        CheckingAccount checkingAccount = new CheckingAccount("CHK-001", openingBalance);
        Account selectedAccount = savingsAccount;

        while (true) {
            printAccountSummary(selectedAccount);
            showMenu();

            if (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input! Please enter a number 1-5.\n");
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();
            System.out.println("Choice: " + choice);

            switch (choice) {
                case 1:
                    System.out.print("Amount to withdraw: ");
                    double withdrawAmt = readPositiveAmount();
                    if (withdrawAmt == -1) break;
                    
                    double fee = selectedAccount.calculateWithdrawalFee();
                    if (selectedAccount.withdraw(withdrawAmt)) {
                        System.out.printf("Withdrawal fee: P%.2f New %s balance: P%.2f%n%n", 
                                fee, selectedAccount.getAccountType(), selectedAccount.getBalance());
                    } else {
                        System.out.println("❌ Withdrawal failed! Insufficient balance.\n");
                    }
                    break;

                case 2:
                    System.out.print("Amount to deposit: ");
                    double depositAmt = readPositiveAmount();
                    if (depositAmt == -1) break;

                    if (selectedAccount.deposit(depositAmt)) {
                        System.out.printf("New %s balance: P%.2f%n%n", 
                                selectedAccount.getAccountType(), selectedAccount.getBalance());
                    }
                    break;

                case 3:
                    System.out.println();
                    break;

                case 4:
                    if (selectedAccount instanceof SavingsAccount) {
                        selectedAccount = checkingAccount;
                    } else {
                        selectedAccount = savingsAccount;
                    }
                    System.out.printf("✅ Switched to %s Account%n%n", selectedAccount.getAccountType());
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice! Please select 1-5.\n");
            }
        }
    }

    private static void showMenu() {
        System.out.println("1 Withdraw 2 Deposit 3 Show Balance 4 Switch Account 5 Exit");
        System.out.print("Enter your choice: ");
    }

    private static double readNonNegativeBalance() {
        double value;
        while (true) {
            System.out.print("Opening balance: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("❌ Please enter a valid number.\n");
                scanner.next();
                continue;
            }
            value = scanner.nextDouble();
            if (value >= 0) break;
            System.out.println("❌ Balance cannot be negative.\n");
        }
        return value;
    }

    private static double readPositiveAmount() {
        double value;
        while (true) {
            if (!scanner.hasNextDouble()) {
                System.out.println("❌ Invalid amount! Must be positive.\n");
                scanner.next();
                return -1;
            }
            value = scanner.nextDouble();
            if (value > 0) return value;
            System.out.println("❌ Amount must be greater than zero.\n");
            return -1;
        }
    }

    private static void printAccountSummary(Account acc) {
        System.out.printf("Current account: %s Balance: P%.2f%n", acc.getAccountType(), acc.getBalance());
    }
}
