Feature: Select all items

  @allItems
  Scenario: User able to select all items
    Given I launch selectable items page
    Then I select the all items

  @dragAndDrop
  Scenario: Draggable item from one place to another place
      Given I launch draggable items page
      Then I dragged item one place to another place


    @elementdragging
  Scenario: Moving item within the limit
      Given I launch the application
      Then I moved required item
      And I click on Container Restricted tab
      Then i dragged element within the limit