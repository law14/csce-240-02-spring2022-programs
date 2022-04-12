import java.io.*;

/**
 * The LogFileWriter class follows the singleton design pattern
 * and extends the abstract BufferedWriterBase class.
 * To use first "build()" then "log()" then "end()"
 * @author Luke
 */
public class LogFileWriter extends BufferedWriterBase {
    private static LogFileWriter logFileWriter = new LogFileWriter();

    /**
     * Private LogFileWriter constructor since this will follow
     * the singleton design pattern.
     */
    private LogFileWriter() {}


    /**
     * Use to get the single LogFileWriter instance
     * @return the single LogFileWriter instance
     */
    public static LogFileWriter getInstance() {
        if (logFileWriter == null) {
            logFileWriter = new LogFileWriter();
        }
        return logFileWriter;
    }



}
