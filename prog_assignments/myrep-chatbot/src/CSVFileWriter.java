import java.io.*;
import java.util.ArrayList;

/**
 * The CSVFileAdjuster class follows the singleton design pattern
 *  * and extends the abstract BufferedWriterBase class.
 * To use first "build()" then "writeToFile()" then "end()"
 * @author Luke
 */
public class CSVFileWriter extends BufferedWriterBase {
    private static CSVFileWriter csvFileWriter = new CSVFileWriter();
    BufferedWriter writer;
    private static final String DELIM = ",";

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
        if (csvFileWriter == null) {
            csvFileWriter = new CSVFileWriter();
        }
        return csvFileWriter;
    }
    
    public void addEntry() {

    }

    public void updateTotal() {

    }

    public String makeChatSessionLine(int sNum, int numUsrUtt, int numSysUtt, long timeTaken) {
        return String.valueOf(sNum) +DELIM+ String.valueOf(numUsrUtt) +DELIM+ String.valueOf(numSysUtt) +DELIM+ String.valueOf(timeTaken)+"\n";
    }


    public void writeToCSVFile(ArrayList<String> out) {
        csvFileWriter.build("data/chat_statistics.csv", false);
        for (int i=0; i<out.size(); i++) {
            csvFileWriter.write(out.get(i));
        }
        csvFileWriter.end();
    }


    public ArrayList<String> updateCSVFile(String csvFileName, String newTotal, String newEntry) {
        SessionFileReader sfr = SessionFileReader.getInstance();
        ArrayList<String> csv = new ArrayList<String>();
        csv = sfr.readCSVFile(csvFileName);
        csv.set(1,newTotal);
        csv.add(2,newEntry);
        return csv;
    }


}