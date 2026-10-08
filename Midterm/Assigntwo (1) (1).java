import java.util.Scanner;

public class Assigntwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a letter: ");

        char ch = scanner.next().charAt(0);

        if (Character.isLetter(ch)) {

            char lowerCh = Character.toLowerCase(ch);

            if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                System.out.println("It's a vowel!");
            } else {
                System.out.println("It's a consonant!");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid letter.");
        }

        scanner.close();
    }
}
