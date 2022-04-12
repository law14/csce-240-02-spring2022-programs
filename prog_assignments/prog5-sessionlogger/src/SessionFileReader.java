import java.io.*;

public class SessionFileReader {
    private SessionFileReader sessionFileReader = new SessionFileReader();


    private void readFromFile(String fileName) {
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
    
}
