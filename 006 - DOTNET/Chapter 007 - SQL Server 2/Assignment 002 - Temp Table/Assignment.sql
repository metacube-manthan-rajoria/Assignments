CREATE TABLE #demoTemp(
	BookID INT PRIMARY KEY IDENTITY(1,1), 
	Title VARCHAR(100) NOT NULL,
	Author VARCHAR(100) NOT NULL,
	PublishedYear INT NOT NULL,
	Category VARCHAR(50)
);


INSERT INTO #demoTemp(Title, Author, PublishedYear, Category) VALUES ('Thinking Fast and Slow', 'Daniel Kahneman', 2011, 'Psycology');
INSERT INTO #demoTemp(Title, Author, PublishedYear, Category) VALUES ('Shadow Slave', 'Guilty Three', 2022, 'Fantasy');
INSERT INTO #demoTemp(Title, Author, PublishedYear, Category) VALUES ('The Fault in our Stars', 'John Green', 2010, 'Romance Novel');
INSERT INTO #demoTemp(Title, Author, PublishedYear, Category) VALUES ('Ikigai', 'Daniel Kahneman', 2016, 'Psycology');
INSERT INTO #demoTemp(Title, Author, PublishedYear, Category) VALUES ('Fifty Stands', 'Deepandra', 2015, 'Action');