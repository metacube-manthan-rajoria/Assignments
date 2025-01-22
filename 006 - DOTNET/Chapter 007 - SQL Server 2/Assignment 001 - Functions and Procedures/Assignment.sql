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
	SELECT @valid = [dbo].[checkBookDate](BorrowDate, @date) FROM Borrowing WHERE BorrowID = @id
	IF @valid = 1
		BEGIN
			UPDATE Borrowing SET ReturnDate = @date WHERE BorrowID = @id
		END
	ELSE
		BEGIN
			UPDATE Borrowing SET ReturnDate = null WHERE BorrowID = @id
		END
END

-- Using Procedure
EXEC updateBookReturnDate @id = 15, @date = '2025-01-20';