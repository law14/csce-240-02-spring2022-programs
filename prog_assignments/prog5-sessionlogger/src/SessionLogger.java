import java.io.*;
import java.time.Instant;
import java.time.Duration;

public class SessionLogger {

    private static PrintStream console = System.out;
    private int sessionCount = 0;
    private Instant sessionStart;
    private Instant sessionEnd;
    private long durationOfSession;
    private ChatSession chatSession;




    private void LogOutput(String a) {

    }

    private void readIntoFile() {
        try {
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println(buffReader.readLine());
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
    







    // CLEAR DATA


    // Begenning Of Session Methods
    private void beginNewSession() {
        beginSessionTime();
        // new file?
    }
    private void beginSessionTime() {
        setSessionStart(Instant.now());
    }
    private void updateSessionCount() {
        setSessionCount(this.sessionCount++);
    }
    private void setSessionCount(int sessionCount) {
        if (sessionCount >-1) {
            this.sessionCount = sessionCount;         
        }
    }


    // End Of Session Methods
    private void endSession(){
        endSessionTime();
        setDurationOfSession();
        // write file end

    }
    private void endSessionTime() {
        setSessionEnd(Instant.now());
    }
    private void setDurationOfSession() {
        if (this.sessionStart != null && this.sessionEnd != null) {
            this.durationOfSession = Duration.between(this.sessionStart, this.sessionEnd).toMillis();
        }
    }


    // TIME MUTATION
    private void setSessionStart(Instant sessionStart) {
        if (sessionStart != null) {
            this.sessionStart = sessionStart;
        }
    }
    private void setSessionEnd(Instant sessionEnd) {
        if (sessionEnd != null) {
            this.sessionEnd = sessionEnd;
        }
    }

    public static void main(String arr[]) {

    }

   
}