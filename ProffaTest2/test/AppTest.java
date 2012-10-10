
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.lolcatz.profiler.*;

@Points("99")
public class AppTest {

    @BeforeClass
    public static void classSetup() {
        Util.loadAgent();
        ProfileData.initialize();
    }

    @Before
    public void testSetup() {
        ProfileData.resetCounters();
    }

    @Test
    public void sumWorks() {
        assertEquals(6, Main.sum(3));
    }

    @Test
    public void sumLinear() throws Throwable {
        String className = "Main";
        String method = "sum";
        
        long t1 = call(className, method, 100);
        long t2 = call(className, method, 200);
        long t3 = call(className, method, 300);
        long t4 = call(className, method, 400);
        long t5 = call(className, method, 500);

        assertTrue("method "+ method+" not linear:  \n"
                + "100: " + t1 + "\n200: " + t2 + "\n300: " + t3 + "\n400: " + t4 + "\n500: " + t5, linear(t1, t2, t3, t4, t5));
    }
    
    @Test
    public void sum2Linear() throws Throwable {
        String className = "Main";
        String method = "sum2";
        
        long t1 = call(className, method, 100);
        long t2 = call(className, method, 200);
        long t3 = call(className, method, 300);
        long t4 = call(className, method, 400);
        long t5 = call(className, method, 500);

        assertTrue("method "+ method+" not linear:  \n"
                + "100: " + t1 + "\n200: " + t2 + "\n300: " + t3 + "\n400: " + t4 + "\n500: " + t5, linear(t1, t2, t3, t4, t5));
    }    

    private boolean linear(long... t) {
        long first = t[1] - t[0];

        for (int i = 1; i < t.length - 1; i++) {
            if (!aboutSame(first, t[i + 1] - t[i])) {
                return false;
            }
        }

        return true;
    }

    private boolean aboutSame(long v1, long v2) {
        return Math.abs(v2-v1) < 0.2 * v1;
    }

    private long call(String className, String method, int n) throws Throwable {
        ProfileData.resetCounters();
        Reflex.ClassRef<Object> klass = Reflex.reflect(className);
        klass.staticMethod(method).returning(int.class).taking(int.class).invoke(n);
        return ProfileData.getTotalCost();
    }
}
