package com.mycompany.laboneact;

import java.util.Scanner;
public class caseswitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("SWITCH CASE STATEMENT");
        
        String y;
        
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
            
            int score = (int) ave / 10;
            
            switch (score) {
                case 10:
                case 9:
                grade = 'A';
                break;
                case 8:
                grade = 'B';
                break;
                case 7:
                if (ave >= 75) {
                grade = 'C';
                } else {
                grade = 'F';
                }
                break;
                default:
                grade = 'F';
                break;
                }
        System.out.printf("Student's Grade: %.3f (%c)\n", ave, grade);
        
        System.out.print("\n - Do you want to continue: ");
        scanner.nextLine();
        y = scanner.nextLine();
        
        } while (y.equalsIgnoreCase("yes"));
        
        scanner.close();
}
}