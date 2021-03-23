package ilia.nemankov;

import java.io.*;

public class CsvLogger {
    private String filePath = "src/test/resources/results/";

    private double step;
    private double lowerBorder;
    private double upperBorder;
    private final char CSV_SEPARATOR = ',';

    public CsvLogger(String fileName, double lowerBorder, double upperBorder, double step) {
        this.filePath = filePath + fileName;
        this.lowerBorder = lowerBorder;
        this.upperBorder = upperBorder;
        this.step = step;
    }

    public void setFilePath(String fileName) {
        this.filePath = "src/test/resources/results/" + fileName;
    }

    public void log(Function function) {
        String csvString = "";

        try(PrintStream printStream = new PrintStream(new FileOutputStream(filePath, true))) {
            for (double i = lowerBorder; i < upperBorder; i += step) {
                double result = function.calculate(i);
                csvString = String.format("%f%s %f\n", i, CSV_SEPARATOR, result);
                printStream.print(csvString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
