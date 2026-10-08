package com.mycompany.whileloop;
import java.util.Scanner;

public class Whileloop {
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
