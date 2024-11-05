# Problem Statement

Create a Graphics Library that allows users to create and work with regular two dimensional shapes like square, rectangle, circle, triangle and regular polygon.

### Basics
- The library should allow the user to create a virtual rectangular screen with X and Y coordinates ranging from 0 to `XMAX` and 0 to `YMAX`. <br>
- The left bottom corner of the screen will have the coordinate <0,0> and will be considered as the origin of the screen. You can assume that XMAX and YMAX are real numbers, and a point on screen can be represented by real coordinates. <br>
- We are assuming that the screen has an infinite number of points, though in reality the screen has a discrete number of pixels. <br>
- Shape objects will be created and placed on the virtual screen at desired coordinates. 
We will assume that shapes will always be placed in a standard orientation, where one of the edges will be parallel to the X axis, and the left corner of that edge will be considered as the origin of the shape.
- We will also maintain the timestamp specifying when the shape object was added to the screen. 
- The specific shape classes are to be hidden from the user of the library, so that the user code stays independent of these specific shape classes. The user will only see the Shape and Screen interface.

This will be achieved through the use of Factory pattern, where user will not directly use the constructors of specific shape classes to instantiate shape objects, instead will request a factory to create specific shape objects. The factory will return objects of type Shape.

> In case of a circle the origin will be considered to be a point on the circle that lies on the line connecting the center of the circle to the origin of the screen.
 

### Details

Create a hierarchy of Shape Abstract Data Type where Shape is an interface that will expose certain basic APIs like `getArea`, `getPerimeter`, `getOrigin` and `isPointEnclosed`. 

`Shape` interface will have a `ShapeType` enum that will list all the supported types of shapes by the system.

Implement various shape classes listed above.

There will be a `Point` class that will have two parameters x and y that will represent the location of it on a screen. You can assume that the x and y coordinates for a point can be real.

Create a Factory class that will create shapes based on the ShapeType. It will expose a static method `createShape` that will take `ShapeType`, Point and `List<Integer>`. Where Point will specify either the starting point of the shape or center point, a generic way. And the list of integers will display other parameters of the shape like for square only width, circle only radius, rectangle length and breadth, and so on.

Create a class Screen that supports following methods

- Add a shape object to the screen at a specified location with default orientation.
- Delete a shape object from the screen
- Delete all shape objects of a specific type
- Return the shape objects on the screen sorted in desired ascending order based on area, perimeter, timestamp or origin distance (distance of the origin of the shape from the origin of the screen). Consider various design options for this method.
- Return the list of shape objects enclosing a specified point.

Additional

A method that returns all the shape objects that are on top of a given shape object. A shape object A is considered to be on top of another shape object B if A was added after B, and A and B overlap on the screen. 

> [!Warning]
> Rendering not required



