//============================================================================
// Name        : UserIntent2QueryMapper
// Author      : Luke Watson
// Version     :
// Copyright   : Your copyright notice
// Description : 
//============================================================================

import java.util.Scanner;

public class UserIntent2QueryMapper {
    public static void main(String[] args) {
        //System.out.println("Bruh");
        // System.out.println(UserIntent2QueryMapper.getUserUtterance());
        //QueryMapper qm = new QueryMapper();
        Processor a = new Processor();
        a.run("prog2processor -t \"Contact Information\"");


    }

    private static String getUserUtterance() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();
        if (line.equals(null)) {
            return "null value";
        }
        return line;
    }
}