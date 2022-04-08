import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.*;
public class ConsoleTutorial {
    
    // Preserve original console printstream
    public static PrintStream originalConsole = System.out;
    public static void main(String[] args) {
        // Display in initial console
        System.out.println("One - Original Console");

        
        

        // Set std output to use new console
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        originalConsole.println("this is it");
        System.out.println(originalConsole.toString());

        System.out.println("Two - console directed to output stream");
        // run();
        test2("bob");
        //originalConsole.println(newConsole.toString());

        System.setOut(originalConsole);
        System.out.println("Restored Original Console");

        System.out.println(newConsole.toString());
        System.out.println("test");
        System.out.toString();
        //System.out.flush();
        System.out.toString();
        System.out.println("test");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(in.readLine());
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public static void run() {
        System.out.println("Test 1, if this only shows up once then we can effectively preemptiveely send all info sent to System.out to its own PrintStream and access it later");
    }
    public static void test2(String a) {
        System.out.println(a);
        // originalConsole.println(a);
    }
}
