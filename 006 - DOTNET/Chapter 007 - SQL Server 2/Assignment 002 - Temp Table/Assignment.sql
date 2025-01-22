CREATE TABLE #demoTempTable(
	BorrowID INT PRIMARY KEY IDENTITY(1,1),
	MemberID INT,
	BookID INT,
	BorrowDate DATE,
	ReturnDate DATE
);

INSERT INTO #demoTempTable(MemberID, BookID, BorrowDate, ReturnDate) VALUES (1, 5, '2024-12-10', '2024-12-12');
INSERT INTO #demoTempTable(MemberID, BookID, BorrowDate, ReturnDate) VALUES (1, 3, '2024-12-10', '2025-01-08');
INSERT INTO #demoTempTable(MemberID, BookID, BorrowDate, ReturnDate) VALUES (4, 2, '2023-09-23', '2023-10-14');
INSERT INTO #demoTempTable(MemberID, BookID, BorrowDate, ReturnDate) VALUES (3, 4, '2010-03-19', '2019-07-20');
INSERT INTO #demoTempTable(MemberID, BookID, BorrowDate, ReturnDate) VALUES (2, 2, '2023-10-29', '2024-11-03');

use tempdb;

-- Function
CREATE FUNCTION checkBookDate(@borrowDate DATE, @returnDate DATE)
RETURNS INT
BEGIN
	DECLARE @datevalid INT = 0
	IF @returnDate > @borrowDate
		BEGIN
			SET @datevalid = 1
		END
	ELSE
		BEGIN
			SET @datevalid = 0
		END
	RETURN @datevalid
END

-- Using Function
SELECT [dbo].[checkBookDate](BorrowDate, '2025-10-09') FROM Borrowing;

-- Procedure
CREATE PROCEDURE updateBookReturnDate @id INT, @date DATE
AS
BEGIN
	DECLARE @valid INT
	SELECT @valid = [dbo].[checkBookDate](BorrowDate, @date) FROM #demoTempTable WHERE BorrowID = @id
	IF @valid = 1
		BEGIN
			UPDATE #demoTempTable SET ReturnDate = @date WHERE BorrowID = @id
		END
	ELSE
		BEGIN
			UPDATE #demoTempTable SET ReturnDate = null WHERE BorrowID = @id
		END
END

-- Using Procedure
EXEC updateBookReturnDate @id = 15, @date = '2025-01-20';