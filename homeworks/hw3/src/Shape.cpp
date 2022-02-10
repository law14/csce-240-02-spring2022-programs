// Shape.cpp

#include "Shape.h"

Shape::Shape() {
    area = 0.0;
    perimeter = 0.0;
    errorMessage = "Not enough information to calculate";
}

Shape::~Shape() {

}

double Shape::getArea() {
    return area;
}

double Shape::getPerimeter() {
    return perimeter;
}

string Shape::getErrorMessage() {
    return errorMessage;
}

