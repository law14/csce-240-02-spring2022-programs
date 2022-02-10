// Rectangle.cpp

#include "Rectangle.h"

Rectangle::Rectangle(double side1, double side2) {
    area = side1 * side2;
    perimeter = 2*(side1+side2);
}

Rectangle::~Rectangle() {

}

/*
double Rectangle::getArea() {
    return area;
}

double Rectangle::getPerimeter() {
    return perimeter;
}

string Rectangle::getErrorMessage() {
    return errorMessage;
}
*/