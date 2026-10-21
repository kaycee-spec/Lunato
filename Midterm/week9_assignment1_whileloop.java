package com.mycompany.week9_assignment1_whileloop;
import java.util.Scanner;

public class Week9_assignment1_whileloop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        int i = 0; 
        
        while (i < 5) {
            System.out.print(name + " \n");
            i++; 
        }
        
        scanner.close();
    }
}
