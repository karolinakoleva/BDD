Feature: Testing front and back-end pages

  @DashboardTests @SuccessfulLoginAsAdmin
  Scenario: successful login as admin
    Given the user is on Dashboard page
    When he enters "admin1" as username
    When he enters "parola123!" as admin's password
    When he clicks login button
    Then ensure the login is successful by username "AdminQAC22_First AdminQAC22_Last"

  @DashboardTests @SuccessfulLoginAsAdmin
  Scenario Outline:  successful login as admin
    Given the user is on Dashboard page
    When he enters "<username>" as username
    And he enters "<password>" as admin's password
    And he clicks login button
    Then ensure the login is successful by username "<expected_username>"
    Examples:
      | username | password   | expected_username |
      | admin    | parola123! | Milen Strahinski  |

  @LogOutTest   @DashboardTests
  Scenario: successful logout
    Given the user is on Dashboard page
    When he enters "admin1" as username
    When he enters "parola123!" as admin's password
    When he clicks login button
    Then ensure the login is successful by username "AdminQAC22_First AdminQAC22_Last"
    Then click on logout button
    Then ensure the logout is successful by text "Please enter your login details."

  @FrontEndTests @SuccessfulLogin
  Scenario: successful login
    Given the user is on OpenCart page
    When he clicks my account button
    And he clicks login
    And he enters "karolinakolevaa@abv.bg" as email address
    And he enters "karolina12345" as password
    And he clicks login button in order to login
    Then ensure the login is successful by text "My Account"

    @RegisterTest   @FrontEndTests
    Scenario: successful register
      Given the user is on OpenCart page
      When he clicks my account button in order to register
      And he clicks register button
      And he enters "Karolina" as first name
      And he enters "Koleva" as last name
      And he enters email address
      And he enters "08888888888" as telephone
      And he enters "karolina12345" as password
      And he enters "karolina12345" as confirmation password
      And he clicks agree button
      And he clicks continue button
      Then ensure he registered successfully by message
      """
Your Account Has Been Created!
Congratulations! Your new account has been successfully created!
You can now take advantage of member privileges to enhance your online shopping experience with us.
If you have ANY questions about the operation of this online shop, please e-mail the store owner.
A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.
Continue
      """

  @UnsuccessfulRegisterTest   @FrontEndTests
  Scenario: unsuccessful register
    Given the user is on OpenCart page
    When he clicks my account button in order to register
    And he clicks register button
    And he enters "Karolina" as first name
    And he enters "Koleva" as last name
    And he enters "karolinakolevaa@abv.bg" as email address in order to register
    And he enters "08888888888" as telephone
    And he enters "karolina12345" as password
    And he enters "karolina12345" as confirmation password
    And he clicks agree button
    And he clicks continue button
    Then ensure he didn't register successfully by message "Warning: E-Mail Address is already registered!"

@AddToCartTest   @FrontEndTests
Scenario: add to cart camera Nikon
  Given the user is on OpenCart page
  When he clicks camera button
  And he clicks Nikon camera button
  And he clicks add to cart button
  And he clicks cart button
  And he clicks checkout button
  Then ensure he added to cart camera Nikon by message "Checkout"

  @AddToWishListTest   @FrontEndTests
  Scenario: add iPhone to wish list
    Given the user is on OpenCart page
    When he clicks add to wish list button
    And he clicks on wish list button
    And he enters "karolinakolevaa@abv.bg" as email address
    And he enters "karolina12345" as password
    And he clicks login button in order to login
    Then ensure the login is successful by text "My Account"
    Then ensure he added iPhone to wish list by title "My Wish List"

