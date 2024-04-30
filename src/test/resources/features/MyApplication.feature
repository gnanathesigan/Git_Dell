
Feature: Test the AU and CN DELL SITE

@AUtest
  Scenario Outline: Test AU Dell Site checking
    Given Open Chrome and load the url of "<ausite>"
    When checking the all plp and checking broken pages.
    Then mousehover on the mainmenu section.
    Given checking the PLP functionalities "name"
    When verify the warranty page and product details.
    Then checking the cart functionalities.
    Given checking the search page functionalities.
    When checking the PDP functionalities.
    And checking the Checkout guest functionalities values are "gnanathesigan1@gmail.com" and "FirstName" and "LastName" and "Address" and "City" and "1234" and "Ameex" and "8940928635" and "570"
    Then checking the Checkout login functionalities values are "Address" and "City" and "1234" and "Ameex" and "8940928635" and "570"
    
    
     Examples: 
      | ausite                              |
      | https://www.dell.com/en-au/outlet   |
      

      
@CNtest
  Scenario Outline: Test CN Dell site checking
    Given Open Chrome and load the china url of "<cnsite>"
    When checking the all china plp and checking broken pages.
    Then mousehover on the mainmenu section in china.
    Given checking the china PLP functionalities "name"
    When verify the china warranty page and product details.
    Then checking the china cart functionalities.
    Given checking the china search page functionalities.
    When checking the china PDP functionalities.
    And checking the china Checkout guest functionalities values are "gnanathesigan1@gmail.com" and "FirstName" and "LastName" and "Address" and "City" and "123456" and "8940928635" and "621" and "test invoice"
    Then checking the china Checkout login functionalities values are "Address" and "City" and "123456" and "8940928635" and "621" and "test invoice"
    
     Examples: 
      | cnsite                              |
      | https://dell.com/zh-cn/outlet       |          
    

@BRtest
  Scenario Outline: Test BR Dell site checking
  Given Open Chrome and load the brazil url of "<brsite>"
  When checking the all brazil plp and checking broken pages.
  
  
  Examples: 
      | brsite                              |
      | https://dell.com/pt-br/outlet       |
