public class Inverse {
    public static float[][] InvertMatrix4X4(float[][] matrix_i) {
        float det_A = Determinant4X4(matrix_i);
        if (det_A <= 0) {
            System.out.println("Invalid division: Determinant is less than or equal to zero");
            System.out.println("Determinant = " + det_A);
        }
        float x = 1.0f / det_A;
        System.out.println("Adjugate");
        Main.displayMatrix(GenerateAdjugate4X4(matrix_i));
        return ScalarMultiplication(GenerateAdjugate4X4(matrix_i), x);
    }

    public static float[][] GenerateAdjugate4X4(float[][] matrix_i) {
        float[][] Adjugate = new float[matrix_i.length][matrix_i[0].length];
        int alt = -1;
        for (int i = 0; i < matrix_i.length; i++) {
            alt *= -1;
            for (int j = 0; j < matrix_i[i].length; j++) {
                Adjugate[i][j] = alt * Determinant3X3(GenerateSubMatrix(matrix_i, j, i));
                alt *= -1;
            }
        }

        return Adjugate;
    }

    private static float[][] GenerateSubMatrix(float[][] matrix_i, int i, int j) {
        float[][] SubM = new float[matrix_i.length - 1][matrix_i[0].length - 1];
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

    private static float[][] GenerateCofactor(float[][] matrix_i, int k) {
        float[][] coFactor = new float[matrix_i.length - 1][matrix_i[0].length - 1];
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

    private static float[][] ScalarMultiplication(float[][] matrix_i, float scalar) {
        float[][] matrix_s = new float[matrix_i.length][matrix_i[0].length];
        for (int i = 0; i < matrix_i.length; i++) {
            for (int j = 0; j < matrix_i[i].length; j++) {
                matrix_s[i][j] = scalar * matrix_i[i][j];
            }
        }
        return matrix_s;
    }

    public static float Determinant4X4(float[][] matrix_i) {
        float[][][] CofactorContainer = new float[4][3][3];
        for (int i = 0; i < matrix_i.length; i++) {
            CofactorContainer[i] = GenerateCofactor(matrix_i, i);
        }
        int alt = 1;
        int det_A = 0;
        for (int i = 0; i < matrix_i.length; i++) {
            det_A += ((alt * matrix_i[i][0]) * Determinant3X3(CofactorContainer[i]));
            alt *= -1;
        }
        return det_A;
    }

    public static float Determinant3X3(float[][] matrix_i) {
        float a = matrix_i[0][0];
        float b = matrix_i[0][1];
        float c = matrix_i[0][2];
        float d = matrix_i[1][0];
        float e = matrix_i[1][1];
        float f = matrix_i[1][2];
        float g = matrix_i[2][0];
        float h = matrix_i[2][1];
        float i = matrix_i[2][2];
        return a * ((e * i) - (f * h)) + (-1 * b) * ((d * i) - (f * g)) + c * ((d * h) - (e * g));
    }

    public static float[][] InvertMatrix2X2(float[][] matrix_i) {
        float a = matrix_i[0][0];
        float b = matrix_i[0][1];
        float c = matrix_i[1][0];
        float d = matrix_i[1][1];
        float det = 1 / ((a * d) - (b * c));
        float[][] swap = new float[matrix_i.length][matrix_i[0].length];
        swap[0][0] = d;
        swap[0][1] = -1 * b;
        swap[1][0] = -1 * c;
        swap[1][1] = a;
        return ScalarMultiplication(swap, det);

    }

    public static float[][] InvertMatrix3X3(float[][] matrix_i) {
        float det_A = Determinant3X3(matrix_i);
        if (det_A >= 0) {
            System.out.println("Invalid division: Determinant is less than or equal to zero");
            System.out.println("Determinant = " + det_A);
        }
        float x = 1.0f / det_A;
        return ScalarMultiplication(GenerateAdjugate3X3(matrix_i), x);
    }

    public static float[][] GenerateAdjugate3X3(float[][] matrix_i) {
        float[][] Adjugate = new float[matrix_i.length][matrix_i[0].length];
        int alt = -1;
        for (int i = 0; i < matrix_i.length; i++) {
            alt *= -1;
            for (int j = 0; j < matrix_i[i].length; j++) {
                Adjugate[i][j] = alt * Determinant2X2(GenerateSubMatrix(matrix_i, j, i));
                alt *= -1;
            }
        }

        return Adjugate;
    }

    private static float Determinant2X2(float[][] matrix_i) {
        float a = matrix_i[0][0];
        float b = matrix_i[0][1];
        float c = matrix_i[1][0];
        float d = matrix_i[1][1];
        return (a * d) - (b * c);
    }

}