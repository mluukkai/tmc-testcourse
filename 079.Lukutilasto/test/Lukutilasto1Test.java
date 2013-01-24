
import fi.helsinki.cs.tmc.edutestutils.MockInOut;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Lukutilasto1Test {
    
    Random seka = new Random();
    String luokanNimi = "Lukutilasto";
    Class laskuriLuokka;
    Reflex.ClassRef<Object> klass;
    String klassName = "Lukutilasto";

    @Before
    public void haeLuokka() {
        klass = Reflex.reflect(klassName);
    }

    @Points("79.1 79.2 79.3 79.4 79.5 79.6 79.7 79.8 79.9")
    @Test
    public void luokkaJulkinen() {
        assertTrue("Luokan " + klassName + " pitää olla julkinen, eli se tulee määritellä\n"
                + "public class " + klassName + " {...\n}", klass.isPublic());
    }


    @Points("79.10")
    @Test
    public void parillisetJaParittomat() {
        MockInOut mio = new MockInOut("2\n4\n1\n6\n-1\n");
        try {
            Paaohjelma.main(new String[0]);
        } catch (Exception e) {
            fail("Ohjelman tulee lopettaa syötteiden lukeminen kun -1 on syötetty");
        }
        String[] rivit = mio.getOutput().split("\n");
        String summaRivi = hae(rivit, "umma");

        assertTrue("tarkasta että ohjelmassasi on rivi jossa tulostetaan \"Summa \"", summaRivi != null);
        assertTrue("syötteellä 2 4 1 6 -1 ohjelman pitäisi tulostaa Summa: 13, tulostui: " + summaRivi, summaRivi.contains("13"));

        String parillisetRivi = hae(rivit, "llist");
        assertTrue("tarkasta että ohjelmassasi on rivi jossa tulostetaan \"Parillisten summa \"", parillisetRivi != null);
        assertTrue("Ohjelmasi pitää olla tulostusrivi muotoa \"Parillisten summa: 10\" missä 10: tilalla siis parillisten summa ", parillisetRivi != null);
        assertTrue("syötteellä 2 4 1 6 -1 ohjelman pitäisi tulostaa Parillisten summa: 12, tulostui: " + parillisetRivi, parillisetRivi.contains("12"));

        String parittomatRivi = hae(rivit, "ttomi");
        assertTrue("tarkasta että ohjelmassasi on rivi jossa tulostetaan \"Parittomien summa \"", parittomatRivi != null);
        assertTrue("syötteellä 2 4 1 6 -1 ohjelman pitäisi tulostaa Parittomien summa 1, tulostui: " + parittomatRivi, parittomatRivi.contains("1"));
        assertTrue("Ohjelmasi pitää olla tulostusrivi muotoa \"Parittomien summa: 10\" missä 10: tilalla siis parittomien summa ", parittomatRivi != null);
    }
    
    
    /*
     * 
     */
    
    private Object newLukutilasto() {
        try {
            laskuriLuokka = ReflectionUtils.findClass(luokanNimi);
            return ReflectionUtils.invokeConstructor(laskuriLuokka.getConstructor());
        } catch (Throwable t) {
            fail("tarkista että seuraava onnistuu pääohjelmassa:  Lukutilasto tilasto = new Lukutilasto();");
        }
        return null;
    }

    private void lisaaLukuMock(Object olio, int luku) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(olio.getClass(), "lisaaLuku", int.class);
        ReflectionUtils.invokeMethod(void.class, metodi, olio, luku);
    }

    private void lisaaLuku(Object olio, int luku) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(laskuriLuokka, "lisaaLuku", int.class);
        ReflectionUtils.invokeMethod(void.class, metodi, olio, luku);
    }

    private double keskiarvo(Object olio) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(laskuriLuokka, "keskiarvo");
        return ReflectionUtils.invokeMethod(double.class, metodi, olio);
    }

    private int summa(Object olio) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(laskuriLuokka, "summa");
        return ReflectionUtils.invokeMethod(int.class, metodi, olio);
    }

    private int summaMock(Object olio) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(olio.getClass(), "summa");
        return ReflectionUtils.invokeMethod(int.class, metodi, olio);
    }

    private int haeLukujenMaara(Object olio) throws Throwable {
        Method metodi = ReflectionUtils.requireMethod(laskuriLuokka, "haeLukujenMaara");
        return ReflectionUtils.invokeMethod(int.class, metodi, olio);
    }

    private String toString(Object kortti) throws Throwable {
        Method toString = ReflectionUtils.requireMethod(laskuriLuokka, "toString");
        return ReflectionUtils.invokeMethod(String.class, toString, kortti);
    }

    private void saniteettitarkastus() throws SecurityException {
        Field[] kentat = ReflectionUtils.findClass(luokanNimi).getDeclaredFields();

        for (Field field : kentat) {
            assertFalse("et tarvitse \"stattisia muuttujia\", poista " + kentta(field.toString()), field.toString().contains("static") && !field.toString().contains("final"));
            assertTrue("luokan kaikkien oliomuuttujien näkyvyyden tulee olla private, muuta " + kentta(field.toString()), field.toString().contains("private"));
        }

        if (kentat.length > 1) {
            int var = 0;
            for (Field field : kentat) {
                if (!field.toString().contains("final")) {
                    var++;
                }
            }
            assertTrue("et tarvitse " + luokanNimi + "-luokalle kuin lukujen määrän ja summan muistavat oliomuuttujat (keskiarvon voit laskea niiden avulla), poista ylimääräiset", var < 3);
        }
    }

    private String toString(int[] luvut) {
        String mj = "";
        for (int luku : luvut) {
            mj += luku + " ";
        }
        return mj;
    }

    private String enter(int[] luvut) {
        String mj = "";
        for (int luku : luvut) {
            mj += luku + "\n";
        }
        return mj + "-1\n";
    }

    private int[] arvo(int lkm) {
        int[] luvut = new int[lkm];

        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = seka.nextInt(30);
        }

        return luvut;
    }

    private String hae(String[] rivit, String sana) {
        for (String rivi : rivit) {
            if (rivi.contains(sana)) {
                return rivi;
            }
        }

        return null;
    }

    private Object newOlio() throws Throwable {
        Reflex.MethodRef0<Object, Object> ctor = klass.constructor().takingNoParams().withNiceError();
        assertTrue("Määrittele luokalle " + klassName + " julkinen konstruktori: public " + klassName + "()", ctor.isPublic());
        return ctor.invoke();
    }

    private void hasMethod0(Object olio, String name, Class<?> returns) throws Throwable {
        hasMethod0(olio, name, returns, "");
    }

    private void hasMethod0(Object olio, String name, Class<?> returns, String msg) throws Throwable {
        String paluu = returns.toString();
        String muuttuja = ("" + klassName.charAt(0)).toLowerCase();

        assertTrue("tee luokalle " + klassName + " metodi public " + paluu + " " + name + "()",
                klass.method(olio, name).returning(returns).takingNoParams().isPublic());

        String v = "\nVirheen aiheuttanut koodi "
                + klassName + " " + muuttuja + " = new " + klassName + "(); " + muuttuja + "." + name + "();";

        if (!msg.isEmpty()) {
            msg = "\n" + msg;
        }

        klass.method(olio, name).returning(returns).takingNoParams().withNiceError(v + msg).invoke();
    }

    private void hasVoidMethodInt(Object olio, String name, int v1) throws Throwable {
        String muuttuja = ("" + klassName.charAt(0)).toLowerCase();

        assertTrue("tee luokalle " + klassName + " metodi public void " + name + "(int luku) ",
                klass.method(olio, name).returningVoid().taking(int.class).isPublic());

        String v = "\nVirheen aiheuttanut koodi "
                + klassName + " " + muuttuja + " = new " + klassName + "(); " + muuttuja + "." + name + "(" + v1 + ");";

        klass.method(olio, name).returningVoid().taking(int.class).withNiceError(v).invoke(v1);

    }

    private String kentta(String toString) {
        return toString.replace(klassName + ".", "");
    }
}