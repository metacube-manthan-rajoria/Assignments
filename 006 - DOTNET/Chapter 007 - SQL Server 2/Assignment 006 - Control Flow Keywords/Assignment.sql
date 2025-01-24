CREATE PROCEDURE getBorrowCount @id INT
AS
BEGIN
	IF @id > 0
		BEGIN
			SELECT COUNT(BorrowID) FROM Borrowing WHERE BookID = @id;  
		END
	ELSE
		BEGIN
			THROW 51000, 'Invalid record', 1;
		END
END




BEGIN TRY
	SELECT * FROM randomTable;
END TRY
BEGIN CATCH
	PRINT "We ran into an error"
END CATCH 



WHILE (
	SELECT COUNT(BorrowID) FROM Borrowing
) < 100;
BEGIN

	IF (
		SELECT COUNT(BookID) FROM Borrowing WHERE BookID = 2
	) > 10
        BREAK
    ELSE
		BEGIN
			DECLARE @currentCount INT
			SELECT @currentCount = COUNT(BookID) FROM Borrowing WHERE BookID = 2
			INSERT INTO Borrowing(MemberID, BookID, BorrowDate, ReturnDate) VALUES (2, 2, '2000-01-01', '2002-01-01');
        	CONTINUE
		END
END