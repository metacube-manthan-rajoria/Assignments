CREATE TABLE Employee(Id INT, Name VARCHAR(100),Age INT, Salary DECIMAL(10,2), JoiningDate DATE);

INSERT INTO Employee VALUES(1, 'Sam', 45, 10000, '2020-09-12');
INSERT INTO Employee VALUES(2, 'Joey', 21, 25000, '2021-09-12');
INSERT INTO Employee VALUES(3, 'Dee', 61, 30000, '2020-01-21');
INSERT INTO Employee VALUES(4, 'Halo', 37, 45000, '2019-05-06');
INSERT INTO Employee VALUES(5, 'Max', 26, 8000, '2021-11-01');
INSERT INTO Employee VALUES(6, 'Razor', 43, 50000, '2021-03-08');
INSERT INTO Employee VALUES(7, 'Finch', 39, 22000, '2021-06-15');
INSERT INTO Employee VALUES(8, 'Chief', 32, 19000, '2023-08-18');
INSERT INTO Employee VALUES(9, 'Don', 28, 25000, '2024-09-23');
INSERT INTO Employee VALUES(10, 'John', 27, 25000, '2024-09-23');

SELECT * FROM Employee;

-- Employee having slary greater than avg salary
SELECT * FROM Employee WHERE Salary > (SELECT AVG(SALARY) FROM Employee);

-- Count of people in each salary range
SELECT Salary, COUNT(Salary) AS 'People Count' FROM Employee GROUP BY Salary;

-- Show the employees with most number of similar salaries
WITH peopleInSalaryBracket AS (
	SELECT Salary, COUNT(Salary) AS PeopleCount FROM Employee GROUP BY Salary
)
SELECT * FROM Employee WHERE Salary IN (
	SELECT Salary FROM peopleInSalaryBracket WHERE PeopleCount IN (
		SELECT MAX(PeopleCount) FROM peopleInSalaryBracket
	)
);

-- Sum of salaries of employees grouped according to year
SELECT YEAR(JoiningDate), SUM(Salary) AS AccumulativeSalary FROM Employee GROUP BY YEAR(JoiningDate)

-- Employees from which year earn the least on avg
SELECT YEAR(JoiningDate), AVG(Salary) AS AvgSalary FROM Employee GROUP BY YEAR(JoiningDate)