package com.mycompany.laboneact;

import java.util.Scanner;

public class LABTWOACT {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("IF ELSE STATEMENT");
        
        String k;
        
        do {
            System.out.print("\n - Enter Java Programming score: ");
            double j = scanner.nextDouble();
            
            System.out.print(" - Enter C Programming score: ");
            double c = scanner.nextDouble();
            
            System.out.print(" - Enter Database Handling score: ");
            double d = scanner.nextDouble();
            
        double add = j + c + d;
        double ave = add / 3.0;
        char grade;
        
        if (ave >= 90 && ave <= 100){
            grade = 'A';
        } else if (ave >= 80 && ave <= 89){
            grade = 'B';
        } else if (ave >= 75 && ave <= 79){
            grade = 'C';
        } else {
            grade = 'F';
        }
        
        System.out.printf("Student's Grade: %.3f (%c)\n", ave, grade);
        
        System.out.print("\nDo you want to continue: ");
        scanner.nextLine();
        k = scanner.nextLine();
        
        } while (k.equalsIgnoreCase("yes"));
        scanner.close();
}
}