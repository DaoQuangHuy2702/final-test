Feature: Create Post

  Scenario Outline: Successful Create Post
    Given user request to add post with "<title>" "<image>" "<content>" "<category>"
    When user do action add post
    Then user action create post successful with "<code>"
    Examples:
      | code  |  title     |  image          |  content       |  category     |
      | 200   |  Demo 1    |  ImageUrl 1     |  Content 1     |  ART          |
      | 200   |  Demo 2    |  ImageUrl 2     |  Content 2     |  MUSIC        |
      | 200   |  Demo 3    |  ImageUrl 3     |  Content 3     |  TECH         |
      | 200   |  Demo 4    |  ImageUrl 4     |  Content 4     |  TRAVEL       |

  Scenario Outline: Create Post Failed
    Given user request to add post with "<title>" "<image>" "<content>" "<category>"
    When user do action add post
    Then user action create post failed with "<code>"
    Examples:
      | code  |  title     |  image          |  content     |  category    |
      | 400   |            |  ImageUrl 1     |  Content 1   |  TECH        |