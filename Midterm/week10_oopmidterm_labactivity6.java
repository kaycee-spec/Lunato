package com.mycompany.week10_oopmidterm_labactivity6;

import java.util.Scanner;

public class Week10_oopmidterm_labactivity6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount bank = new BankAccount();
        HospitalDatabase hospital = new HospitalDatabase();
        ProfessorProgram professor = new ProfessorProgram();

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("          MAIN MENU");
            System.out.println("==============================");
            System.out.println("1. Program 1 - Bank Account");
            System.out.println("2. Program 2 - Hospital Database");
            System.out.println("3. Program 3 - Professor and Executive");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bank.run(sc);
                    break;
                case 2:
                    hospital.run(sc);
                    break;
                case 3:
                    professor.run(sc);
                    break;
                case 4:
                    System.out.println(
                        "Thank you for using the programs!"
                    );
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}

// Put the other classes below Main:
// BankAccount
// PatientDate
// Patient
// HospitalPatient
// HospitalDatabase
// Professor
// Deans
// Executive
// ProfessorProgram

// =====================================
// PROGRAM 1: BANK ACCOUNT
// =====================================
class BankAccount {
    double balance;

    void run(Scanner sc) {
        System.out.println("\n===== PROGRAM 1: BANK ACCOUNT =====");
        System.out.print("Enter your balance: ");
        balance = sc.nextDouble();

        int choice;

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Withdraw Amount");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(
                        "How much amount you want to withdraw from your account?"
                    );
                    System.out.print("Amount: ");
                    double withdraw = sc.nextDouble();

                    if (withdraw > 0 && withdraw <= balance) {
                        balance = balance - withdraw;
                        System.out.println(
                            "Your new balance is: " + balance
                        );
                    } else {
                        System.out.println(
                            "Invalid amount or insufficient balance!"
                        );
                    }
                    break;

                case 2:
                    System.out.println(
                        "How much amount you want to deposit in your account?"
                    );
                    System.out.print("Amount: ");
                    double deposit = sc.nextDouble();

                    if (deposit > 0) {
                        balance = balance + deposit;
                        System.out.println(
                            "Your new balance is: " + balance
                        );
                    } else {
                        System.out.println("Invalid deposit amount!");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 3);
    }
}

// =====================================
// PROGRAM 2: HOSPITAL PATIENT DATABASE
// =====================================

// Class for date
class PatientDate {
    int year, month, day;

    void input(Scanner sc) {
        System.out.print("Enter year: ");
        year = sc.nextInt();

        System.out.print("Enter month: ");
        month = sc.nextInt();

        System.out.print("Enter day: ");
        day = sc.nextInt();
    }

    void display() {
        System.out.printf("%02d/%02d/%04d", day, month, year);
    }
}

// Base class
class Patient {
    String name;
    PatientDate admissionDate = new PatientDate();
    String disease;
    PatientDate dischargeDate = new PatientDate();

    void input(Scanner sc) {
        sc.nextLine();

        System.out.print("Enter patient's name: ");
        name = sc.nextLine();

        System.out.println("Enter date of admission:");
        admissionDate.input(sc);

        sc.nextLine();
        System.out.print("Enter disease: ");
        disease = sc.nextLine();

        System.out.println("Enter date of discharge:");
        dischargeDate.input(sc);
    }

    void display() {
        System.out.println("Name: " + name);

        System.out.print("Date of admission: ");
        admissionDate.display();
        System.out.println();

        System.out.println("Disease: " + disease);

        System.out.print("Date of discharge: ");
        dischargeDate.display();
        System.out.println();
    }
}

// Derived class
class HospitalPatient extends Patient {
    int age;

    void input(Scanner sc) {
        super.input(sc);

        System.out.print("Enter age: ");
        age = sc.nextInt();
    }

    void display() {
        super.display();
        System.out.println("Age: " + age);
        System.out.println("-------------------------");
    }
}

// Hospital menu
class HospitalDatabase {
    HospitalPatient[] patients = new HospitalPatient[100];
    int count = 0;

    void run(Scanner sc) {
        int choice;

        do {
            System.out.println("\n===== PROGRAM 2: HOSPITAL DATABASE =====");
            System.out.println("1. Insert New Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Display Pediatric Patients");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (count < patients.length) {
                        patients[count] = new HospitalPatient();
                        patients[count].input(sc);
                        count++;
                        System.out.println("Patient added successfully!");
                    } else {
                        System.out.println("Patient database is full.");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No patient records found.");
                    } else {
                        System.out.println("\n===== ALL PATIENTS =====");

                        for (int i = 0; i < count; i++) {
                            patients[i].display();
                        }
                    }
                    break;

                case 3:
                    boolean found = false;

                    System.out.println(
                        "\n===== PEDIATRIC PATIENTS (UNDER 12) ====="
                    );

                    for (int i = 0; i < count; i++) {
                        if (patients[i].age < 12) {
                            patients[i].display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println(
                            "No pediatric patients found."
                        );
                    }
                    break;

                case 4:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
}

// =====================================
// PROGRAM 3: PROFESSOR, DEAN, EXECUTIVE
// =====================================

// Base class
class Professor {
    String name;
    double salary;

    Professor(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

// Dean class
class Deans extends Professor {
    String department;

    Deans(String name, String department, double salary) {
        super(name, salary);
        this.department = department;
    }

    public String toString() {
        return "Name: " + name
             + "\nDepartment: " + department
             + "\nSalary: " + salary;
    }
}

// Executive class
class Executive extends Deans {

    Executive(String name, String department, double salary) {
        super(name, department, salary);
    }

    public String toString() {
        return "Executive\n" + super.toString();
    }
}

// Program 3 input and display
class ProfessorProgram {
    void run(Scanner sc) {
        System.out.println(
            "\n===== PROGRAM 3: PROFESSOR AND EXECUTIVE ====="
        );

        sc.nextLine();

        System.out.println("\nEnter Dean's Information");
        System.out.print("Name: ");
        String deanName = sc.nextLine();

        System.out.print("Department: ");
        String deanDepartment = sc.nextLine();

        System.out.print("Salary: ");
        double deanSalary = sc.nextDouble();
        sc.nextLine();

        Deans dean = new Deans(
            deanName, deanDepartment, deanSalary
        );

        System.out.println("\nEnter Executive's Information");
        System.out.print("Name: ");
        String executiveName = sc.nextLine();

        System.out.print("Department: ");
        String executiveDepartment = sc.nextLine();

        System.out.print("Salary: ");
        double executiveSalary = sc.nextDouble();

        Executive executive = new Executive(
            executiveName, executiveDepartment, executiveSalary
        );

        System.out.println("\nStatus");
        System.out.println("Rank: Dean");
        System.out.println(dean.toString());

        System.out.println("\nStatus");
        System.out.println("Rank: " + executive.toString());
    }
}

