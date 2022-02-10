// Triangle.h

#ifndef TRIANGLE_
#define TRIANGLE_

#include <string>
#include "Shape.h"

using namespace std;

class Triangle: public Shape {

public:
    Triangle(double, double, double);
    virtual ~Triangle();

    
    double getArea();
    double getPerimeter();
    string getErrorMessage();
    
};

#endif /* TRIANGLE */