public class MatrixMultiply {
    public static int[][] matrixMultiply(int[][] matrix_x, int[][] matrix_y) {
        int[][] matrix_a = matrix_x;
        int[][] matrix_b = matrix_y;
        if (!(MatrixColumnCount.matrixColumnCount(matrix_a) == MatrixRowCount.matrixRowCount(matrix_b))) {
            if (MatrixColumnCount.matrixColumnCount(matrix_b) == MatrixRowCount.matrixRowCount(matrix_a)) {
                matrix_a = matrix_y;
                matrix_b = matrix_x;
            } else {
                System.out.println("invalid multiplication");
                return matrix_x;
            }
        }
        int[][] matrix_p = new int[MatrixRowCount.matrixRowCount(matrix_a)][MatrixColumnCount
                .matrixColumnCount(matrix_b)];
        for (int i = 0; i < matrix_p.length; i++) {
            System.out.println("multiplying...");
            matrix_p[i] = multiplyTuples(matrix_a, matrix_b, i + 1);
        } // for each row in product matrix
        return matrix_p;
    }

    public static int[] multiplyTuples(int[][] matrix_a, int[][] matrix_b, int row) {
        int val = 0;
        int[] tuple = new int[MatrixColumnCount.matrixColumnCount(matrix_b)];
        for (int i = 0; i < matrix_b[0].length; i++) {
            for (int j = 0; j < matrix_a[row - 1].length; j++) {
                int temp = matrix_a[row - 1][j] * matrix_b[j][i];
                val += temp;
            }
            tuple[i] = val;
            val = 0;
        }
        return tuple;
    }
}
