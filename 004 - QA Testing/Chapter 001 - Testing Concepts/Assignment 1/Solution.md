# Railway Ticket System

<details>
<summary>Question 1</summary><br>

> Groom the above user story and mention.
> - Any clarification required in user story acceptance criteria.
> - Any questions for the scope of the requirements.

```Answer
1. There are a few ambiguous cases
    a. What should we do if the user cancels on the journey date. Should we check if chart is prepared or decline flatly?
    b. Are the days at start and end of intervals included or excluded. for eg. if the user cancels 10 days before journey
       date should he get 35% refund or 20% refund?
2. Some questions could be.
    a. Is the user logged in? 
    b. Did he apply for refund scheme in the first place.
    c. Does the user even has a trip scheduled?
    d. Any condition under which a ticket cannot be cancelled. for eg chart prepared
```
</details>


<details>
<summary>Question 2</summary><br>

> Create all Test Coverage Scenarios for the above User Story.

```Answer
Check if User is logged in.
Does the user has a upcoming journey scheduled.
Has the user opted for the refund scheme.
Is the journey date passed or is it today?
If the date is in future then all boundary cases and equivalance cases.
```
</details>


<details>
<summary>Question 3</summary><br>

> Create Test Cases for the Refund Amount calculations for above user story.
> Refund amount should be calculated as follows:
> 1. If user cancels the ticket 60 days prior to journey date. - Refund 70% of amount
> 2. If user cancels the ticket b/n 60-30 days prior to journey date - Refund 50% of amount.
> 3. If user cancels the ticket between 30-10 days - Refund 35% of amount.
> 4. If user cancels the ticket between 10-1 days - Refund 20% of amount.

```Answer
The cancel button should not be available if there are no trips.
The cancel button should not be available if the trip has already passed.
Verify refund amount calculation is correct for all cases.
```
</details>


<details>
<summary>Question 4</summary><br>

> For our use case:
> 1. Use boundary Value analysis technique and provide the set of data which you will take for testing.
> 2. Use equivalence partitioning technique and create test data which you will use for testing.

```
Boundary Value Analysis Data
```
| BV Data    |
| ---------- |
| 0          |
| 1          |
| 10         |
| 11         |
| 30         |
| 31         |
| 60         |
| 61         |

```
Equivalance Partitioning Technique
```
| EP Data    |
| ---------- |
| 0          |
| 5          |
| 20         |
| 40         |
| 80         |

</details>
