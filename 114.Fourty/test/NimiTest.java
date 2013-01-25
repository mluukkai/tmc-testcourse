
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

public class NimiTest {
    @Points("114.1 114.2 114.3 114.4")
    @Test
    public void test() {
        assertTrue(true);
    }

    @Points("114.5 114.6 114.7 114.8 114.9 114.10")
    @Test
    public void test2() {
        assertTrue(false);
    }
}
