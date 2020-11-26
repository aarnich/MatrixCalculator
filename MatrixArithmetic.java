public class MatrixArithmetic {
    public static int matrixRowCount(float[][] matrix_i) {
        return matrix_i.length;

    }

    public static int matrixColumnCount(float[][] matrix_i) {
        return matrix_i[0].length;

    }

    public static float[][] matrixAdd(float[][] matrix_x, float[][] matrix_y) {
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
        float[][] matrix_sum = new float[matrix_x_xaxis][matrix_x_yaxis];
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

    public static float[][] matrixMultiply(float[][] matrix_x, float[][] matrix_y) {
        float[][] matrix_a = matrix_x;
        float[][] matrix_b = matrix_y;
        if (!(MatrixColumnCount.matrixColumnCount(matrix_a) == MatrixRowCount.matrixRowCount(matrix_b))) {
            if (MatrixColumnCount.matrixColumnCount(matrix_b) == MatrixRowCount.matrixRowCount(matrix_a)) {
                matrix_a = matrix_y;
                matrix_b = matrix_x;
            } else {
                System.out.println("invalid multiplication");
                return matrix_x;
            }
        }
        float[][] matrix_p = new float[MatrixRowCount.matrixRowCount(matrix_a)][MatrixColumnCount
                .matrixColumnCount(matrix_b)];
        for (int i = 0; i < matrix_p.length; i++) {
            System.out.println("multiplying...");
            matrix_p[i] = multiplyTuples(matrix_a, matrix_b, i + 1);
        } // for each row in product matrix
        return matrix_p;
    }

    public static float[] multiplyTuples(float[][] matrix_a, float[][] matrix_b, int row) {
        float val = 0;
        float[] tuple = new float[MatrixColumnCount.matrixColumnCount(matrix_b)];
        for (int i = 0; i < matrix_b[0].length; i++) {
            for (int j = 0; j < matrix_a[row - 1].length; j++) {
                float temp = matrix_a[row - 1][j] * matrix_b[j][i];
                val += temp;
            }
            tuple[i] = val;
            val = 0;
        }
        return tuple;
    }

    public static float[][] matrixSubtract(float[][] matrix_x, float[][] matrix_y) {
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
        float[][] matrix_sum = new float[matrix_x_xaxis][matrix_x_yaxis];
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
    public static Boolean MatrixSymmetryChecker(float[][] matrix_i) {
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
