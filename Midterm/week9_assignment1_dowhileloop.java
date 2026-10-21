package com.mycompany.week9_assignment1_dowhileloop;

import java.util.Scanner;

public class Week9_assignment1_dowhileloop{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        int i = 0; 
        
        do {
            System.out.print(name + " \n");
            i++; 
        } while (i < 5);
        
        scanner.close();
    }
}
