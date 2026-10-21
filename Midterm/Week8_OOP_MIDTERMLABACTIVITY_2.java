package com.mycompany.week8_oop_midtermlabactivity_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Week8_OOP_MIDTERMLABACTIVITY_2 {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your Name: ");
            String name = scanner.nextLine();
            System.out.println("\nWELCOME " + name.toUpperCase());
            
            String choice;
            
            do {
                try {
                    int page = -1;
                    int read = -1;


                    // 1. Validate Total Pages Input
                    while (true) {
                        System.out.println("\nHow many pages does the book have? ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("[Error] Decimals and letters are not allowed. Please enter a whole number.");
                            scanner.next(); // Clear invalid input
                            continue;
                        }
                        page = scanner.nextInt();
                        if (page < 0) {
                            System.out.println("[Error] Negative numbers are not allowed.");
                            continue;
                        }
                        if (page == 0) {
                            System.out.println("[Error] A book must have at least 1 page.");
                            continue;
                        }
                        break; // Input is valid whole number
                    }
                    
                    // 2. Validate Pages Read Input
                    while (true) {
                        System.out.println("\nHow many pages have you read? ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("[Error] Decimals and letters are not allowed. Please enter a whole number.");
                            scanner.next(); // Clear invalid input
                            continue;
                        }
                        read = scanner.nextInt();
                        if (read < 0) {
                            System.out.println("[Error] Negative numbers are not allowed.");
                            continue;
                        }
                        if (read > page) {
                            System.out.println("[Error] You cannot read more pages than the book actually has (" + page + ").");
                            continue;
                        }
                        break; // Input is valid whole number
                    }
                    
                    scanner.nextLine(); // Crucial: Clears the input buffer after reading numbers
                    
                    // Define the custom date pattern matching your lab sheet (e.g., 08 1, 21)
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM d, yy");
                    
                    System.out.println("\nIssue date (Format: MM DD, YY, e.g., 08 1, 21): ");
                    String issueInput = scanner.nextLine();
                    LocalDate issueDate = LocalDate.parse(issueInput, formatter);
                    
                    System.out.println("\nDue Date (Format: MM DD, YY, e.g., 08 15, 21): ");
                    String dueInput = scanner.nextLine();
                    LocalDate dueDate = LocalDate.parse(dueInput, formatter);
                    
                    // 1. Calculate the percentage of the book you read
                    double percent = ((double) read / page) * 100;
                    System.out.printf("\nYou have read %.2f%% of the book.\n", percent);
                    
                    // 2. Calculate the days remaining or check if overdue
                    long days = ChronoUnit.DAYS.between(issueDate, dueDate); 
                    
                    if (days < 0) {
                        // Calculate exact overdue days by getting the absolute difference
                        long overdueDays = Math.abs(days);
                        System.out.println("The book is overdue by " + overdueDays + " day(s) and you have to return the book.");
                    } else {
                        System.out.println("You have " + days + " days remaining to return the book.");
                    }
                    
                    // 3. Calculate the pages left and how many pages you should read daily
                    int pagesLeft = page - read;
                    long leftPerDay = 0;
                    if (days > 0) {
                        leftPerDay = (long) Math.ceil((double) pagesLeft / days);
                    }
                    
                    System.out.println("You still have " + pagesLeft + " page(s) left and you should read " + leftPerDay + " pages a day.");
                    
                } catch (java.time.format.DateTimeParseException e) {
                    System.out.println("\n[Error] Invalid date format typed. Please write it exactly like: 08 1, 21");
                } catch (Exception e) {
                    System.out.println("\n[Error] An unexpected calculation or input error occurred.");
                }
                
                // Prompting to loop again
                System.out.print("\nDo you want to continue? (YES/NO): ");
                choice = scanner.nextLine().trim().toUpperCase();
                
            } while (choice.equals("YES") || choice.equals("Y"));
            
            System.out.println("\nThank you for using the Library System! Goodbye.");
        }
    }
}