import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class AssignmentTest {
    int[][] intMatrix = {
        { 5, 9, 4, 9, 4, 5 },
        { 5, 4, 9, 4, 9, 5 },
        { 1, 2, 3, 8, 9, 3, 2, 1 },
        { 7, 1, 4, 9, 7, 4, 1 },
        { 6, 5, 6, 4, 9, 7, 1, 4, 2, 7, 9, 2, 6, 5, 6 },
        { 1, 2, 1, 4 },
        { 1, 4, 5, 3, 5, 4, 1 },
        { 1, 2, 2, 3, 4, 4 },
        { 1, 1, 2, 1, 1, 4 },
        { 1, 4, 1, 5 },
        { 1, 4, 1, 5, 5, 4, 1 },
        { 1, 1, 1, 2, 1 },
        { 10, 10 }
    };

    private ArrayList<ArrayList<Integer>> intArrayIterator = new ArrayList<ArrayList<Integer>>();

    public AssignmentTest() {
        for (int i = 0; i < intMatrix.length; i++) {
            ArrayList<Integer> testCase = new ArrayList<Integer>();
            for (int j = 0; j < intMatrix[i].length; j++) {
                testCase.add(intMatrix[i][j]);
            }
            intArrayIterator.add(testCase);
        }
    }

    @Test
    public void runMaxMirror() {
        ArrayList<Integer> caseVerified = new ArrayList<Integer>();

        for (ArrayList<Integer> testCase : intArrayIterator) {
            ArrOperation arrOperation = new ArrOperation(testCase);
            int result = arrOperation.maxMirror();
            caseVerified.add(result);
        }

        assertEquals(new ArrayList<Integer>() {
            {
                add(3);
                add(3);
                add(3);
                add(2);
                add(3);
                add(3);
                add(7);
                add(0);
                add(5);
                add(3);
                add(3);
                add(3);
                add(0);
            }
        }, caseVerified);
    }

    @Test
    public void runClumpArray() {
        ArrayList<Integer> caseVerified = new ArrayList<Integer>();

        for (ArrayList<Integer> testCase : intArrayIterator) {
            ArrOperation arrOperation = new ArrOperation(testCase);
            int result = arrOperation.clumpArray();
            caseVerified.add(result);
        }

        assertEquals(new ArrayList<Integer>() {
            {
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(2);
                add(2);
                add(0);
                add(1);
                add(1);
                add(1);
            }
        }, caseVerified);
    }

    @Test
    public void runFixXY() {
        for (int i = 0; i < intMatrix.length; i++) {
            ArrayList<Integer> caseVerify = new ArrayList<Integer>();

            for (int j = 0; j < intMatrix[i].length; j++) {
                caseVerify.add(intMatrix[i][j]);
            }

            ArrOperation arrOperation = new ArrOperation(caseVerify);
            int result[] = arrOperation.fixXY(4, 5);
            assertArrayEquals(intMatrix[i], result);
        }
    }

    @Test
    public void runSplitArray() {
        ArrayList<Integer> caseVerified = new ArrayList<Integer>();

        for (ArrayList<Integer> testCase : intArrayIterator) {
            ArrOperation arrOperation = new ArrOperation(testCase);
            int result = arrOperation.splitArray();
            caseVerified.add(result);
        }

        assertEquals(new ArrayList<Integer>() {
            {
                add(3);
                add(3);
                add(-1);
                add(-1);
                add(-1);
                add(3);
                add(-1);
                add(4);
                add(4);
                add(-1);
                add(-1);
                add(3);
                add(1);
            }
        }, caseVerified);
    }

}
