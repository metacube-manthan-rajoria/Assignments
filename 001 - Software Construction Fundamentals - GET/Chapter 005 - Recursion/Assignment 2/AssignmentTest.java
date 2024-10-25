import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class AssignmentTest {
    RecursiveSearch rs = new RecursiveSearch();
    int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    final int NUMBER_TO_SEARCH = 7;

    @Test
    public void linearSearchTest(){
        int linearResult = rs.linearSearch(arr, NUMBER_TO_SEARCH);
        assertEquals(5, linearResult);
    }

    @Test
    public void binarySearchTest(){
        int binaryResult = rs.binarySearch(arr, NUMBER_TO_SEARCH);
        assertEquals(6, binaryResult);
    }
}
