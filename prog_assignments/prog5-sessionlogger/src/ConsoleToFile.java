import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

class ConsoleToFile {

    public static void main(String[] args) {

        try
        {
	        // Store current System.out before assigning a new value 
             PrintStream console = System.out; 
	
            // Creating file output stream
            PrintStream fileOut = new PrintStream("./out.txt");

	    System.out.println("Enter data line by line. Type exit to terminate the program");
        System.out.println("dude due");

            // Redirecting standard console output to a file.
            System.setOut(fileOut);

            // Get input using Scanner from Console 
            Scanner scanner = new Scanner(System.in);

            // Read string line.
	        // Write exit to terminate the program
            String inputLine = scanner.nextLine();

            while(true)
            {

                // If user input 'quit' then break the loop.
                if("exit".equalsIgnoreCase(inputLine))
                {
                    break;
                }

               System.out.println(inputLine); // write to file
      
                // Get next user input line text.
                inputLine = scanner.nextLine();
            }

            System.out.println("Program terminated ");

	    // Use stored value for output stream 
            System.setOut(console); 
            System.out.println("Program terminated"); 

        }catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }


}