// Triangle.cpp

#include "Triangle.h"

Triangle::Triangle(double side1, double side2, double side3) {
    area = 0.5;
    perimeter = side1 + side2 + side3;
}

Triangle::~Triangle() {
    
}

/*
double Triangle::getArea() {
    return area;
}

double Triangle::getPerimeter() {
    return perimeter;
}

string Triangle::getErrorMessage() {
    return errorMessage;
}
*/