
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

public class NimiTest {
    @Points("111.1")
    @Test
    public void test() {
        assertTrue(true);
    }

    @Points("111.2 111.3 111.4 111.5 111.6 111.7 111.8 111.9 111.10")
    @Test
    public void test2() {
        assertTrue(false);
    }
}
