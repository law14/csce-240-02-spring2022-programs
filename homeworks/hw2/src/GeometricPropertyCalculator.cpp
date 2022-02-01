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
string output = "";
bool caseInsensitiveComparison(string s1, string s2);
int perimeterOrArea();

// Function to read inFiles, calculate, and output result to an outFile, referening https://www.cplusplus.com/doc/tutorial/inFiles/
void readCalcFile() {

    cout << "\n *** Beginning readWriteCalcFile ***\n\n";

    string in_file_name = "../data/input.txt";
    string line;

    ifstream in_file(in_file_name);

    if(in_file.is_open()) {
        while (getline(in_file, line)) {

            // Parsing each line
            stringstream lineStream(line);
            string segment;
            while (lineStream >> segment) {
                // cout << "\n\n**" << segment << "**\n\n";
                //string output = segment;
                if (caseInsensitiveComparison("rectangle", segment)) {
                    int side1, side2;
                    if (lineStream >> side1) {
                        if (lineStream >> side2) {
                            string out = "\n" + segment + "\t" + to_string(side1) + "\t" + to_string(side2);
                            cout << out;
                            int area = side1*side2;
                            int perimeter = 2*side1 + 2*side2;
                            if (perimeterOrArea() == 0) {
                                output += "\nRECTANGLE PERIMETER" + to_string(perimeter);
                            } else if (perimeterOrArea() == 1) {
                                output += "\nRECTANGLE AREA" + to_string(area);
                            }
                        } else {
                            cout << "Not enough information to calculate";
                        }
                    }  else {
                        cout << "Not enough information to calculate";
                    }
                } else if (caseInsensitiveComparison("circle", segment)) {
                    int radius;
                    if (lineStream >> radius) {
                        string out = "\n" + segment + "\t\t" + to_string(radius);
                        cout << out;
                        double area = 3.14 * radius * radius;
                        double perimeter = 3.14 * 2 * radius;
                        if (perimeterOrArea() == 0) {
                            output += "\nCIRCLE PERIMETER" + to_string(perimeter);
                        } else if (perimeterOrArea() == 1) {
                            output += "\nCIRCLE AREA" + to_string(area);
                        }
                    } else {
                        cout << "Not enough information to calculate";
                    }
                } else if (caseInsensitiveComparison("triangle", segment)) {
                    int side1, side2, side3;
                    if (lineStream >> side1) {
                        if (lineStream >> side2) {
                            if (lineStream >> side3) {
                                string out = "\n" + segment + "\t" + to_string(side1) + "\t" + to_string(side2) + "\t" + to_string(side3);
                                cout << out;
                                int perimeter = side1 + side2 + side3;
                                double area = 0.5;
                                if (perimeterOrArea() == 0) {
                                    output += "\nTRIANGLE PERIMETER" + to_string(perimeter);
                                } else if (perimeterOrArea() == 1) {
                                    output += "\nTRIANGLE AREA" + to_string(area);
                                }
                            } else {
                                cout << "Not enough information to calculate";
                            }
                        } else {
                            cout << "Not enough information to calculate";
                        }
                    }  else {
                        cout << "Not enough information to calculate";
                    }
                } else {
                    cout << "Not a valid shape";
                }
                // cout << "\n\t\t" << segment;
                segment = "";

            } // end - while

        } // end - while

        in_file.close();
    } else {
        cout << "Unable to open file - " << in_file_name << endl;
    }
}

// Function to write outFiles
void writeFile(string input) {
    string out_file_name = "../data/output.txt";
    ofstream out_file(out_file_name);
    if (out_file.is_open()) {
        out_file << input;
        out_file.close();
    } else {
        cout << "Unable to open output file - " << out_file_name << endl;
    }
}

int perimeterOrArea() {
    char command = 0;
    cout << "Enter 0 for Perimeter and 1 for area" << endl;
    cin >> command;

    if (command == '0') {
        return 0;
    } else if (command == '1') {
        return 1;
    } else {
        cout << "Invalid command";
        return 2;
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
    readCalcFile();
    writeFile(output);

    return 0;
}