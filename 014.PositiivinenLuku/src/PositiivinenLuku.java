
import java.util.Scanner;

public class PositiivinenLuku {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän. 
        // BEGIN SOLUTION
        System.out.print("Anna luku: ");
        int luku = Integer.parseInt(lukija.nextLine());

        System.out.println(""); // tyhjä rivi
        if (luku > 0) {
            System.out.println("Luku on positiivinen.");
        } else {
            System.out.println("Luku ei ole positiivinen.");
        }
        // END SOLUTION
    }
}
