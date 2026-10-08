package com.mycompany.dowhileloop;

import java.util.Scanner;

public class Dowhileloop {
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
