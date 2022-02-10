// Shape.h

#ifndef SHAPE_
#define SHAPE_

#include <string>

using namespace std;

class Shape {
protected:
    double area;
    double perimeter;
    string errorMessage;
    

public:
    Shape();
    virtual ~Shape();
    double getArea();
    double getPerimeter();
    string getErrorMessage();
};

#endif /* SHAPE */