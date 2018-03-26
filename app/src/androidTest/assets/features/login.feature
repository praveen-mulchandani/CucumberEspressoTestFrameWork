Feature: SignUp
    Perform login on email and password are inputted

    Scenario Outline: Input email and password in wrong format
        Given I have a SignUpActivity
        When I input email <email>
        And I input password "<password>"
        And I press submit button
        Then I should see error on the <view>

    Examples:
        | email | password  | view  |
        | test  | lemoncake | email |
        | test@test.com || password |


    Scenario Outline: Input email and password in correct format
        Given I have a SignUpActivity
        When I input email <email>
        And I input password "<password>"
        And I press submit button
        Then I should <see> auth error

    Examples:
        | email              | password   | see   |
        | praveenm@test.com | praveenm   | true  |
        | praveen@test.com | praveen  | false |
        | piyush@test.com    | piyushk    | true  |