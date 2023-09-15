Feature: Check the opened main page and verify the price of the products in basket

  Background:
    Given User should be lands on home page with the supported url

    @price
    Scenario: User goes to home page, selects a random product and verifies the price of the product
      When  user verifies that the beymen image is appeared
      And user clicks to seach box
      And user gets the şort word from the excel file, from 1 row 1 column and enters from keyboard
      And user deletes the şort word from search box
      And user gets the gömlek word from the excel file, from 1 row 2 column and enters from keyboard
      And user selects a random product from the exhibited products
      And user writes the selected product's information and prize to txt file
      And user selects a random size from the size part
      And user clicks to sepete ekle button
      And user clicks to sepetim button
      Then user verifies that the price of the product on the product pace matches with the product price in the basket
      Then user verifies that the product pieces are two after increasing the nomber of product
      Then user verifies that the basket is empty after deleting the product


