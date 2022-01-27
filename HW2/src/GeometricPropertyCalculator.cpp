//============================================================================
// Name        : GeometricPropertyCalculator
// Author      : Luke Watson
// Version     :
// Copyright   : Your copyright notice
// Description : A calculator that reads an input file and based on user specification, calculates the value of each shapes property.
//============================================================================

#include <iostream>
#include <fstream>
#include <sstream>
#include <algorithm>

using namespace std;

// Function to read inFiles, calculate, and output result to an outFile, referening https://www.cplusplus.com/doc/tutorial/inFiles/
void readWriteCalcFile() {

    cout << "\n *** Beginning readWriteCalcFile ***\n\n";

    string in_file_name = "data/input.txt";
    string out_file_name = "data/output.txt";
    string line;

    ifstream in_file(in_file_name);
    ofstream out_file(out_file_name);

    if(in_file.is_open()) {
        while (getline(in_file, line)) {
            
        }
    }

    
}