
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

public class NimiTest {
    @Points("112.1 112.2")
    @Test
    public void test() {
        assertTrue(true);
    }

    @Points("112.3 112.4 112.5 112.6 112.7 112.8 112.9 112.10")
    @Test
    public void test2() {
        assertTrue(false);
    }
}
