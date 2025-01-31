> List the Advantages and Disadvantages of using LINQ over Stored Procedure.

### LINQ

Advantages

- Unified Query Language for different data sources(SQL, XML, Objects)
- Type checking while writing query
- Allows us to write queries directly in code
- Less Boilerplate code

Disadvantages

- Limited control and less options to optimize performance

### Stored Procedure

Advantages

- It provides additional level of security by not providing direct access to tables.
- Consumes less traffic
- Abstraction

Disadvantages

- They are language specific

> List the difference between First() and FirstOrDefault() operator.

### First
The first method gives us the first element in the enumerable list. if the list if empty it gives us error

### FirstOrDefault
The FirstOrDefault gives us the first element in the list. if the list is empty it gives us the default value for that data type