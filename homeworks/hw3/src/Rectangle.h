// Rectangle.h

#ifndef RECTANGLE_
#define RECTANGLE_

#include <string>
#include "Shape.h"

using namespace std;

class Rectangle: public Shape {

public:
    Rectangle(double, double);
    virtual ~Rectangle();

    
    double getArea();
    double getPerimeter();
    string getErrorMessage();
    
};

#endif /* RECTANGLE */