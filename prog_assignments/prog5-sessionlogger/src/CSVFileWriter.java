import java.io.*;

/**
 * The CSVFileAdjuster class follows the singleton design pattern.
 * To use first "build()" then "writeToFile()" then "end()"
 * @author Luke
 */
public class CSVFileWriter extends BufferedWriterBase {
    private static CSVFileWriter fileAdjuster = new CSVFileWriter();
    BufferedWriter writer;
    // private File outputFile;
    // private boolean built = false;

    private CSVFileWriter() {}

    public static CSVFileWriter getInstance() {
        if (fileAdjuster != null) {
            fileAdjuster = new CSVFileWriter();
        }
        return fileAdjuster;
    }
    

}