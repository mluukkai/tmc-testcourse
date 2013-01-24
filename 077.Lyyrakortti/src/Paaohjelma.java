import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // tee tänne koodia jolla testaat että Lyyrkortti toimii halutulla tavalla
        // muista kuitenkin pyyhkiä ylimääräinen koodi pois tehtävässä 77.6!

        //BEGIN SOLUTION
        LyyraKortti pekanKortti = new LyyraKortti(20);
        LyyraKortti matinKortti = new LyyraKortti(30);

        pekanKortti.syoMaukkaasti();
        matinKortti.syoEdullisesti();

        System.out.println("Pekka: " + pekanKortti);
        System.out.println("Matti: " + matinKortti);

        pekanKortti.lataaRahaa(20);
        matinKortti.syoMaukkaasti();

        System.out.println("Pekka: " + pekanKortti);
        System.out.println("Matti: " + matinKortti);

        pekanKortti.syoEdullisesti();
        pekanKortti.syoEdullisesti();
        matinKortti.lataaRahaa(50);

        System.out.println("Pekka: " + pekanKortti);
        System.out.println("Matti: " + matinKortti);
        //END SOLUTION       
    }
}
