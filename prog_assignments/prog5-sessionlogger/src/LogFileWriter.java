import java.io.*;

/**
 * The LogFileWriter class follows the singleton design pattern.
 * To use first "build" then "log" then "end"
 * @author Luke
 */
public class LogFileWriter {
    private static LogFileWriter logFileWriter = new LogFileWriter();
    private BufferedWriter writer;
    private File outputFile;
    private boolean built = false;

    /**
     * Private LogFileWriter constructor
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


    /**
     * builds the LogFileWriter with a {@code fileName}
     * @param fileName name of the file to be written to
     */
    public void build(String fileName) {
        if (!isBuilt()) {
            setOutputFile(fileName);
            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
                this.built = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("already built");
        }
    }

    /**
     * builds the LogFileWriter with a {@code file}
     * @param file the file to be written to
     */
    public void build(File file) {
        if (!isBuilt()) {
            setOutputFile(file);
            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
                this.built = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("already built");
        }
    }

    /**
     * Adds to the outputStream so long as "build()" method was
     * previously called successfully.
     */
    public void log(String log) {
        if (isBuilt()) {
            try {
                writer.write(log+"\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please use the \"build()\" method before attempting to log");
        }
    }

    /**
     * Ends the log, closing the BufferedWriter
     */
    public void end() {
        try {
            writer.close();
            this.built = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Sets the output file
     * @param fileName the desired output file's name
     */
    public void setOutputFile(String fileName) {
        if (fileName != null) {
            this.outputFile = new File(fileName);
        }
    }
    public void setOutputFile(File file) {
        if (file != null) {
            this.outputFile = file;
        }
    }

    /**
     * Gets the output file
     * @return the output file
     */
    private File getOutputFile() {
        return this.outputFile;
    }

    /**
     * @return built variable
     */
    public boolean isBuilt() {
        return this.built;
    }



}
