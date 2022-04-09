import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.Date;


/**
 * To use the session logger, first getInstance(), then
 * beginNewSession(), then logUserInput() and logSystemInput()
 * where necessary, then endSession().
 */
public class SessionLogger {
    private static SessionLogger sessionLogger = new SessionLogger();
    private static PrintStream console = System.out;
    private static final String FILE_PATH = "data/chat_sessions/";
    private static final String PATTERN_FORMAT = "HH.mm.ss-uuuu.MM.dd";
    private static final String PROGRAM_NAME = "prog5-sessionlogger";

    private int totalCount = 0;
    private long totalDuration;

    private ChatSession chatSession;
    private Instant startInstant;
    private Instant endInstant;
    private String fileDate;
    private long currentDuration;
    private File currentFile;
    private LogFileWriter logFileWriter;

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
        setStartTime(Instant.now());
        setFileDate();
        String fileName = "chat".concat(String.valueOf(this.totalCount)+"_"+this.fileDate);
        //System.out.println(FILE_PATH+fileName);
        setCurrentFile(fileName);
        //System.out.println(getCurrentFile());

        buildLogFileWriter();
        
    }

    private void buildLogFileWriter() {
        logFileWriter = LogFileWriter.getInstance();
        logFileWriter.build(this.currentFile);
    }



    /**
     * Use to log user input via the LogFileWriter
     * @param s String to be logged
     */
    public void logUserInput(String s) {
        logFileWriter.log(s);
    }

    /**
     * Use to log system input via the LogFileWriter
     * @param s String to be logged
     */
    public void logSystemOutput(String s) {
        System.out.println(PROGRAM_NAME+s);
        logFileWriter.log(PROGRAM_NAME+s);
    }


    /**
     * Use endSession() to end a session
     */
    private void endSession(){
        setEndTime(Instant.now());
        setCurrentDuration();
        updateTotalCount();

        // write file end

    }






    // TODO: Setters
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
    private void setStartTime(Instant startTime) {
        if (startTime != null) {
            this.startInstant = startTime;
        }
    }

    /**
     * Sets the {@code endTime}
     * @param endTime the desired {@code endTime}
     */
    private void setEndTime(Instant endTime) {
        if (endTime != null) {
            this.endInstant = endTime;
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
     * TODO:
     */
    private void setCurrentDuration() {
        if (this.startInstant != null && this.endInstant != null) {
            this.currentDuration = Duration.between(this.startInstant, this.endInstant).toMillis();
        }
    }



    // TODO: other methods

    /**
     * Increases the {@code totalCount} of sessions
     */
    private void updateTotalCount() {
        totalCount++;
    }

    /**
     * Get a string representation of the {@code currentFile}
     * @return a String representation of the {@code currentFile}
     */
    private String getCurrentFile() {
        return this.currentFile.toString();
    }

    /**
     * Update the totalDuration, only call after setting current
     */
    private void updateTotalDuration() {
        this.totalDuration += this.currentDuration;
    }

    /**
     * Creates a formatted String from an instant
     * @param instant
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