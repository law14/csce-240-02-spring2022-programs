// Circle.h

#ifndef CIRCLE_
#define CIRCLE_

#include <string>
#include "Shape.h"

using namespace std;

class Circle: public Shape {
    double radius;

public:
    Circle(double);
    virtual ~Circle();

    
    double getArea();
    double getPerimeter();
    string getErrorMessage();
    
};

#endif /* CIRCLE */