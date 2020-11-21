public class MatrixFlip {
    public static int[][] GenerateInverse(int[][] matrix_i) {
        int y = matrix_i.length;
        int x = matrix_i[0].length;
        int[][] matrix_r = new int[x][y];
        return matrix_r;
    }

    public static int[][] VerticalTraverse(int[][] matrix_horizontal) {
        int[][] matrix_vertical = GenerateInverse(matrix_horizontal);
        for (int i = 0; i < matrix_horizontal.length; i++) {
            for (int j = 0; j < matrix_horizontal[0].length; j++) {
                matrix_vertical[j][i] = matrix_horizontal[i][j];
            }
        }
        return matrix_vertical;
    }

    public static int[][] HorizontalTraverse(int[][] matrix_vertical, int[][] matrix_horizontal) {
        for (int i = 0; i < matrix_horizontal.length; i++) {
            for (int j = 0; j < matrix_horizontal[0].length; j++) {
                matrix_horizontal[j][i] = matrix_vertical[i][j];
            }
        }
        return matrix_horizontal;
    }
}
