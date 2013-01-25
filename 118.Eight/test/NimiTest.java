
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

public class NimiTest {
    @Points("118.1 118.2 118.3 118.4 118.5 118.6 118.7 118.8")
    @Test
    public void test() {
        assertTrue(true);
    }

    @Points("118.9 118.10")
    @Test
    public void test2() {
        assertTrue(false);
    }
}
