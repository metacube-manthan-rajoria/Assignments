# Problem Statement

> [!Note]
> Using Typescript
> - Create employee, vehicle & pass class
> - Implement all possible OOP features

Assume a Metacube Parking System. 
An employee has to take a pass/ticket to enter into the parking system.
- Enter the employee’s details and register them and then it will collapse automatically by showing up the employee registration id.
    - Full Name
    - Gender
    - Email Id
    - Password
    - Confirm Password
    - Contact Number

```
Note - Only one field will be visible at a time. Like initially it will ask for a name
Enter your name (Once user enter his name hit enter like John Doe)
Change the text field into a radio button and label into “Hi John! Can i know your gender”
Then same with email, password, etc
For password if password is 
    1. Weak then change the border as red
    2. Normal then change to orange
    3. Strong then change to green
```

- Then show add vehicle form, enter the vehicle details with employee Id. Then it will also collapse automatically.
    - Name
    - Type
    - Vehicle Number
    - Employee Id
    - Identification (Textarea)

```
Note - Only one field will be visible at a time. Like initially it will ask for a name
Enter vehicle name (Once user enters a vehicle’s name hit enter)
Change the text field into a select field and label into “Which vehicle do you have ?”
Then same with email, password, etc
```

- Then show up daily, monthly & yearly passes price (according to the vehicle type you selected) and let the employee select the plan. Then show a button Get Pass, this will show up the pass price finally. 
- Let's say vehicle pricing in INR (daily, monthly, yearly) -
    - Cycle (5, 100, 500)
    - MotorCycle (10, 200, 1000)
    - Four Wheelers (20, 500, 3500)