-- Normal Ranking Function : ROW NUMBER
SELECT *, 
	ROW_NUMBER() OVER(ORDER BY BorrowDate) AS Ranking
FROM Borrowing;

-- Normal Ranking Function : ROW NUMBER with PARTITION
SELECT *, 
	ROW_NUMBER() OVER(PARTITION BY BOOKID ORDER BY BorrowDate) AS Ranking
FROM Borrowing;

-- Normal Ranking Function : RANK
SELECT *, 
	RANK() OVER(ORDER BY BorrowDate) AS Ranking
FROM Borrowing;

-- Normal Ranking Function : DENSE RANK
SELECT *, 
	DENSE_RANK() OVER(ORDER BY BorrowDate) AS Ranking
FROM Borrowing;