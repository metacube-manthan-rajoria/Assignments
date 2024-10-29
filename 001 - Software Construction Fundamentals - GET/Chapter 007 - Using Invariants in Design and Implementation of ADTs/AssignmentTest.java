import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.util.StringUtils;
import java.util.stream.*;

public class AssignmentTest {

    private static Stream<Arguments> matrixProduct(){
        return Stream.of(
            Arguments.of(
                new int[][][]
                {
                    {
                        {1, 0, 0},
                        {3, 0, 4},
                        {1, 2, 0},
                    },
                    {
                        {0, 1},
                        {2, 0},
                        {2, 1},
                    }
                },
                new int[][]
                {
                    {0, 1},
                    {8, 7},
                    {4, 1},
                }
            ),
            Arguments.of(
                new int[][][]
                {
                    {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                    },
                    {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                    }
                },
                new int[][]
                {
                    {30, 36, 42},
                    {66, 81, 96},
                    {102, 126, 150}
                }
            ),
            Arguments.of(
                new int[][][]
                {
                    {
                        { 1, 2 },
                        { 3, 4 },
                        { 5, 6 },
                    },
                    {
                        { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 }
                    }
                },
                new int[][]
                {
                    { 11, 14, 17, 20 },
                    { 23, 30, 37, 44 },
                    { 35, 46, 57, 68 }
                }
            ),
            Arguments.of(
                new int[][][]
                {
                    {
                        {12}
                    },
                    {
                        {2}
                    }
                },
                new int[][]
                {
                    {24}
                }
            )
        );
    }

    @ParameterizedTest
    @MethodSource("matrixProduct")
    public void multiplyMatrixTest(int arr1[][][], int arr2[][]) {
        Matrix testCaseMatrix1 = new Matrix(arr1[0]);
        Matrix testCaseMatrix2 = new Matrix(arr1[1]);
        Matrix testCase = Matrix.multiplyMatrix(testCaseMatrix1, testCaseMatrix2);
        assertArrayEquals(arr2, testCase.getIntArrayMatrix());
    }

    @Test
    public void addMatrixTest() {
        int[][][] matrixList = {
            {
                { 1, 2 },
                { 0, 4 },
                { 5, 6 },
            },
            {
                { 0, 3 },
                { 0, -1 },
                { 3, 9 },
            }
        };

        int[][] matrixSum = {
            { 1, 5 },
            { 0, 3 },
            { 8, 15 },
        };

        Matrix testCaseMatrix1 = new Matrix(matrixList[0]);
        Matrix testCaseMatrix2 = new Matrix(matrixList[1]);
        Matrix testCase = Matrix.addMatrices(testCaseMatrix1, testCaseMatrix2);
        assertArrayEquals(matrixSum, testCase.getIntArrayMatrix());
    }

    @Test
    public void transposeMatrixTest() {
        int[][] matrixList = {
            { 1, 2 },
            { 0, 4 },
            { 5, 6 },
        };

        int[][] matrixTranspose = {
            { 1, 0, 5 },
            { 2, 4, 6 }
        };

        Matrix testCaseMatrix1 = new Matrix(matrixList);
        Matrix testCase = testCaseMatrix1.getTranspose();
        assertArrayEquals(matrixTranspose, testCase.getIntArrayMatrix());
    }

    @Test
    public void symmetricMatrixTest() {
        int[][] matrixList = {
            { 1, 2, 3 },
            { 2, 4, 5 },
            { 3, 5, 7 },
        };

        Matrix testCaseMatrix1 = new Matrix(matrixList);
        boolean testCase = testCaseMatrix1.isSymmetrical();
        assertEquals(true, testCase);
    }
}
