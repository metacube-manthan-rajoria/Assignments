# Problem Statement
As a railway user, I should get an option to cancel the tickets, so that user can cancel the ticket
and get refund.
Acceptance Criteria:
- A new button with Label “Cancel Ticket” should be displayed for cancelling the ticket.
- Button should not be displayed for those tickets for which journey date is previous than
current date.
- Refund amount should be calculated as follows:
    - If user cancels the ticket 60 days prior to journey date - Refund 70% of amount
    - If user cancels the ticket b/n 60-30 days prior to journey date - Refund 50% of amount.
    - If user cancels the ticket between 30-10 days - Refund 35% of amount.
    - If user cancels the ticket between 10-1 days - Refund 20% of amount.
- User should get an email for successful cancellation.

### Questions
```Q1
Question 1. Groom the above user story and mention :
1. Any clarification required in user story acceptance criteria.
2. Any questions for the scope of the requirements.
```

```Q2
Question 2. Create all Test Coverage Scenarios for the above User Story.
```

```Q3
Question 3. Create Test Cases for the Refund Amount calculations for above user story.
Refund amount should be calculated as follows:
1. If user cancels the ticket 60 days prior to journey date. - Refund 70% of amount
2. If user cancels the ticket b/n 60-30 days prior to journey date - Refund 50% of amount.
3. If user cancels the ticket between 30-10 days - Refund 35% of amount.
4. If user cancels the ticket between 10-1 days - Refund 20% of amount.
```

```Q4
Question 4. For our use case:
1. Use boundary Value analysis technique and provide the set of data which you will take for testing.
2. Use equivalence partitioning technique and create test data which you will use for testing.
```

##### NOTE: Provide the data in tabular format for above question