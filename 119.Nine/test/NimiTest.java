
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

public class NimiTest {
    @Points("119.1 119.2 119.3 119.4 119.5 119.6 119.7 119.8 119.9")
    @Test
    public void test() {
        assertTrue(true);
    }

    @Points("119.10")
    @Test
    public void test2() {
        assertTrue(false);
    }
}
