-- Increment borrow date by 1 day 
DECLARE @id INT
DECLARE @date DATE

DECLARE incrementDate CURSOR FOR
SELECT BorrowID, BorrowDate FROM Borrowing

OPEN incrementDate
FETCH NEXT FROM incrementDate INTO @id, @date

WHILE @@FETCH_STATUS = 0
BEGIN
	UPDATE Borrowing
		SET BorrowDate = DATEADD(DAY, 1, @date)
		WHERE BorrowID = @id
		FETCH NEXT FROM incrementDate INTO @id, @date
END

CLOSE incrementDate
DEALLOCATE incrementDate



SELECT * FROM Borrowing