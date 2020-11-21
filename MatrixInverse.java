public class MatrixInverse {
    public static int[][] InvertMatrix(int[][] matrix_i) {
        return matrix_i;
    }

    public static int[][] GenerateIdentityMatrix(int[][] matrix_i) {
        int[][] identity = new int[matrix_i.length][matrix_i[0].length];
        int index_i = 0;
        for (int[] tuple : identity) {
            tuple[index_i] = 1;
            index_i += 1;
        }
        return identity;
    }
}
