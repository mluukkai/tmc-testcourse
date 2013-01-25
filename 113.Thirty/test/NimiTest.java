
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

public class NimiTest {
    @Points("113.1 113.2 113.3")
    @Test
    public void test() {
        assertTrue(true);
    }

    @Points("113.4 113.5 113.6 113.7 113.8 113.9 113.10")
    @Test
    public void test2() {
        assertTrue(false);
    }
}
