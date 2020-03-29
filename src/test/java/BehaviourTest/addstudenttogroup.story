Scenario: when a student joins a group, it's inGroup flag is set to true

Given a student that is not yet in a group
When the student joins a group
Then the student inGroup status should be true