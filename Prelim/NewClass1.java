import java.util.Scanner;

public class AssignTwo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: "); 
        int first = scanner.nextInt();

        System.out.print("Enter second number: "); 
        int second = scanner.nextInt();

        System.out.print("Enter third number: ");
        int third = scanner.nextInt();

        int highest = first;

        if (second > highest) { 
            highest = second; 
        }

        if (third > highest) { 
            highest = third;
        }

        System.out.println("The highest number is " + highest);

        scanner.close();
    }
}
