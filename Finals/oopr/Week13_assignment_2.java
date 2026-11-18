package com.mycompany.week13_assignment_2;

import java.util.Scanner;

public class Week13_assignment_2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.print("Enter five numbers: ");
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }

        int highest = numbers[0];
        for (int i = 1; i < 5; i++) {
            if (numbers[i] > highest) {
                highest = numbers[i];
            }
        }

        System.out.println("The highest is: " + highest);

        System.out.println("The difference from the highest are:");
        for (int i = 0; i < 5; i++) {
            int difference = highest - numbers[i];
            System.out.println(highest + " - " + numbers[i] + " = " + difference);
        }

        scanner.close();
    }
}
