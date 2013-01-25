
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

public class NimiTest {
    @Points("115.1 115.2 115.3 115.4 115.5")
    @Test
    public void test() {
        assertTrue(true);
    }

    @Points("115.6 115.7 115.8 115.9 115.10")
    @Test
    public void test2() {
        assertTrue(false);
    }
}
