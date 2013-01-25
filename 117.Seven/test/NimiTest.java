
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

public class NimiTest {
    @Points("117.1 117.2 117.3 117.4 117.5 117.6 117.7")
    @Test
    public void test() {
        assertTrue(true);
    }

    @Points("117.8 117.9 117.10")
    @Test
    public void test2() {
        assertTrue(false);
    }
}
