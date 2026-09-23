import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class PhraseCreator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first word: ");
        String w1 = reader.readLine();

        System.out.print("Enter second word: ");
        String w2 = scanner.next();

        System.out.print("Enter third word: ");
        String w3 = scanner.next();

        System.out.println(w1 + " " + w2 + " " + w3);
        
        scanner.close();
    }
}
