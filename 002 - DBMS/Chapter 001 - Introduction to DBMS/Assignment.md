# Problem Statement

There is an Organization (StoreFront) that would like to go online for selling their products. We have the following information to build an application that meets the requirements:

- Application contains many Products.
- Categories will categorised the Products.
- Categories can be nested.
- A Product can fall into multiple Categories.
- A Product can have one or more Images.
- User can be a Shopper or Administrator.
- Shopper can place an order having one or more products.
- Shopper can shop only those products which are in stock.
- Shopper can have multiple Shipping Addresses.
- Independent items in an Order can be shipped, canceled or returned.

1. Identify the participating entities.
2. Identify the relations. 
3. Identify the key attributes. 
4. Draw the E-R diagram for the problem.

### Task 2
Explain Normalization techniques (along with an example) as discussed during Session.

Install and connect to MySQL

# Solutions

### Normalization

Normalization is used to minimize the redundancy from a relation or set of relations. It is also used to eliminate undesirable characteristics like Insertion, Update, and Deletion Anomalies.

- 1 NF
    - A relation will be 1NF if it contains an atomic value.
    - It states that an attribute of a table cannot hold multiple values. It must hold only single-valued attribute.
    - First normal form disallows the multi-valued attribute, composite attribute, and their combinations.
- 2 NF
    - In the 2NF, relational must be in 1NF.
    - In the second normal form, all non-key attributes are fully functional dependent on the primary key
- 3 NF
    - A relation will be in 3NF if it is in 2NF and not contain any transitive partial dependency.
    - 3NF is used to reduce the data duplication. It is also used to achieve the data integrity.
    - If there is no transitive dependency for non-prime attributes, then the relation must be in third normal form.
    - A relation is in third normal form if it holds atleast one of the following conditions for every non-trivial function dependency X → Y.
        - X is a super key.
        - Y is a prime attribute, i.e., each element of Y is part of some candidate key.
- BCNF
    - BCNF is the advance version of 3NF. It is stricter than 3NF.
    - A table is in BCNF if every functional dependency X → Y, X is the super key of the table.
    - For BCNF, the table should be in 3NF, and for every FD, LHS is super key.