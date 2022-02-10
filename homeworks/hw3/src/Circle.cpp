// Circle.cpp

#include "Circle.h"

Circle::Circle(double radius) {
    area = 3.14 * radius * radius;
    perimeter = 2 * 3.14 * radius;
}

Circle::~Circle() {
    
}

/*
double Circle::getArea() {
    return area;
}

double Circle::getPerimeter() {
    return perimeter;
}

string Circle::getErrorMessage() {
    return errorMessage;
}
*/