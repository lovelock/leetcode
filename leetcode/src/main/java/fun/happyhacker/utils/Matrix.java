package fun.happyhacker.utils;

public class Matrix {
    public static void print(int[][] matrix) {
        StringBuilder sb = new StringBuilder();

        sb.append("[\n");
        for (int[] ints : matrix) {
            sb.append("\t[");
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(ints[j]).append(",");
            }
            sb.append("],\n");
        }
        sb.append("]");

        System.out.println(sb.toString());
    }
}
