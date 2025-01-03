import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class Matrix {
    private final int rowLength;
    private final int colLength;
    private final HashMap<String, Integer> matrixMap = new HashMap<String, Integer>();

    public Matrix(int arr[][]) {
        rowLength = arr.length;
        colLength = arr[0].length;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int valueAtIndex = arr[i][j];
                if (valueAtIndex == 0)
                    continue;

                String indexId = i + " " + j;
                matrixMap.put(indexId, valueAtIndex);
            }
        }
    }

    /**
     * Adds two matrices if their dimentions are same
     * 
     * @param matrix1 first matrix of Matrix Class Type
     * @param matrix2 second matrix of Matrix Class Type
     * @return Matrix object containing sum of matrices
     */
    public static Matrix addMatrices(Matrix matrix1, Matrix matrix2) {
        try {
            int matrix1RowLength = matrix1.getRowLength();
            int matrix1ColLength = matrix1.getColLength();
            int matrix2RowLength = matrix2.getRowLength();
            int matrix2ColLength = matrix2.getColLength();

            if (matrix1RowLength != matrix2RowLength || matrix1ColLength != matrix2ColLength) {
                System.out.println("The Matrices are not equal.");
                return null;
            }

            int resultArr[][] = new int[matrix1RowLength][matrix1ColLength];

            for (int i = 0; i < matrix1RowLength; i++) {
                for (int j = 0; j < matrix1ColLength; j++) {
                    resultArr[i][j] = matrix1.getMatrix().getOrDefault(i + " " + j, 0) +
                            matrix2.getMatrix().getOrDefault(i + " " + j, 0);
                }
            }

            return new Matrix(resultArr);
        } catch (NullPointerException e) {
            System.out.println("Invalid Matrices - Null Matrice Passed as Argument");
            return null;
        }
    }

    /**
     * Gives product of two matrices
     * 
     * @param matrix1 first matrix of Matrix Class Type
     * @param matrix2 second matrix of Matrix Class Type
     * @return Matrix object containing product of matrices
     */
    public static Matrix multiplyMatrix(Matrix matrix1, Matrix matrix2) {
        try {
            int matrix1RowLength = matrix1.getRowLength();
            int matrix1ColLength = matrix1.getColLength();
            int matrix2RowLength = matrix2.getRowLength();
            int matrix2ColLength = matrix2.getColLength();

            if (matrix1ColLength != matrix2RowLength) {
                System.out.println("Invalid Multiplication Operation : Dimentions do not match the criteria.");
                return null;
            }

            int resultArr[][] = new int[matrix1RowLength][matrix2ColLength];

            int currentRowIndex = 0;
            int currentColIndex = 0;

            for (int i = 0; i < matrix1RowLength * matrix2ColLength; i++) {

                // Adding all terms for 1 iteration
                int sum = 0;
                for (int j = 0; j < matrix1ColLength; j++) {
                    int matrix1Value = matrix1.getMatrix().getOrDefault(currentRowIndex + " " + j, 0);
                    int matrix2Value = matrix2.getMatrix().getOrDefault(j + " " + currentColIndex, 0);

                    sum += (matrix1Value * matrix2Value);
                }
                resultArr[currentRowIndex][currentColIndex] = sum;

                // Breaking when we read column count and incrementing row for matrix1 and resettting col for matrix 2
                if ((i + 1) % matrix2ColLength == 0) {
                    currentRowIndex++;
                    currentColIndex = -1;
                }
                currentColIndex++;
            }

            return new Matrix(resultArr);
        } catch (NullPointerException e) {
            System.out.println("Invalid Matrices - Null Matrice Passed as Argument");
            return null;
        }
    }

    /**
     * Gives the transpose of matrix (ie Dimentions reversed)
     * 
     * @return Matrix object with dimentions reversed
     */
    public Matrix getTranspose() {
        try {
            // Creating a array of reversed dimentions
            int result[][] = new int[this.colLength][this.rowLength];

            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    int value = matrixMap.getOrDefault(i + " " + j, 0);
                    result[j][i] = value;
                }
            }

            return new Matrix(result);
        } catch (NullPointerException e) {
            System.out.println("Invalid Array Operation - Transpose on null matrix");
            return null;
        }
    }

    /**
     * Checks if matrix is symmetrical along the diagonal
     * 
     * @return boolean true if symmetrical
     */
    public boolean isSymmetrical() {
        try {
            boolean isSymmetricalMatrix = true;

            // Checking if [i, j] == [j, i]
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    int value = matrixMap.getOrDefault(i + " " + j, 0);
                    int mirrorValue = matrixMap.getOrDefault(j + " " + i, 0);
                    if (value != mirrorValue)
                        isSymmetricalMatrix = false;
                }
            }

            return isSymmetricalMatrix;
        } catch (NullPointerException e) {
            System.out.println("Invalid Array Operation - Transpose on null matrix");
            return false;
        }
    }

    /**
     * Prints the matrix
     */
    public void printMatrix() {
        try {
            System.out.println("\nDimentions : " + rowLength + " x " + colLength);
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    int value = matrixMap.getOrDefault(i + " " + j, 0);
                    System.out.print(value + "\t");
                }
                System.out.println();
            }
        } catch (NullPointerException e) {
            System.out.println("Invalid Array Operation");
        }
    }

    public int getRowLength() {
        return this.rowLength;
    }

    public int getColLength() {
        return this.colLength;
    }

    public HashMap<String, Integer> getMatrix() {
        HashMap<String, Integer> matrixCopy = new HashMap<String, Integer>();
        matrixCopy.putAll(matrixMap);
        return matrixCopy;
    }

    public int[][] getIntArrayMatrix() {
        try {
            int arr[][] = new int[rowLength][colLength];
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    int value = matrixMap.getOrDefault(i + " " + j, 0);
                    arr[i][j] = value;
                }
            }
            return arr;
        } catch (NullPointerException e) {
            System.out.println("Invalid Array Operation");
            return new int[0][0];
        }
    }
}

