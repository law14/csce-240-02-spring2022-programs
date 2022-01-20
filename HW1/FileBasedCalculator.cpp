//============================================================================
// Name        : FileBasedCalculator.cpp
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


// Function to read files, calculate, and output result to a file, referencing https://www.cplusplus.com/doc/tutorial/files/
void readWriteCalcFile() {

    // Init. and decl. important variables
    cout << "Now reading file" << endl;
    string file_name = "input.txt";
    string line;

    string oper;
    int num1;
    int num2;
    int result;
    
    // Read from file
    ifstream file (file_name);
    if (file.is_open()) {
        getline(file,line);
        oper = line;
        getline(file,line);
        num1 = stoi(line);
        getline(file,line);
        num2 = stoi(line);

        cout << oper << "\n" << num1 << "\n" << num2 << endl;

        file.close();
    } else {
        cout << "Unable to open file - " << file_name << endl;
    }

    // Write to file


    // Getting operator and finding result
    if(caseInsensitiveComparison("add", oper)){
        result = num1 + num2;
    } else if (caseInsensitiveComparison("subtract", oper)) {
        result = num1 - num2;
    } else if (caseInsensitiveComparison("multiply", oper)) {
        result = num1 * num2;
    } else if (caseInsensitiveComparison("divide", oper)) {
        result = num1 / num2;
    }

    cout << result;




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


    readWriteCalcFile();



    return 0;
}