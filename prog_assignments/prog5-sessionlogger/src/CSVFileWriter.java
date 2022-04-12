import java.io.*;

/**
 * The CSVFileAdjuster class follows the singleton design pattern
 *  * and extends the abstract BufferedWriterBase class.
 * To use first "build()" then "writeToFile()" then "end()"
 * @author Luke
 */
public class CSVFileWriter extends BufferedWriterBase {
    private static CSVFileWriter fileAdjuster = new CSVFileWriter();
    BufferedWriter writer;

    /**
     * Private CSVFileWriter constructor since this will follow
     * the singleton design pattern.
     */
    private CSVFileWriter() {}

    /**
     * Use to get the single CSVFileWriter instance
     * @return the single CSVFileWriter instance
     */
    public static CSVFileWriter getInstance() {
        if (fileAdjuster != null) {
            fileAdjuster = new CSVFileWriter();
        }
        return fileAdjuster;
    }
    
    public void 


}