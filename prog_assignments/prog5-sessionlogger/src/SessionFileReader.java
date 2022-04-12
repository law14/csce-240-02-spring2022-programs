import java.io.*;
import java.util.ArrayList;

public class SessionFileReader {
    private static SessionFileReader sfc = new SessionFileReader();

    private SessionFileReader() {}

    public static SessionFileReader getInstance() {
        if (sfc == null) {
            sfc = new SessionFileReader();
        }
        return sfc;
    }


    public void readFromFile(String fileName) {
        try {
            //BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String line = buffReader.readLine();
            while(line != null) {
                System.out.println(line);
                line = buffReader.readLine();
            }
            buffReader.close();
            // System.out.println(buffReader.readLine());
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public ArrayList<String> readCSVFile(String fileName) {
        try {
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            ArrayList<String> lines = new ArrayList<String>();

            String line = buffReader.readLine();
            while(line != null) {
                lines.add(line+"\n");
                line = buffReader.readLine();
            }
            buffReader.close();
            return lines;
        } catch (Exception e) {
            System.out.println("Exception " + e);
            return null;
        }
    }

    // delim and stuff for below method

    public String getSession(int desiredSession,String csvFileName) {
        ArrayList<String> session = readCSVFile(csvFileName);
        return session.get(desiredSession);
    }
    
}
