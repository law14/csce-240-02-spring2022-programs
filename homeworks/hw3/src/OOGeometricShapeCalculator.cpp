//============================================================================
// Name        : GeometricPropertyCalculator
// Author      : Luke Watson
// Version     :
// Copyright   : Your copyright notice
// Description : A calculator that reads an input file and based on user specification, calculates the value of each shapes property.
//============================================================================

#include <fstream>
#include <sstream>
#include <iostream>
#include <algorithm>
using namespace std;

#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include "Triangle.h"
bool caseInsensitiveComparison(string s1, string s2);

Shape shapeArray [3];

void readCalcFile() {
    cout << "\n *** Beginning readCalcFile ***\n\n";

    string in_file_name = "data/input.txt";
    string line;

    ifstream in_file(in_file_name);

    if(in_file.is_open()) {
        while (getline(in_file, line)) {

            // Parse each line
            stringstream lineStream(line);
            string segment;
            while (lineStream >> segment) {
                if(caseInsensitiveComparison("rectangle", segment)) {
                    double side1, side2;
                    if(lineStream >> side1 && lineStream >> side2) {
                        shapeArray[0] = Rectangle(side1, side2);
                    }
                } else if (caseInsensitiveComparison("circle", segment)) {
                    double radius;
                    if(lineStream >> radius) {
                        shapeArray[1] = Circle(radius);
                    }
                } else if (caseInsensitiveComparison("triangle", segment)) {
                    double side1, side2, side3;
                    if (lineStream >> side1 && lineStream >> side2 && lineStream >> side3) {
                        shapeArray[2] = Triangle(side1,side2,side3);
                    }
                }

            }
        }

        in_file.close();
    } else {
        cout << "Unable to open file - " << in_file_name << endl;
    }
}

void writeCalcFile(int output) {
    cout << "\n *** Beginning writeCalcFile ***\n\n";

    string out_file_name = "data/output.txt";
    string line;

    ofstream out_myfile(out_file_name);
    if (out_myfile.is_open()) {
        int len = sizeof(shapeArray)/sizeof(shapeArray[0]);
        for(int i=0; i<len; i++) {
            if(output==0) {
                string out_line = "AREA " + to_string(shapeArray[i].getArea());
                cout << out_line << endl;
                out_myfile << out_line << endl;
            } else if (output == 1) {
                string out_line = "Perimeter " + to_string(shapeArray[i].getPerimeter());
                cout << out_line << endl;
                out_myfile << out_line << endl;
            }
        }
        out_myfile.close();
    } else {
        cout << "Unable to open output file - " << out_file_name << endl;
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

    int x;
    cout << "Enter 0 for AREA or 1 for PERIMETER";
    cin >> x;

    if(x==1 || x==0) {
        writeCalcFile(x);
    }


    return 0;
}