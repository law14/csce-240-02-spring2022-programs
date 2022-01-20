//============================================================================
// Name        : inFileBasedCalculator.cpp
// Author      : Luke
// Version     :
// Copyright   : Your copyright notice
// Description : A calculator that 
//============================================================================


#include <iostream>
#include <fstream>
#include <algorithm>

using namespace std;

bool caseInsensitiveComparison(string s1, string s2);


// Function to read inFiles, calculate, and output result to a inFile, referencing https://www.cplusplus.com/doc/tutorial/inFiles/
void readWriteCalcinFile() {

    // Init. and decl. important variables
    cout << "Now reading inFile" << endl;
    string inFile_name = "input.txt";
    string outFile_name = "output.txt";
    string line;

    string oper;
    string text = "";
    int num1;
    int num2;
    int result;
    
    // Read from inFile
    ifstream inFile (inFile_name);
    if (inFile.is_open()) {
        getline(inFile,line);
        oper = line;
        getline(inFile,line);
        num1 = stoi(line);
        getline(inFile,line);
        num2 = stoi(line);

        //cout << oper << "\n" << num1 << "\n" << num2 << endl;
        text.append("The result of ").append(oper).append(" on ").append(to_string(num1)).append(" and ").append(to_string(num2)).append(" is below");

        inFile.close();
    } else {
        cout << "Unable to open inFile - " << inFile_name << endl;
    }

    // Getting operator and finding result
    if(caseInsensitiveComparison("add", oper)){
        result = num1 + num2;
    } else if (caseInsensitiveComparison("subtract", oper)) {
        result = num1 - num2;
    } else if (caseInsensitiveComparison("multiply", oper)) {
        result = num1 * num2;
    } else if (caseInsensitiveComparison("divide", oper)) {
        if (num2 != 0) {
            result = num1 / num2;
        }
        result = 0;
    }

    // cout << result;

    // Write to outFile
    ofstream outFile (outFile_name);
    if (outFile.is_open()) {
        outFile << text << endl << result << endl;
        outFile.close();
    } else {
		cout << "Unable to open output file - " << outFile_name << endl;
    }


}

// Case insensitive string comparison function referencing: https://www.tutorialspoint.com/case-insensitive-string-comparison-in-cplusplus
bool caseInsensitiveComparison(string s1, string s2) {

    // convert s1 and s2 into lower case strings
    transform(s1.begin(), s1.end(), s1.begin(), ::tolower);
    transform(s2.begin(), s2.end(), s2.begin(), ::tolower);
    if(s1.compare(s2) == 0) {
        return true;
    }
    return false;
};




int main() {


    readWriteCalcinFile();



    return 0;
}