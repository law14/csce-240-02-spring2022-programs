//============================================================================
// Name        : Processor
// Author      : Luke Watson
// Version     :
// Copyright   : Your copyright notice
// Description : 
//============================================================================


// Refrenced https://www.geeksforgeeks.org/parse-json-java/

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Scanner;

public class Processor {

    public void run(String input) {
        JSONWrite a = new JSONWrite();
        JSONRead b = new JSONRead();
        Representative myRep = b.getRepresentative();
        SessionLogger SL = SessionLogger.getInstance();
        SL.beginNewSession();
        // System.out.println("" + myRep.getName() + myRep.getHomePhone());
        
        String COMMAND = "prog2processor -t";

        /*
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the district name:\n(Hint: District 13)");
        */


            // input = s.nextLine();
            if(input.equalsIgnoreCase(COMMAND+" \"Contact Information\"")) {
                SL.logSystemOutput(myRep.getName() + "\n" + myRep.getRegion() + "\n" 
                + myRep.getHomeAddress() + "\n" + myRep.getColaAddress() + "\n"
                + myRep.getHomePhone() + "\n" + myRep.getColaPhone());

            } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:name\"")) {
                SL.logSystemOutput("\t" + myRep.getName());

            } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:region\"")) {
                SL.logSystemOutput("\t" + myRep.getRegion());

            } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:home address\"")) {
                SL.logSystemOutput("\t" + myRep.getHomeAddress());

            } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:columbia address\"")) {
                SL.logSystemOutput("\t" + myRep.getColaAddress());

            } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:home phone\"")) {
                SL.logSystemOutput("\t" + myRep.getHomePhone());

            } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:columbia phone\"")) {
                SL.logSystemOutput("\t" + myRep.getColaPhone());

            } /* else if(input.equalsIgnoreCase("quit")) {
                quit = true;
            } */
    }
}