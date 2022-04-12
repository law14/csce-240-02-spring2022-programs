//============================================================================
// Name        : Extractor
// Author      : Luke Watson
// Version     :
// Copyright   : Your copyright notice
// Description : 
//============================================================================

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Extractor {
    ArrayList<String> data;

    // Constructor methods
    public Extractor() {
        data = new ArrayList<String>();
        fileReader("data/page_content.txt");

    }



    private void fileReader(String filePath) {
        try {
            File inputFile = new File(filePath);
            Scanner fileScanner = new Scanner(inputFile);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                
                if (line.contains("        Representative")) {                    
                    //System.out.println(line.trim());
                    data.add(line.trim());
                    while (!line.contains("<")) {
                        data.add(line.trim());
                        line = fileScanner.nextLine();
                        //System.out.println(line.trim());
                    }
                    //representative = true;
                    
                } else if (line.contains("    Columbia")) {
                    //System.out.println(line.trim());
                    data.add(line.trim());
                    while (!line.contains("<")) {
                        data.add(line.trim());
                        line = fileScanner.nextLine();
                        //System.out.println(line.trim());
                    }
                } else if (line.contains("Personal Information")) {
                    //System.out.println(line.trim());
                    data.add(line.trim());
                    while (!line.contains("Committee")) {
                        data.add(line.trim());
                        line = fileScanner.nextLine();
                        //System.out.println(line.trim());
                    }
                }
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("File failed to read");
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        Extractor myExtractor = new Extractor();
    }
}