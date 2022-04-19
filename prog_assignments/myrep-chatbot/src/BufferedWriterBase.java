import java.io.*;

/**
 * The BufferedWriterBase is an abstract class to enable the ability
 * to write to a file with ease.
 * To use first "build()" then "writeToFile()" then "end()"
 * @author Luke
 */
public abstract class BufferedWriterBase {
    PrintWriter writer;
    private File outputFile;
    private boolean built = false;

    
    /**
     * builds the {@code BufferedWriter} with a {@code fileName}
     * @param fileName name of the file to be written to
     */
    public void build(String fileName, boolean append) {
        if (!isBuilt()) {
            setOutputFile(fileName);
            try {
                writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile,append))));
                this.built = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // System.out.println("BufferedWriter already built");
        }
    }

    /**
     * builds the {@code BufferedWriter} with a {@code file}
     * @param file the file to be written to
     */
    public void build(File file, boolean append) {
        if (!isBuilt()) {
            setOutputFile(file);
            try {
                writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile,append))));
                this.built = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //System.out.println("BufferedWriter already built");
        }
    }

    /**
     * Adds a line to the outputStream so long as "build()" 
     * method was previously called successfully.
     */
    public void write(String line) {
        if (isBuilt()) {
            try {
                writer.print(line);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please use the \"build()\" method before attempting to write");
        }
    }

    /**
     * Sets the output file for the {@code BufferedWriter} with a fileName
     * @param fileName the desired output file's name
     */
    public void setOutputFile(String fileName) {
        if (fileName != null) {
            this.outputFile = new File(fileName);
        }
    }

    /**
     * Sets the output file for the {@code BufferedWriter} with a file
     * @param file
     */
    public void setOutputFile(File file) {
        if (file != null) {
            this.outputFile = file;
        }
    }
    
    /**
     * Ends the writing, closing the {@code BufferedWriter}
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
     * Returns if the {@code BufferedWriter} has been built
     * @return built variable
     */
    public boolean isBuilt() {
        return this.built;
    }

    /**
     * Gets the output file
     * @return the output file
     */
    private File getOutputFile() {
        return this.outputFile;
    }


}
