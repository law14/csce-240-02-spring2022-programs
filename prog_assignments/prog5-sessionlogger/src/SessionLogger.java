import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.Date;


/**
 * To use the session logger, first getInstance(), then
 * beginNewSession(), then logUserInput() and logSystemInput()
 * where necessary, then endSession(). This creates a new file
 * for each chat session, and 
 */
public class SessionLogger {
    private static SessionLogger sessionLogger = new SessionLogger();
    private static final String FILE_PATH = "data/chat_sessions/";
    private static final String PATTERN_FORMAT = "HH.mm.ss-uuuu.MM.dd";
    private static final String PROGRAM_NAME = "prog5-sessionlogger";
    private LogFileWriter logFileWriter;

    // Data for total of all sessions
    private int totalCount = 0;
    private long totalDuration = 0;

    // Instance necessary for each chat instance
    private File currentFile;
    private String fileDate;
    private long currentDuration;
    //private ChatSession chatSession;

    // Used to calculate the duration of each session
    private Instant startInstant;
    private Instant endInstant;

    /**
     * Private SessionLogger constructor
     */
    private SessionLogger() {}

    /**
     * Use to get the single SessionLogger instance
     * @return the single SessionLogger instance
     */
    public static SessionLogger getInstance() {
        if (sessionLogger == null) {
            sessionLogger = new SessionLogger();
        }
        return sessionLogger;
    }

    // Begenning Of Session Methods
    /**
     * Use to setup and start a new session
     */
    public void beginNewSession() {
        setStartInstant(Instant.now());
        setFileDate();
        String fileName = "chat".concat(String.valueOf(this.totalCount+1)+"_"+this.fileDate);
        //System.out.println(FILE_PATH+fileName);
        setCurrentFile(fileName);
        //System.out.println(getCurrentFile());
        buildLogFileWriter();
        
    }

    /**
     * Use to log user input via the LogFileWriter
     * @param s String to be logged
     */
    public void logUserInput(String s) {
        logFileWriter.log(s);
    }

    /**
     * Use to speak to the console whilist logging
     * system input via the LogFileWriter
     * @param s String to be logged
     */
    public void logSystemOutput(String s) {
        System.out.println(PROGRAM_NAME+": "+s);
        logFileWriter.log(PROGRAM_NAME+": "+s);
    }

    /**
     * Use endSession() to end a session
     */
    public void endSession(){
        // create update methods that use set methods to change data based on parameters
        logFileWriter.end();
        setEndInstant(Instant.now());
        setCurrentDuration();

        updateTotalCount();
        updateTotalDuration();

        // update CSV file method



        // write file end

    }

    
    /**
     * Increases the {@code totalCount} of sessions
     */
    private void updateTotalCount() {
        this.totalCount = totalCount++;
    }

    /**
     * Adjusts the {@code totalDuration}. Only call after setting current
     */
    private void updateTotalDuration() {
        this.totalDuration += this.currentDuration;
    }


    /**
     * Creates a new file {@code fileName} in the {@code FILE_PATH} with the
     * @param fileName desired name of the new file
     */
    private void setCurrentFile(String fileName) {
        if (fileName != null) {
            this.currentFile = new File(FILE_PATH+fileName);
        }
    }

    /**
     * Sets the fileDate using myFormattedDate()
     */
    private void setFileDate() {
        this.fileDate = myFormattedDate(this.startInstant);
    }

    /**
     * Sets the {@code currentFile}
     * @param f the desired {@code currentFile}
     */
    public void setFile(File f) {
        if (f != null) {
            this.currentFile = f;
        }
    }

    /**
     * Sets the {@code startTime}
     * @param startTime the desired {@code startTime}
     */
    private void setStartInstant(Instant startInstant) {
        if (startInstant != null) {
            this.startInstant = startInstant;
        }
    }

    /**
     * Sets the {@code endTime}
     * @param endTime the desired {@code endTime}
     */
    private void setEndInstant(Instant endInstant) {
        if (endInstant != null) {
            this.endInstant = endInstant;
        }
    }

    /**
     * Sets the {@code totalCount}
     * @param totalCount the desired {@code totalCount}
     */
    private void setTotalCount(int totalCount) {
        if (totalCount >-1) {
            this.totalCount = totalCount;         
        }
    }

    /**
     * 
     */
    private void setCurrentDuration() {
        if (this.startInstant != null && this.endInstant != null) {
            this.currentDuration = Duration.between(this.startInstant, this.endInstant).toMillis();
        }
    }


    /**
     * Get a string representation of the {@code currentFile}
     * @return a String representation of the {@code currentFile}
     */
    private String getCurrentFile() {
        return this.currentFile.toString();
    }

    /**
     * Gets the single {@code logFileWriter} instance and builds it 
     */
    private void buildLogFileWriter() {
        logFileWriter = LogFileWriter.getInstance();
        logFileWriter.build(this.currentFile);
    }

    /**
     * Creates a formatted String from an instant
     * @param instant to be formatted
     * @return a formatted String representation of the instant
     */
    private String myFormattedDate(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT).withZone(ZoneId.systemDefault());
        String formattedInstant = formatter.format(instant);
        //System.out.println(instant);
        //System.out.println(formattedInstant);
        return formattedInstant;
    }




    public static void main(String arr[]) {
        SessionLogger sesh = new SessionLogger();
        // sesh.readFromFile();
        
        sesh.beginNewSession();
        sesh.endSession();

        sesh.beginNewSession();
        sesh.endSession();

        sesh.beginNewSession();
        sesh.endSession();

        sesh.beginNewSession();
        sesh.endSession();
        
        //sesh.beginNewSession();

    }

   
}