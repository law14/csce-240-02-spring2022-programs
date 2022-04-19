//============================================================================
// Name        : UserIntent2QueryMapper
// Author      : Luke Watson
// Version     :
// Copyright   : Your copyright notice
// Description : 
//============================================================================

import java.util.Scanner;

public class UserIntent2QueryMapper {
    public static boolean quit = false;

    public static void main(String[] args) {
        //System.out.println("Bruh");
        // System.out.println(UserIntent2QueryMapper.getUserUtterance());
        //QueryMapper qm = new QueryMapper();
        // a.run("prog2processor -t \"Contact Information\"");
        // System.out.println("bro");
        System.out.println("Welcome to the JohnRMcCravyIII-chatbot");
        while(!quit) {
            Processor a = new Processor();
            QueryMapper qMap = new QueryMapper(getUserUtterance());
            a.run(qMap.getQuery());

        }


    }

    private static String getUserUtterance() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        //sc.close();
        if (line.equals(null)) {
            return "null value";
        } else if (line.equalsIgnoreCase("quit")) {
            quit = true;
        }
        return line;
    }
}