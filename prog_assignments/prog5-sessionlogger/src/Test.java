import java.io.*;


public class Test {
    public static void main(String[] args) {
        LogFileWriter log = LogFileWriter.getInstance();
        System.out.println(log);

        final String FILENAME = "testoutput.txt";
        // File file = new File(FILENAME);

        log.build(FILENAME);
        log.build("asdf");
        log.log("testing that this gets logged\n");
        System.out.println("ooooo");
        log.log("another");
        System.out.println("asdfasdf");

        log.end();
        log.build(new File("another"));
        log.log("ano");
        log.end();
    }
}
