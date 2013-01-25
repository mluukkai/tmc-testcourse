
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

public class NimiTest {
    @Points("116.1 116.2 116.3 116.4 116.5 116.6")
    @Test
    public void test() {
        assertTrue(true);
    }

    @Points("116.7 116.8 116.9 116.10")
    @Test
    public void test2() {
        assertTrue(false);
    }
}
