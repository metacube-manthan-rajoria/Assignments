import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;

public class ArrayTest {
    private static Stream<Arguments> maxMirrorStream() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 3),
                Arguments.of(new int[] { 7, 1, 4, 9, 7, 4, 1 }, 2),
                Arguments.of(new int[] { 6, 5, 6, 4, 9, 7, 1, 4, 2, 7, 9, 2, 6, 5, 6 }, 3),
                Arguments.of(new int[] { 1, 2, 1, 4 }, 3),
                Arguments.of(new int[] { 1, 4, 5, 3, 5, 4, 1 }, 7),
                Arguments.of(new int[] { 1, 1, 2, 1, 1, 4 }, 5),
                Arguments.of(new int[] { 1, 4, 1, 5 }, 3),
                Arguments.of(new int[] { 1, 4, 1, 5, 5, 4, 1 }, 3),
                Arguments.of(new int[] { 1, 1, 1, 2, 1 }, 3));
    }

    @ParameterizedTest
    @MethodSource("maxMirrorStream")
    public void maxMirrorTest(int arr[], int output) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
        }

        ArrOperation arrop = new ArrOperation(arrList);
        assertEquals(output, arrop.maxMirror());
    }
}
