public class Adjugate {
    public static int[][] GenerateAdjugate(int[][] matrix_i) {
        int[][] Adjugate = new int[4][4];
        for (int i = 0; i < matrix_i.length; i++) {
            for (int j = 0; j < matrix_i[i].length; j++) {
                Adjugate[i][j] = Determinant3X3(GenerateSubMatrix(matrix_i, i, j));
            }
        }
        return Adjugate;
    }

    private static int[][] GenerateSubMatrix(int[][] matrix_i, int i, int j) {
        int[][] SubM = new int[3][3];
        int sub_i = 0, sub_j = 0;
        for (int k = 0; k < matrix_i.length; k++) {
            sub_j = 0;
            Boolean filled = false;
            for (int k2 = 0; k2 < matrix_i.length; k2++) {
                if (k == i || k2 == j) {
                    continue;
                } else {
                    SubM[sub_i][sub_j] = matrix_i[k][k2];
                    sub_j += 1;
                    filled = true;
                }
            }
            if (filled) {
                sub_i += 1;
            }

        }
        return SubM;
    }

    private static int[][] GenerateCofactor(int[][] matrix_i, int k) {
        int[][] coFactor = new int[3][3];
        int sub_i = 0, sub_j = 0;
        for (int i = 0; i < matrix_i.length; i++) {
            sub_j = 0;
            Boolean filled = false;
            for (int j = 0; j < matrix_i[i].length; j++) {
                if (i == 0 || j == k) {
                    continue;
                } else {
                    coFactor[sub_i][sub_j] = matrix_i[i][j];
                    sub_j += 1;
                    filled = true;
                }
            }
            if (filled) {
                sub_i += 1;
            }
        }
        return coFactor;
    }

    private static int Determinant4X4(int[][] matrix_i) {
        int[][][] CofactorContainer = new int[4][3][3];
        for (int i = 0; i < matrix_i.length; i++) {
            CofactorContainer[i] = GenerateCofactor(matrix_i, i);
        }
        return 1;
    }

    private static int Determinant3X3(int[][] matrix_i) {
        int a = matrix_i[0][0];
        int b = matrix_i[0][1];
        int c = matrix_i[0][2];
        int d = matrix_i[1][0];
        int e = matrix_i[1][1];
        int f = matrix_i[1][2];
        int g = matrix_i[2][0];
        int h = matrix_i[2][1];
        int i = matrix_i[2][2];
        return a * ((e * i) - (f * h)) - b * ((d * i) - (f * g)) + c * ((d * h) - (e * g));
    }

}