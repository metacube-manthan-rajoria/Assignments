# Problem Statement

Design an immutable class for representing two-dimensional sparse matrices. Note that for space efficiency you should be storing only non zero elements of a matrix.

It should support following methods 
- return transpose of the matrix
- check whether it is a symmetrical matrix
- add two matrices
- multiply two matrices

> What is the time complexity of each of the methods?

Things to keep in mind
- Object should be immutable
- Write junit test cases
- Methods should be efficient


Sparse Matrix -
In computer programming, a matrix can be defined with a 2-dimensional array. Any array with 'm' columns and 'n' rows represents a m X n matrix. There may be a situation in which a matrix contains more number of ZERO values than NON-ZERO values. Such matrix is known as sparse matrix.

```java
// sparse matrix of class 5x6 with 6 non-zero values
int sparseMatrix[5][6] =
{
    {0 , 0 , 0 , 0 , 9, 0 },
    {0 , 8 , 0 , 0 , 0, 0 },
    {4 , 0 , 0 , 2 , 0, 0 },
    {0 , 0 , 0 , 0 , 0, 5 },
    {0 , 0 , 2 , 0 , 0, 0 }
};
```

To Transpose a matrix, we can simply change every column value to the row value and vice-versa.
A square matrix, A, is symmetric if it is equal to its nonconjugate transpose, A = A.'
In terms of the matrix elements, this means that
ai, j=aj, i

