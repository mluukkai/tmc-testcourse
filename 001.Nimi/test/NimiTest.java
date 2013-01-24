import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.MockStdio;


public class NimiTest {
    @Rule
    public MockStdio io = new MockStdio();

	 @Points("1.1")
    @Test
    public void test() {
        Nimi.main(new String[0]);
        String out = io.getSysOut();
        assertTrue("Et tulostanut mitään!",out.length()>0);
    }

	 @Points("1.2")
    @Test
    public void test2() {
        Nimi.main(new String[0]);
        String out = io.getSysOut();
        assertTrue("nimen pituus ei voi olla alle 5",out.length()>5);
    }
}