class Assignment {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int array1[][];
            int array2[][];

            // Takings inputs for 1st Matrix
            int arr1RowLength = 0;
            int arr1ColLength = 0;

            System.out.print("Enter number of rows in matrix : ");
            arr1RowLength = scanner.nextInt();
            System.out.print("Enter number of cols in matrix : ");
            arr1ColLength = scanner.nextInt();
            array1 = new int[arr1RowLength][arr1ColLength];

            for (int i = 0; i < arr1RowLength; i++) {
                for (int j = 0; j < arr1ColLength; j++) {
                    System.out.print(
                            "Enter value for (" +
                                    (i + 1) + "," + (j + 1) +
                                    ") : ");
                    int input = scanner.nextInt();
                    array1[i][j] = input;
                }
            }

            // Taking inputs for 2nd Matrix
            int arr2RowLength = 0;
            int arr2ColLength = 0;

            System.out.print("\nEnter number of rows in matrix : ");
            arr2RowLength = scanner.nextInt();
            System.out.print("Enter number of cols in matrix : ");
            arr2ColLength = scanner.nextInt();
            array2 = new int[arr2RowLength][arr2ColLength];

            for (int i = 0; i < arr2RowLength; i++) {
                for (int j = 0; j < arr2ColLength; j++) {
                    System.out.print(
                            "Enter value for (" +
                                    (i + 1) + "," + (j + 1) +
                                    ") : ");
                    int input = scanner.nextInt();
                    array2[i][j] = input;
                }
            }

            scanner.close();

            // Matrix Operations
            Matrix matrix1 = new Matrix(array1);
            Matrix matrix2 = new Matrix(array2);

            Matrix transMatrix = matrix1.getTranspose();
            transMatrix.printMatrix();

            boolean isMatrix1Symmetric = matrix1.isSymmetrical();
            System.out.println("Matrix 1 is symmetrical : " + isMatrix1Symmetric);

            // Matrix sumMatrix = Matrix.addMatrices(matrix1, matrix2);
            // sumMatrix.printMatrix();

            Matrix productMatrix = Matrix.multiplyMatrix(matrix1, matrix2);
            productMatrix.printMatrix();

        } catch (InputMismatchException e) {
            System.out.println("Invalid Inputs - Mismatch");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds...");
        } catch (NullPointerException e) {
            System.out.println("Cannot access property on null object : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unknown error : " + e.getMessage());
        }
    }
}