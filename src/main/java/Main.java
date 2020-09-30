import org.apache.commons.cli.CommandLine;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {

    private static Logger log = Logger.getLogger(Main.class);


    public static void main(String[] args) throws IOException {
        CommandLine cl = AdapterCommandLineParser.parseCMDArgs(args); //Используем адаптер для чтения парамертов
        File inputFile = new File(cl.getOptionValue(AdapterCommandLineParser.INPUT)).getAbsoluteFile();
        File outputFile = new File(cl.getOptionValue(AdapterCommandLineParser.OUTPUT)).getAbsoluteFile();
        log.info("#inputFile " + inputFile);
        log.info("#outputFile " + outputFile);
        FileWorker fileWorker = new FileWorker(inputFile);
        MatrixWorker matrixWorker = new MatrixWorker();
        int dimension = new Random().nextInt(5) + 3;
        fileWorker.printToFile(
                matrixWorker.generateRandomMatrix(dimension),
                matrixWorker.generateRandomMatrix(dimension)
        );
        new Adapter().sumMatrices(inputFile, outputFile); //Используем адаптер для суммирования матриц
    }
}