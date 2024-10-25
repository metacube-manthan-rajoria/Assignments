# Problem Statement

Note : Use concepts of Recursion for completing assignment. Also write JUnit test cases for below problems.

```
Question 3

Implement N Queens Problem using Recursion

The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. (Thus, a solution requires that no two queens share the same row, column, or diagonal)

Boolean  nQueen(int[][], int startRow, int dimensionOfMatrix);

int [][] board = new int [][] {
    { 0,  0,  0,  0},
    { 0,  0,  0,  0},
    { 0,  0,  0,  0},
    { 0,  0,  0,  0} 
};
Boolean result = nQueen(board , 0, 4);
where result should be true and board should have following content. 

Following is a solution for 4 Queen problem.	

The expected output is a binary matrix which has 1s for the blocks where queens are placed. For example following is the output matrix for above 4 queen solution.
    { 0,  1,  0,  0}
    { 0,  0,  0,  1}
    { 1,  0,  0,  0}
    { 0,  0,  1,  0}
```
<br>

```
Challenging Problem


Knights-tour-problem:
A knight's tour is a sequence of moves of a knight on a chessboard such that the knight visits every square only once. If the knight ends on a square that is one knight's move from the beginning square (so that it could tour the board again immediately, following the same path), the tour is closed, otherwise it is open.

Implement knights-tour-problem for n*n matrix
```
<br>

