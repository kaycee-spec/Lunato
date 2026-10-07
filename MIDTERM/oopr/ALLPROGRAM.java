package com.mycompany.allprogram;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.text.*;

public class ALLPROGRAM {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        char again;

        do {
            System.out.println("\nChoose the program you want to run");
            System.out.println();
            System.out.println("Number 1");
            System.out.println("Number 2");
            System.out.println("Number 3");
            System.out.println("Number 4");
            System.out.println("Number 5");
            System.out.println("Number 6");
            System.out.println("Number 7");
            System.out.println();

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    program1();
                    break;
                case 2:
                    program2();
                    break;
                case 3:
                    program3();
                    break;
                case 4:
                    program4();
                    break;
                case 5:
                    program5();
                    break;
                case 6:
                    program6();
                    break;
                case 7:
                    program7();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.print("\nDo you want to continue ? Y/N: ");
            again = input.next().charAt(0);

        } while (again == 'Y' || again == 'y');

        System.out.println("Program ended.");
    }

    public static void program1() {
        double[] numbers = new double[10];

        System.out.println("\nPROGRAM 1");
        System.out.println("Enter 10 real numbers:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextDouble();
        }

        double sum = 0;
        int positiveCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                sum += numbers[i];
                positiveCount++;
            }
        }

        double average = positiveCount > 0 ? sum / positiveCount : 0;

        System.out.println("\nSum of positive numbers: " + sum);
        System.out.println("Average of positive numbers: " + average);

        int negativeCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                negativeCount++;
            }
        }

        System.out.println("Number of negative numbers: " + negativeCount);

        double minimum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minimum) {
                minimum = numbers[i];
            }
        }

        System.out.println("Minimum value: " + minimum);
    }

    public static void program2() {
        int[] numbers = new int[8];

        System.out.println("\nPROGRAM 2");
        System.out.println("Enter 8 integer numbers:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        int[] unique = new int[8];
        int uniqueCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            boolean duplicate = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (numbers[i] == unique[j]) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                unique[uniqueCount] = numbers[i];
                uniqueCount++;
            }
        }

        System.out.print("\nArray after removing duplicates: ");

        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(unique[i] + " ");
        }

        if (uniqueCount < 2) {
            System.out.println("\nSecond largest element: Not available");
            System.out.println("Second smallest element: Not available");
            return;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < uniqueCount; i++) {
            if (unique[i] > largest) {
                secondLargest = largest;
                largest = unique[i];
            } else if (unique[i] > secondLargest && unique[i] != largest) {
                secondLargest = unique[i];
            }
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < uniqueCount; i++) {
            if (unique[i] < smallest) {
                secondSmallest = smallest;
                smallest = unique[i];
            } else if (unique[i] < secondSmallest && unique[i] != smallest) {
                secondSmallest = unique[i];
            }
        }

        System.out.println("\nSecond largest element: " + secondLargest);
        System.out.println("Second smallest element: " + secondSmallest);
    }

    public static void program3() {
        System.out.println("\nPROGRAM 3");

        System.out.print("Enter Data in Array: ");
        String data = input.nextLine();

        String[] parts = data.trim().split("\\s+");
        int[] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        System.out.print("Stored Data in Array: ");

        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();

        System.out.print("Enter poss. of Element to Delete: ");
        int position = input.nextInt();

        if (position < 1 || position > numbers.length) {
            System.out.println("Invalid position.");
            return;
        }

        int[] newArray = new int[numbers.length - 1];

        for (int i = 0, j = 0; i < numbers.length; i++) {
            if (i != position - 1) {
                newArray[j] = numbers[i];
                j++;
            }
        }

        System.out.print("New data in Array: ");

        for (int number : newArray) {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    public static void program4() {
        System.out.println("\nPROGRAM 4");

        System.out.print("Enter Size of Array: ");
        int size = input.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter any " + size + " elements in Array:");

        for (int i = 0; i < size; i++) {
            numbers[i] = input.nextInt();
        }

        System.out.print("\nEven Elements: ");

        for (int i = 0; i < size; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.print(numbers[i] + " ");
            }
        }

        System.out.print("\nOdd Elements: ");

        for (int i = 0; i < size; i++) {
            if (numbers[i] % 2 != 0) {
                System.out.print(numbers[i] + " ");
            }
        }

        System.out.println();
    }

    public static void program5() {
        System.out.println("\nPROGRAM 5");
        System.out.println("*");
        System.out.println("*A*");
        System.out.println("*A*A*");
        System.out.println("*A*A*A*");
    }

    public static void program6() {
        System.out.println("\nPROGRAM 6");

        System.out.println("\n--- Enter details for Student 1 ---");
        Student student1 = new Student();

        System.out.print("Enter Student No: ");
        student1.setStudentNo(input.nextLine());
        System.out.print("Enter Student Name: ");
        student1.setStudentName(input.nextLine());
        System.out.print("Enter Date of Birth (MM/dd/yyyy): ");
        student1.setDateOfBirth(input.nextLine());
   
        System.out.println("\n--- Enter details for Student 2 ---");
        System.out.print("Enter Student No: ");
        String s2No = input.nextLine();
        System.out.print("Enter Student Name: ");
        String s2Name = input.nextLine();
        System.out.print("Enter Date of Birth (MM/dd/yyyy): ");
        String s2Dob = input.nextLine();
     
        Student student2 = new Student(s2No, s2Name, s2Dob, 150);

        System.out.println("\n===== Student 1 =====");
        System.out.println("Student No: " + student1.getStudentNo());
        System.out.println("Student Name: " + student1.getStudentName());
        System.out.println("Date of Birth: " + student1.getDateOfBirth());
        System.out.println("Tariff Points: " + student1.getTariffPoints());

        System.out.println("\n===== Student 2 =====");
        System.out.println("Student No: " + student2.getStudentNo());
        System.out.println("Student Name: " + student2.getStudentName());
        System.out.println("Date of Birth: " + student2.getDateOfBirth());
        System.out.println("Tariff Points: " + student2.getTariffPoints());

        System.out.println("\nNumber of Students: " + Student.getNoOfStudents());
    }

    public static void program7() {
        System.out.println("\nPROGRAM 7");

        File file = new File("C:\\Users\\SBH-CL3-WS01\\Documents\\LUNATO.txt");
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine(); // Fixed: changed File to String
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
            }
        }

class Student {

    private String studentNo;
    private String studentName;
    private String dateOfBirth;
    private int tariffPoints;

    private static int noOfStudents = 0;

    public Student() {
        this.studentNo = "not known";
        this.studentName = "not known";
        this.dateOfBirth = "01/01/1995";
        this.tariffPoints = 20;
        noOfStudents++;
    }

    public Student(String studentNo, String studentName, String dateOfBirth, int tariffPoints) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;

        if (tariffPoints >= 20 && tariffPoints <= 280) {
            this.tariffPoints = tariffPoints;
        } else {
            this.tariffPoints = 20;
        }

        noOfStudents++;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        if (studentNo != null && !studentNo.trim().isEmpty()) {
            this.studentNo = studentNo;
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        if (studentName != null && !studentName.trim().isEmpty()) {
            this.studentName = studentName;
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth != null && !dateOfBirth.trim().isEmpty()) {
            this.dateOfBirth = dateOfBirth;
        }
    }
public int getTariffPoints() {
        return tariffPoints;
    }

    public void setTariffPoints(int tariffPoints) {
        if (tariffPoints >= 20 && tariffPoints <= 280) {
            this.tariffPoints = tariffPoints;
        }
    }

    public static int getNoOfStudents() {
        return noOfStudents;
    }
}