package com.mycompany.week9_assignment1_forloop;
import java.util.Scanner;

public class Week9_assignment1_forloop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        for (int i = 0; i < 5; i++) {
            System.out.print(name + " \n");
        }
        
        scanner.close();
    }
}
