Feature: Create Contact

  Scenario Outline: Successful Create Contact
    Given user request to add contact with "<name>" "<email>" "<message>"
    When user do action add contact
    Then user action create contact successful with "<code>"
    Examples:
      | code  |  name      |  email                |  message       |
      | 200   |  Name 1    |  email1@gmail.com     |  Message 1     |
      | 200   |  Name 2    |  email2@gmail.com     |  Message 2     |
      | 200   |  Name 3    |  email3@gmail.com     |  Message 3     |
      | 200   |  Name 4    |  email4@gmail.com     |  Message 4     |

  Scenario Outline: Create Contact Failed
    Given user request to add contact with "<name>" "<email>" "<message>"
    When user do action add contact
    Then user action create contact failed with "<code>"
    Examples:
      | code  |  name      |  email                |  message       |
      | 400   |            |  email1@gmail.com     |  Message 1     |
      | 400   |  Name 2    |                       |  Message 2     |
      | 400   |            |                       |  Message 3     |