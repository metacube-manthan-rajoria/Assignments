# Problem Statement
Problem 2

Implement the immutable class Poly using an array to represent single variable polynomial. Note that you should be storing only those terms of polynomial that have non zero coefficient. You can assume that the coefficients are integers.
It should support methods like - 

- evaluate(float) - return the value of the polynomial for the given value of the variable
- degree() - return the degree of the polynomial
- addPoly(Poly p1, Poly p2) - return the sum of the polynomials p1 and p2
- multiplyPoly(Poly p1, Poly p2) - return the product of polynomials p1 and p2


You may use private helper methods. addPoly() and multiplyPoly() can make assumptions about size of the resulting polynomial to decide about the size of the array to be created.

#### Bonus problem 1

Implement mutable version of Poly where one can add and delete members from the polynomial dynamically, and there is no upper limit on the size of the polynomial.

#### Bonus problem 2

How would one represent multivariate polynomial where there is no limit on number of variables.