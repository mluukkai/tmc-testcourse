
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

public class NimiTest {
    @Points("120.1")
    @Test
    public void test1() {
        assertTrue(Main.metodi()>0);
    }

    @Points("120.2")
    @Test
    public void test2() {
       assertTrue(Main.metodi()>1);
    }    
    
    @Points("120.3")
    @Test
    public void test3() {
       assertTrue(Main.metodi()>2);
    }   
    
    @Points("120.4")
    @Test
    public void test4() {
       assertTrue(Main.metodi()>3);
    }       

}
