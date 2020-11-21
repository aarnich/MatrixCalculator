public class MatrixArithmetic {
    public static int matrixRowCount(int[][] matrix_i) {
        return matrix_i.length;

    }

    public static int matrixColumnCount(int[][] matrix_i) {
        return matrix_i[0].length;

    }

    public static int[][] matrixAdd(int[][] matrix_x, int[][] matrix_y) {
        if (!(MatrixSymmetryChecker(matrix_x) && MatrixSymmetryChecker(matrix_y))) {
            System.out.println("Invalid Matrices");
            return matrix_x;
        } else {
            System.out.println("Valid Matrices");
        }
        int matrix_x_yaxis = matrix_x[0].length;
        int matrix_x_xaxis = matrix_x.length;
        int matrix_y_yaxis = matrix_y[0].length;
        int matrix_y_xaxis = matrix_y.length;
        if (!((matrix_x_yaxis == matrix_y_yaxis) && (matrix_x_xaxis == matrix_y_xaxis))) {
            System.out.println("Incompatible Matrices");
            return matrix_x;
        }
        int[][] matrix_sum = new int[matrix_x_xaxis][matrix_x_yaxis];
        if ((matrix_x_xaxis == matrix_y_xaxis) && (matrix_x_yaxis == matrix_y_yaxis)) {
            if (matrix_y_yaxis == matrix_x_yaxis) {

                for (int i = 0; i < matrix_sum.length; i++) {

                    for (int j = 0; j < matrix_sum[i].length; j++) {
                        matrix_sum[i][j] = matrix_x[i][j] + matrix_y[i][j];
                    }
                }
            }
        }
        System.out.println("x axis: " + matrix_sum.length);
        System.out.println("y axis: " + matrix_sum[0].length);
        return matrix_sum;

    }

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

    public static int[][] matrixSubtract(int[][] matrix_x, int[][] matrix_y) {
        if (!(MatrixSymmetryChecker(matrix_x) && MatrixSymmetryChecker(matrix_y))) {
            System.out.println("Invalid Matrices");
            return matrix_x;
        } else {
            System.out.println("Valid Matrices");
        }
        int matrix_x_yaxis = matrix_x[0].length;
        int matrix_x_xaxis = matrix_x.length;
        int matrix_y_yaxis = matrix_y[0].length;
        int matrix_y_xaxis = matrix_y.length;
        if (!((matrix_x_yaxis == matrix_y_yaxis) && (matrix_x_xaxis == matrix_y_xaxis))) {
            System.out.println("Incompatible Matrices");
            return matrix_x;
        }
        int[][] matrix_sum = new int[matrix_x_xaxis][matrix_x_yaxis];
        if ((matrix_x_xaxis == matrix_y_xaxis) && (matrix_x_yaxis == matrix_y_yaxis)) {
            if (matrix_y_yaxis == matrix_x_yaxis) {
                for (int i = 0; i < matrix_sum.length; i++) {

                    for (int j = 0; j < matrix_sum[i].length; j++) {
                        matrix_sum[i][j] = matrix_x[i][j] - matrix_y[i][j];
                    }
                }
            }
        }
        System.out.println("x axis: " + matrix_sum.length);
        System.out.println("y axis: " + matrix_sum[0].length);
        return matrix_sum;

    }

    public static Boolean MatrixSymmetryChecker(int[][] matrix_i) {
        int rowSize = 0;
        for (int i = 1; i < matrix_i.length; i++) {
            rowSize = matrix_i[i].length;
            if (rowSize != matrix_i[0].length) {
                return false;
            }
        }
        return true;
    }
}
