import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShowMain();
    }

    public static void ShowMain() {
        System.out.println("What would you like to do?");
        int choice;
        Scanner kb = new Scanner(System.in);
        System.out.println("[1] Add");
        System.out.println("[2] Subtract");
        System.out.println("[3] Multiply");
        System.out.println("[4] Divide");
        System.out.println("[5] Generate Identity Matrix From the inverse");
        System.out.println("[6] Invert a 2x2 Matrix");
        System.out.println("[7] Invert a 3x3 Matrix");
        System.out.println("[8] Invert a 4x4 Matrix");
        choice = kb.nextInt();
        switch (choice) {
            case 1:
                displayMatrix(MatrixArithmetic.matrixAdd(InputToArray(1), InputToArray(2)));
                break;
            case 2:
                displayMatrix(MatrixArithmetic.matrixSubtract(InputToArray(1), InputToArray(2)));
                break;
            case 3:
                displayMatrix(MatrixArithmetic.matrixMultiply(InputToArray(1), InputToArray(2)));
                break;
            case 4:
                float[][] input1 = InputToArray(1);
                float[][] input2 = InputToArray(2);
                switch (input1.length) {
                    case 2:
                        displayMatrix(MatrixArithmetic.matrixMultiply(input1, Inverse.InvertMatrix2X2(input2)));
                        break;
                    case 3:
                        displayMatrix(MatrixArithmetic.matrixMultiply(input1, Inverse.InvertMatrix3X3(input2)));
                        break;
                    case 4:
                        displayMatrix(MatrixArithmetic.matrixMultiply(input1, Inverse.InvertMatrix4X4(input2)));
                        break;
                    default:
                        System.out.println("Invalid size for division operation!");
                        ShowMain();
                        break;
                }
                break;
            case 5:
                float[][] in1 = InputToArray();
                int l = in1.length;
                if (in1[0].length < 2 || in1[0].length >= 5) {
                    l = 1;
                }
                switch (l) {
                    case 2:
                        System.out.println("Inverse of Given Matrix:");
                        float[][] inv2x2 = Inverse.InvertMatrix2X2(in1);
                        displayMatrix(inv2x2);
                        System.out.println("Identity Matrix");
                        displayMatrix(MatrixArithmetic.matrixMultiply(in1, inv2x2));
                        break;
                    case 3:
                        System.out.println("Inverse of Given Matrix:");
                        float[][] inv3x3 = Inverse.InvertMatrix3X3(in1);
                        displayMatrix(inv3x3);
                        System.out.println("Identity Matrix");
                        displayMatrix(MatrixArithmetic.matrixMultiply(in1, inv3x3));
                        break;
                    case 4:
                        System.out.println("Inverse of Given Matrix:");
                        float[][] inv4x4 = Inverse.InvertMatrix4X4(in1);
                        displayMatrix(inv4x4);
                        System.out.println("Identity Matrix");
                        displayMatrix(MatrixArithmetic.matrixMultiply(in1, inv4x4));
                        System.out.println("Proof");
                        displayMatrix(
                                MatrixArithmetic.matrixMultiply(in1, MatrixArithmetic.matrixMultiply(in1, inv4x4)));
                        break;
                    default:
                        System.out.println("Invalid size for division operation!");
                        ShowMain();
                        break;
                }
                break;
            case 6:
                float[][] in2 = InputToArray();
                System.out.println("Inverse of Given Matrix");
                displayMatrix(Inverse.InvertMatrix2X2(in2));
                break;
            case 7:
                float[][] in3 = InputToArray();
                System.out.println("Inverse of Given Matrix");
                displayMatrix(Inverse.InvertMatrix3X3(in3));
                break;
            case 8:
                float[][] in4 = InputToArray();
                System.out.println("Inverse of Given Matrix");
                displayMatrix(Inverse.InvertMatrix4X4(in4));
                break;
            default:
                System.out.println("Exiting....");
                break;
        }
    }

    public static float[][] InputToArray(int m) {
        Scanner kb = new Scanner(System.in);
        System.out.println();
        System.out.println("Matrix " + m + " height: ");
        int L = Integer.parseInt(kb.nextLine());
        System.out.println("Matrix " + m + " length: ");
        int H = Integer.parseInt(kb.nextLine());
        float[][] matrix = new float[H][L];
        for (int i = 0; i < matrix.length; i++) {
            String num = "";
            float[] tuple = new float[L];
            System.out.println("Enter row " + (i + 1) + ": ");
            char[] nums = kb.nextLine().toCharArray();
            int iterator = 0;
            for (char c : nums) {
                if (c != ' ') {
                    num += c;
                } else {
                    tuple[iterator] = Integer.parseInt(num);
                    iterator += 1;
                    num = "";
                }
            }
            tuple[iterator] = Integer.parseInt(num);

            matrix[i] = tuple;
        }
        System.out.println("Matrix " + m);
        displayMatrix(matrix);
        return matrix;
    }

    public static float[][] InputToArray() {
        Scanner kb = new Scanner(System.in);
        System.out.println();
        System.out.println("Matrix height: ");
        int L = Integer.parseInt(kb.nextLine());
        System.out.println("Matrix length: ");
        int H = Integer.parseInt(kb.nextLine());
        float[][] matrix = new float[H][L];
        for (int i = 0; i < matrix.length; i++) {
            String num = "";
            float[] tuple = new float[L];
            System.out.println("Enter row " + (i + 1) + ": ");
            char[] nums = kb.nextLine().toCharArray();
            int iterator = 0;
            for (char c : nums) {
                if (c != ' ') {
                    num += c;
                } else {
                    tuple[iterator] = Integer.parseInt(num);
                    iterator += 1;
                    num = "";
                }
            }
            tuple[iterator] = Integer.parseInt(num);

            matrix[i] = tuple;
        }
        System.out.println("Given Matrix");
        displayMatrix(matrix);
        return matrix;
    }

    public static void displayMatrix(float[][] matrix_p) { // method
        for (int i = 0; i < matrix_p.length; i++) {
            for (int j = 0; j < matrix_p[i].length; j++) {
                System.out.print("[" + matrix_p[i][j] + "] ");
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
