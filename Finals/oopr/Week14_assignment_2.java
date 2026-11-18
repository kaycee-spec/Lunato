package com.mycompany.week14_assignment_2;

import java.util.Scanner;

public class Week14_assignment_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Declare a 3x4 two-dimensional array to hold 12 numbers
        int[][] numbers = new int[3][4];
        
        // Prompt and read 12 numbers into the 2D array
        System.out.print("Enter 12 numbers: ");
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col] = scanner.nextInt();
            }
        }
        
        // Prompt for the number to search
        System.out.print("Enter a number to search: ");
        int searchNum = scanner.nextInt();
        
        // Count occurrences of the target number
        int count = 0;
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                if (numbers[row][col] == searchNum) {
                    count++;
                }
            }
        }
        
        // Display the result
        System.out.println("Occurrence/s: " + count);
        
        scanner.close();
    }
}
