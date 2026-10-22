package com.mycompany.week9_ooprmidterm_labactivity3;


import java.util.Scanner;


public class Week9_ooprmidterm_labactivity3 {
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("===== MIDTERM PROGRAMMING ACTIVITIES =====\n");
        
        while (true) {
            System.out.println("Choose the program you want to run:\n");
            System.out.println("Program 1");
            System.out.println("Program 2");
            System.out.println("Program 3");
            System.out.println("Program 4");
            System.out.println("Program 5");
            System.out.println("Program 6");
            System.out.println("Program 7");
            System.out.println("Program 8");
            System.out.println("Program 9");
            System.out.println("Program 10");
            System.out.println("Program 11");
            System.out.println("Program 12");
            System.out.println("Program 13");
            System.out.println("Program 14");
            System.out.println("Program 15");
            System.out.println("Program 16");
            System.out.println("Program 17");
            System.out.println("Program 18");
            System.out.println("Program 19");
            System.out.println("Program 20");
            System.out.println("Program 21");
            System.out.println("Program 22");
            System.out.println("Program 23");
            System.out.println("Program 24");
            System.out.println("Program 25");
            System.out.println("Program 26");
            System.out.println("Program 27");
            System.out.println("Program 28");
            System.out.println("Program 29");
            System.out.println("Program 30");
            System.out.println("Program 31");
            System.out.print("\nEnter the number: ");
            
            if (!input.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                input.next();
                System.out.print("\nDo you want to continue? (Y/N): ");
                char c = Character.toUpperCase(input.next().charAt(0));
                if (c != 'Y') { System.out.println("Program ended."); break; }
                continue;
            }
            
            int choice = input.nextInt();
            System.out.println();
            
            switch (choice) {
                case 1:  program1();  break;
                case 2:  program2();  break;
                case 3:  program3();  break;
                case 4:  program4();  break;
                case 5:  program5();  break;
                case 6:  program6();  break;
                case 7:  program7();  break;
                case 8:  program8();  break;
                case 9:  program9();  break;
                case 10: program10(); break;
                case 11: program11(); break;
                case 12: program12(); break;
                case 13: program13(); break;
                case 14: program14(); break;
                case 15: program15(); break;
                case 16: program16(); break;
                case 17: program17(); break;
                case 18: program18(); break;
                case 19: program19(); break;
                case 20: program20(); break;
                case 21: program21(); break;
                case 22: program22(); break;
                case 23: program23(); break;
                case 24: program24(); break;
                case 25: program25(); break;
                case 26: program26(); break;
                case 27: program27(); break;
                case 28: program28(); break;
                case 29: program29(); break;
                case 30: program30(); break;
                case 31: program31(); break;
                default: System.out.println("Invalid number! Please choose 1-31.");
            }
            
            System.out.print("\nDo you want to continue? (Y/N): ");
            char cont = Character.toUpperCase(input.next().charAt(0));
            if (cont != 'Y') {
                System.out.println("Program ended.");
                break;
            }
        }
        input.close();
    }


    static void program1() {
        System.out.println("----- PROGRAM 1: Vowel or Consonant -----");
        System.out.print("Enter a letter: ");
        char letter = Character.toUpperCase(input.next().charAt(0));
        if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U') {
            System.out.println(letter + " is a VOWEL");
        } else if (letter >= 'A' && letter <= 'Z') {
            System.out.println(letter + " is a CONSONANT");
        } else {
            System.out.println("Invalid input!");
        }
    }


    static void program2() {
        System.out.println("----- PROGRAM 2: Date Converter -----");
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        System.out.print("Enter day: ");
        int day = input.nextInt();
        System.out.print("Enter year: ");
        int year = input.nextInt();
        String monthName = "";
        switch (month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December"; break;
            default: System.out.println("Invalid month!"); return;
        }
        System.out.println(monthName + " " + day + ", " + year);
    }


    static void program3() {
        System.out.println("----- PROGRAM 3: Temperature Check -----");
        System.out.print("Enter temperature: ");
        double temp = input.nextDouble();
        if (temp < 0) System.out.println("ICE");
        else if (temp <= 100) System.out.println("WATER");
        else System.out.println("STEAM");
    }


    static void program4() {
        System.out.println("----- PROGRAM 4: Aircraft Identification -----");
        System.out.print("Speed (km/h): ");
        double speed = input.nextDouble();
        System.out.print("Length (m): ");
        double len = input.nextDouble();
        if (speed > 1100 && len > 52) System.out.println("CIVILIAN aircraft");
        else if (speed >= 500) System.out.println("MILITARY aircraft");
        else System.out.println("It's a bird");
    }


    static void program5() {
        System.out.println("----- PROGRAM 5: Ship Class -----");
        System.out.print("Enter Class ID: ");
        String id = input.next();
        if (id.equalsIgnoreCase("Borb")) System.out.println("Battleship");
        else if (id.equalsIgnoreCase("Corc")) System.out.println("Cruiser");
        else if (id.equalsIgnoreCase("Dord")) System.out.println("Destroyer");
        else if (id.equalsIgnoreCase("Forf")) System.out.println("Frigate");
        else System.out.println("Invalid ID");
    }


    static void program6() {
        System.out.println("----- PROGRAM 6: Earthquake Scale -----");
        System.out.print("Richter value: ");
        double r = input.nextDouble();
        if (r > 7.5) System.out.println("Catastrophe");
        else if (r >= 6.5) System.out.println("Disaster");
        else if (r >= 5.5) System.out.println("Serious damage");
        else if (r >= 5.0) System.out.println("Some damage");
        else System.out.println("Little or no damage");
    }


    static void program7() {
        System.out.println("----- PROGRAM 7: Number to Words -----");
        System.out.print("Enter number (0-3000): ");
        int n = input.nextInt();
        if (n < 0 || n > 3000) { System.out.println("Out of range"); return; }
        String[] ones = {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] tens = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        if (n == 0) { System.out.println("zero"); return; }
        if (n == 3000) { System.out.println("three thousand"); return; }
        StringBuilder w = new StringBuilder();
        if (n >= 1000) { w.append(ones[n/1000]).append(" thousand "); n %= 1000; }
        if (n >= 100) { w.append(ones[n/100]).append(" hundred "); n %= 100; }
        if (n >= 20) { w.append(tens[n/10]).append(" "); n %= 10; }
        if (n > 0) w.append(ones[n]);
        System.out.println(w.toString().trim());
    }


    static void program8() {
        System.out.println("----- PROGRAM 8: Roman Numerals -----");
        System.out.print("Enter number (1-300): ");
        int n = input.nextInt();
        if (n < 1 || n > 300) { System.out.println("Out of range"); return; }
        int[] v = {100,90,50,40,10,9,5,4,1};
        String[] s = {"C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder r = new StringBuilder();
        for (int i=0; i<v.length; i++) while (n >= v[i]) { r.append(s[i]); n -= v[i]; }
        System.out.println("Roman: " + r);
    }


    static void program9() {
        System.out.println("----- PROGRAM 9: Tuition Fee -----");
        System.out.print("Enter tuition fee: ");
        double t = input.nextDouble();
        System.out.println("(1=Cash, 2=Two-Installment, 3=Three-Installment)");
        System.out.print("Enter mode: ");
        int m = input.nextInt();
        double total = 0;
        if (m == 1) total = t * 0.90;
        else if (m == 2) total = t * 0.95;
        else if (m == 3) total = t * 1.10;
        else { System.out.println("Invalid option"); return; }
        System.out.printf("Total tuition fee: %.0f%n", total);
    }


    static void program10() {
        System.out.println("----- PROGRAM 10: Grade Equivalent -----");
        System.out.print("Enter percentile grade: ");
        int g = input.nextInt();
        if (g >= 98 && g <= 100) System.out.println("1.00");
        else if (g >= 95) System.out.println("1.25");
        else if (g >= 92) System.out.println("1.50");
        else if (g >= 89) System.out.println("1.75");
        else if (g >= 85) System.out.println("2.00");
        else if (g >= 82) System.out.println("2.25");
        else if (g >= 80) System.out.println("2.50");
        else if (g >= 77) System.out.println("2.75");
        else if (g >= 75) System.out.println("3.00");
        else System.out.println("Out-of-Range");
    }


    static void program11() {
        System.out.println("----- PROGRAM 11: Sequence & Squared -----");
        System.out.println("Number\tSquare");
        for (int i = 1; i <= 5; i++) System.out.println(i + "\t" + (i*i));
    }


    static void program12() {
        System.out.println("----- PROGRAM 12: Alternate Sequence -----");
        for (int a = 1, b = 5; a <= 5; a++, b--) System.out.print(a + ", " + b + ", ");
        System.out.println();
    }


    static void program13() {
        System.out.println("----- PROGRAM 13: Reverse Alternate Sequence -----");
        for (int a = 5, b = 1; a >= 1; a--, b++) System.out.print(a + ", " + b + ", ");
        System.out.println();
    }


    static void program14() {
        System.out.println("----- PROGRAM 14: Factorial -----");
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        long f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        System.out.println(n + "! = " + f);
    }


    static void program15() {
        System.out.println("----- PROGRAM 15: Fibonacci Sequence -----");
        System.out.print("Enter number of terms: ");
        int n = input.nextInt();
        int a = 1, b = 1;
        System.out.print("Fibonacci: " + a + " " + b + " ");
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b; b = c;
        }
        System.out.println();
    }


    static void program16() {
        System.out.println("----- PROGRAM 16: Power Calculation -----");
        System.out.print("Enter base: ");
        int b = input.nextInt();
        System.out.print("Enter exponent: ");
        int e = input.nextInt();
        long r = 1;
        for (int i = 1; i <= e; i++) r *= b;
        System.out.println(b + "^" + e + " = " + r);
    }


    static void program17() {
        System.out.println("----- PROGRAM 17: Sum of Squares -----");
        System.out.print("Enter n: ");
        int n = input.nextInt();
        int s = 0;
        for (int i = 1; i <= n; i++) s += i * i;
        System.out.println("Sum of squares = " + s);
    }


    static void program18() {
        System.out.println("----- PROGRAM 18: Sum of Numbers -----");
        System.out.print("Enter n: ");
        int n = input.nextInt();
        int s = 0;
        for (int i = 1; i <= n; i++) s += i;
        System.out.println("Sum = " + s);
    }


    static void program19() {
        System.out.println("----- PROGRAM 19: Reverse a Number -----");
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        int r = 0;
        while (n != 0) {
            r = r * 10 + (n % 10);
            n /= 10;
        }
        System.out.println("Reversed = " + r);
    }


    static void program20() {
        System.out.println("----- PROGRAM 20: Sum of Powers -----");
        System.out.print("Enter n: ");
        int n = input.nextInt();
        long s = 0;
        for (int i = 1; i <= n; i++) {
            long p = 1;
            for (int j = 1; j <= i; j++) p *= i;
            s += p;
        }
        System.out.println("Sum = " + s);
    }


    static void program21() {
        System.out.println("----- PROGRAM 21: Right-Angle Triangle (*) -----");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }


        static void program22() {
        System.out.println("----- PROGRAM 22: Floyd's Triangle (1s and 0s) -----");
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                // Alternates printing 1 and 0
                System.out.print(num + " ");
                num = (num == 1) ? 0 : 1;
            }
            System.out.println();
        }
    }


    static void program23() {
        System.out.println("----- PROGRAM 23: Pyramid (Odd Asterisks) -----");
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j > i; j--) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }


    static void program24() {
        System.out.println("----- PROGRAM 24: Pyramid (Repeating Numbers) -----");
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j > i; j--) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print(i + " ");
            System.out.println();
        }
    }


    static void program25() {
        System.out.println("----- PROGRAM 25: Pyramid (Asterisks) -----");
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j > i; j--) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }


    static void program26() {
        System.out.println("----- PROGRAM 26: Pyramid (Increasing Numbers) -----");
        int n = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j > i; j--) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print(n++ + " ");
            System.out.println();
        }
    }


    static void program27() {
        System.out.println("----- PROGRAM 27: Right Triangle (Numbers +1) -----");
        int n = 1;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) System.out.print(n++ + " ");
            System.out.println();
        }
    }


    static void program28() {
        System.out.println("----- PROGRAM 28: Right Triangle (Repeat Number) -----");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) System.out.print(i + " ");
            System.out.println();
        }
    }


    static void program29() {
        System.out.println("----- PROGRAM 29: Right Triangle (Number Sequence) -----");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) System.out.print(j + " ");
            System.out.println();
        }
    }


    static void program30() {
        System.out.println("----- PROGRAM 30: Diamond Pattern -----");
        int h = 5;
        for (int i = 1; i <= h; i++) {
            for (int j = h; j > i; j--) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
        for (int i = h - 1; i >= 1; i--) {
            for (int j = h; j > i; j--) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }


        static void program31() {
        System.out.println("----- PROGRAM 31: Aligned Pyramid -----");
        System.out.print("Enter number of rows: ");
        int n = input.nextInt();
        
        for (int i = 1; i <= n; i++) {
            // Print leading spaces for alignment
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            
            // Fix the alignment for the very first row
            if (i == 1) {
                System.out.print(" ");
            }
            
            // Print the increasing sequence up to 'i'
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            
            // Append the final '1' for rows 2 and above
            if (i > 1) {
                System.out.print("1 ");
            }
            
            System.out.println();
        }
    }
}