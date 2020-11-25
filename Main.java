public class Main {
    public static void main(String[] args) {
        int[][] matrix_a = { { 1, 3, 1, 4 }, { 3, 9, 5, 15 }, { 0, 2, 1, 1 }, { 0, 4, 2, 3 } };
        displayMatrix(Adjugate.GenerateAdjugate(matrix_a));
    }

    public static void displayMatrix(int[][] matrix_p) { // method
        for (int i = 0; i < matrix_p.length; i++) {
            for (int j = 0; j < matrix_p[i].length; j++) {
                System.out.print("[" + matrix_p[i][j] + "], ");
            }
            System.out.println();
        }
    }

    public static Boolean SquareMatrix(int[][] matrix_i) { // function
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
