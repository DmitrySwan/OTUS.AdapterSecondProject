import org.apache.log4j.Logger;

import java.util.Random;

public class MatrixWorker {

    private static Logger log = Logger.getLogger(MatrixWorker.class);

    public int[][] generateRandomMatrix(int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = new Random().nextInt(10 - 1);
            }
        }
        log.info("#Generated random matrix \n" + matrixToString(matrix));
        return matrix;
    }

    private String matrixToString(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                result.append(" ").append(anInt);
            }
            result.append("\n");
        }
        return result.toString();
    }
}
