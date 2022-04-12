import java.io.File;

public class ChatSession {
    private int sessionNumber;
    private File chatFile;
    private int userUtteranceCount;
    private int systemUtteranceCount;
    private long durationOfSession;


    public ChatSession(int sessionNumber, File chatFile, int userUtteranceCount, int systemUtteranceCount, long durationOfSession) {
        setSessionNumber(sessionNumber);
        setChatFile(chatFile);
        setuserUtteranceCount(userUtteranceCount);
        setSystemUtteranceCount(systemUtteranceCount);
        setdurationOfSession(durationOfSession);
    }


    public int getSessionNumber() {
        return this.sessionNumber;
    }
    public File getChatFile() {
        return this.chatFile;
    }
    public int getCoutUserUtterance() {
        return this.userUtteranceCount;
    }
    public int getsystemUtteranceCount() {
        return this.systemUtteranceCount;
    }
    public long getdurationOfSession() {
        return this.durationOfSession;
    }


    public void setSessionNumber(int sessionNumber) {
        if (sessionNumber >- 1) {
            this.sessionNumber = sessionNumber;
        } 
    }
    public void setChatFile(File chatFile) {
        if (chatFile != null) {
            this.chatFile = chatFile;
        }
    }
    public void setuserUtteranceCount(int userUtteranceCount) {
        if (userUtteranceCount > -1 ) {
            this.userUtteranceCount = userUtteranceCount;
        }
    }
    public void setSystemUtteranceCount(int systemUtteranceCount) {
        if (systemUtteranceCount > -1) {
            this.systemUtteranceCount = systemUtteranceCount;
        }
    }
    public void setdurationOfSession(long durationOfSession) {
        if (this.durationOfSession > -1) {
            this.durationOfSession = durationOfSession;
        }
    }




}
