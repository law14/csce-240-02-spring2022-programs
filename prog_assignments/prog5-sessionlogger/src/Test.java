import java.io.*;
import java.util.Scanner;


public class Test {
    // CSVFileWriter csvFileWriter = CSVFileWriter.getInstance();
    // String newEntry = csvFileWriter.makeChatSessionLine(1, 3, 4, 1234);
    // String newTotal = csvFileWriter.makeChatSessionLine(1, 3, 4, 1234);
    // csvFileWriter.writeToCSVFile(csvFileWriter.updateCSVFile("data/chat_statistics.csv", newTotal, newEntry));

    public static void main(String[] args) {

        // LogFileWriter log = LogFileWriter.getInstance();
        // System.out.println(log);

        // final String FILENAME = "testoutput.txt";
        // // File file = new File(FILENAME);

        // log.build(FILENAME);
        // log.build("asdf");
        // log.log("testing that this gets logged\n");
        // System.out.println("ooooo");
        // log.log("another");
        // System.out.println("asdfasdf");

        // log.end();
        // log.build(new File("another"));
        // log.log("ano");
        // log.end();

        SessionLogger sessionLogger = SessionLogger.getInstance();
        sessionLogger.beginNewSession();
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        sessionLogger.logUserInput(line);
        sessionLogger.logSystemOutput("system response");
        sessionLogger.endSession();

        // CSVFileWriter csvfa = CSVFileWriter.getInstance();
        // csvfa.build("csvfa",false);
        // System.out.println(csvfa.isBuilt());
        // csvfa.writeChatSessionToFile(5, 6, 7, 4234);
        // csvfa.end();

        // SessionFileReader sfr = SessionFileReader.getInstance();
        // System.out.println(sfr.getSession(0, "data/chat_statistics.csv"));

        // CSVFileWriter csvFileWriter = CSVFileWriter.getInstance();
        // String newEntry = csvFileWriter.makeChatSessionLine(1, 3, 4, 1234);
        // String newTotal = csvFileWriter.makeChatSessionLine(1, 3, 4, 1234);
        // csvFileWriter.writeToCSVFile(csvFileWriter.updateCSVFile("data/chat_statistics.csv", newTotal, newEntry));
    

        


    }
}
