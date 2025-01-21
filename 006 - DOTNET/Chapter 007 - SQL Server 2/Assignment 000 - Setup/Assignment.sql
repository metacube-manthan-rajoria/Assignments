CREATE TABLE BooksForSale(
    BookID INT NOT NULL,
	Price DECIMAL(5,2) NOT NULL,
	FOREIGN KEY (BookID) REFERENCES Books(BookID)
);

CREATE TABLE MemberFees(
    MemberID INT NOT NULL,
	Fees DECIMAL(10,2) NOT NULL,
	FOREIGN KEY (MemberID) REFERENCES Members(MemberID)
);

INSERT INTO BooksForSale VALUES(6, 499.99);
INSERT INTO BooksForSale VALUES(5, 300);

INSERT INTO MemberFees VALUES(1, 700);
INSERT INTO MemberFees VALUES(2, 600);
INSERT INTO MemberFees VALUES(3, 750);
INSERT INTO MemberFees VALUES(4, 820);



