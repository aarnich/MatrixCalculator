
public class Main {
    public static void main(String[] args) {
        int[][] matrix_a = { { 6, 1, 3 }, { 4, -9, 3 }, { 4, -9, 3 } };
        int[][] matrix_b = { { 1, 4 }, { 2, 8 }, { 1, 6 } };
        int[][] matrix_c = { { 1 }, { 2, 3, 4 }, { 5, 6 } };
        displayMatrix(MatrixInverse.GenerateIdentityMatrix(matrix_a));
    }

    public static void displayMatrix(int[][] matrix_p) {
        for (int i = 0; i < matrix_p.length; i++) {
            for (int j = 0; j < matrix_p[i].length; j++) {
                System.out.print("[" + matrix_p[i][j] + "], ");
            }
            System.out.println();
        }
    }

    public static Boolean SquareMatrix(int[][] matrix_i) {
        int rowSize = 0;
        for (int i = 1; i < matrix_i.length; i++) {
            rowSize = matrix_i[i].length;
            if (rowSize != matrix_i.length) {
                System.out.println("not a square matrix");
                return false;
            }
        }
        System.out.println("square matrix");
        return true;
    }
}
