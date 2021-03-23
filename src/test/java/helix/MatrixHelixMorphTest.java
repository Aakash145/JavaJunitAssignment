package helix;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {

    /** Check if two integer matrices have the same contents
     *
     * @param matrix1
     * @param matrix2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     */
    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {

        /*
            Basic sanity checking:
                Verify that lengths are equal
         */
        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    //All the JUnit Tests
    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test0x0() {
        int[][] inMatrix  = { {} };
        int[][] expOutput = { {} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void testNull() {
        int[][] inMatrix  = { };
        int[][] expOutput = { };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test3x3() {
        int[][] inMatrix  = { {1,2,3},{4,5,6},{7,8,9} };
        int[][] expOutput = { {1,2,3},{8,9,4},{7,6,5} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test4x5() {
        int[][] inMatrix  = { {7,5,1,4,6},{3,2,9,1,8},{8,3,2,4,1},{10,11,15,19,14} };
        int[][] expOutput = { {7,5,1,4,6},{4,1,10,11,3},{2,14,19,15,2},{3,8,8,1,9} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x2() {
        int[][] inMatrix  = { {7,5} };
        int[][] expOutput = { {7,5} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test2x1() {
        int[][] inMatrix  = { {7},{4} };
        int[][] expOutput = { {7},{4} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void testRowMatrix() {
        int[][] inMatrix  = { {2,3,1} };
        int[][] expOutput = { {2,3,1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }
    @Test
    public void testColumnMatrix() {
        int[][] inMatrix  = { {2},{3},{1} };
        int[][] expOutput = { {2},{3},{1}  };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }
    @Test
    public void testZeroMatrix() {
        int[][] inMatrix  = { {0,0}, {0,0} };
        int[][] expOutput = { {0,0}, {0,0} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test5x5() {
        int[][] inMatrix  = { {1,2,3,4,5}, {5,2,5,73,43}, {4,21,53,3,3}, {5,12,25,3,4}, {6,12,9,7,100} };
        int[][] expOutput = { {1,2,3,4,5}, {5 ,12, 25, 3, 5 },{3 ,7 ,100, 4, 2 }, {3 ,9 ,12, 6, 5}, {53 ,21 ,4 ,43, 73 }};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

}
