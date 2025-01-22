WITH longBorrow AS (
	SELECT * FROM Borrowing
	WHERE DATEDIFF(MONTH, BorrowDate, ReturnDate) > 1
)
SELECT BorrowID, MemberID FROM longBorrow WHERE BookID = 2;