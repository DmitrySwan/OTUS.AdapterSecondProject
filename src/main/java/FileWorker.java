import java.io.*;

class FileWorker {

    private File inputFile;

    FileWorker(File inputFile) throws FileNotFoundException {
        this.inputFile = inputFile;

    }

    public void printToFile(int[][] firstMatrix, int[][] secondMatrix) {
        printToFile("" + firstMatrix.length);
        printToFile(firstMatrix);
        printToFile(""); //визуальный разрыв между матрицами в файле
        printToFile(secondMatrix);
    }

    private void printToFile(String str) {
        try (FileWriter fw = new FileWriter(inputFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printToFile(int[][] matrix) {
        try (FileWriter fw = new FileWriter(inputFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (int[] aMatrix : matrix) {
                for (int anAMatrix : aMatrix) {
                    out.print(anAMatrix + " ");
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
