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

    public static void main(String[] args) {
        
        JSONWrite a = new JSONWrite();
        JSONRead b = new JSONRead();
        Representative myRep = b.getRepresentative();
        // System.out.println("" + myRep.getName() + myRep.getHomePhone());
        
        String COMMAND = "prog2processor -t";

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the district name:\n(Hint: District 13)");

        String input = s.nextLine();
        if(input.equalsIgnoreCase("district 13")) {

            boolean quit = false;
            while(!quit) {
                System.out.println("\nRun a command!");

                input = s.nextLine();
                if(input.equalsIgnoreCase(COMMAND+" \"Contact Information\"")) {
                    System.out.println(myRep.getName() + "\n" + myRep.getRegion() + "\n" 
                    + myRep.getHomeAddress() + "\n" + myRep.getColaAddress() + "\n"
                    + myRep.getHomePhone() + "\n" + myRep.getColaPhone());

                } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:name\"")) {
                    System.out.println("\t" + myRep.getName());

                } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:region\"")) {
                    System.out.println("\t" + myRep.getRegion());

                } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:home address\"")) {
                    System.out.println("\t" + myRep.getHomeAddress());

                } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:columbia address\"")) {
                    System.out.println("\t" + myRep.getColaAddress());

                } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:home phone\"")) {
                    System.out.println("\t" + myRep.getHomePhone());

                } else if(input.equalsIgnoreCase(COMMAND+" \"Contact Information:columbia phone\"")) {
                    System.out.println("\t" + myRep.getColaPhone());

                } else if(input.equalsIgnoreCase("quit")) {
                    quit = true;
                }
            }
        }
    }
}