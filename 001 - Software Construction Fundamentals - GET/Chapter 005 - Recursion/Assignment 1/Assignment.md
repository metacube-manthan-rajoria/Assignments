# Problem Statement

Note : Use concepts of Recursion for completing assignment. Also write JUnit test cases for below problems.

```
Question 1
Design a class to implement following mathematical problems.
L.C.M. of two numbers x and y. Receive x and y as method parameters and return computed value.
H.C.F of two numbers x and y using Euclid’s algorithm. Receive x and y as method parameters and return computed value.

Assume x and y as positive integers.
```
<br>

### Euclids Algo for finding HCF
```Note
If we have to find the HCF of 320 and 132, we apply the Euclid’s Division Lemma on these two numbers:

320 = 132(2) + 56 ......... (step 1)

We observe (based on our discussion above) that since the HCF (call it x) is a factor of both 320 and 132, it must also be a factor of the remainder 56 in the division step above. Now, we apply the division lemma on 132 and 56:

132 = 56(2) + 20 ......... (step 2)

Once again, since the HCF x is a common factor of both 132 and 56, it must also be a common factor of 20. So, in the next step, we apply the division lemma to 56 and 20:

56 = 20(2) + 16 ............ (step 3)

As earlier, since x is a common factor of both 56 and 20, it must also be a common factor of 16. Next, we apply the division lemma to 20 and 16:

20 = 16(1) + 4 .............. (step 4)

We see that x, being a factor of both 20 and 16, must also be a factor of 4. In the last step, we have:

16 = 4(4) + 0 .............. (step 5)

We have no remainder left. We now assert that the second last remainder is the HCF, that is, the HCF of 320 and 132 is equal to 4.

⇒ HCF (320,132)= 4
```

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


