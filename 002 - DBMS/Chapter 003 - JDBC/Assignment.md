# Problem Statement
Prerequisites : StoreFront application database in MySQL (done in DBMS sessions/assignments)

### Task 1:
Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user which are in shipped state. Orders should be sorted by order date column in chronological order.

### Task 2:
Insert five or more images of a product using batch insert technique.

### Task 3:
Delete all those products which were not ordered by any Shopper in last 1 year. Return the number of products deleted.

### Task 4:
Select and display the category title of all top parent categories sorted alphabetically and the count of their child categories.

Note:
- All the database queries should be at one place. 
- Result should be wrapped in POJOs.
- Proper Exception handling.
- Good to create helper class for querying the database and wrapping the results.
