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
        choice = kb.nextInt();
        switch (choice) {
            case 1:
                displayMatrix(MatrixArithmetic.matrixAdd(AdditionPrompt(1), AdditionPrompt(2)));
                break;

            default:
                break;
        }
    }

    public static float[][] AdditionPrompt(int m) {
        Scanner kb = new Scanner(System.in);
        System.out.println();
        System.out.println("Input Height: ");
        int L = Integer.parseInt(kb.nextLine());
        System.out.println();
        System.out.println("Input Length: ");
        int H = Integer.parseInt(kb.nextLine());
        float[][] matrix = new float[H][L];
        for (int i = 0; i < matrix.length; i++) {
            String num = "";
            float[] tuple = new float[L];
            System.out.println("Enter row " + (i + 1) + ": ");
            char[] nums = kb.nextLine().toCharArray();
            System.out.println();
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
