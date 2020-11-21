public class MatrixSubtract {
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
