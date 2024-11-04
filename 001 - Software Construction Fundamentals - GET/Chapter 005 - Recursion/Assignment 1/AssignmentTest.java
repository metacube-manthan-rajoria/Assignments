import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class AssignmentTest {
    MathOperations mathop = new MathOperations();

    @Test
    public void hcfTest(){
        assertEquals(50, mathop.getLCM(25, 10));
    }

    @Test
    public void lcmTest(){
        assertEquals(5, mathop.getHCF(25, 10));
    }
}
