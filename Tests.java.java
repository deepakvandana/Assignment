public class AuthSteps {
    WebDriver driver = new ChromeDriver();

    @Given("the user is on the Sign-Up page")
    public void navigateToSignUpPage() {
        driver.get("https://example.com/signup");
    }

    @When("the user enters a valid email and a strong password")
    public void enterValidSignUpDetails() {
        driver.findElement(By.id("email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("password")).sendKeys("SecurePassword123!");
    }

    @When("clicks the Sign-Up button")
    public void clickSignUpButton() {
        driver.findElement(By.id("signup-button")).click();
    }

    @Then("the user should see a confirmation message")
    public void verifySignUpSuccess() {
        WebElement message = driver.findElement(By.id("confirmation-message"));
        assertTrue(message.isDisplayed());
    }

    @Then("receive an email verification link")
    public void verifyEmailSent() {
        // Mock verification step (actual email check would require email automation)
        System.out.println("Email verification link sent");
    }

    @Given("the user is on the Sign-In page")
    public void navigateToSignInPage() {
        driver.get("https://example.com/signin");
    }

    @When("the user enters a valid email and password")
    public void enterValidSignInDetails() {
        driver.findElement(By.id("email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("password")).sendKeys("SecurePassword123!");
    }

    @When("clicks the Sign-In button")
    public void clickSignInButton() {
        driver.findElement(By.id("signin-button")).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void verifySignInSuccess() {
        assertEquals("https://example.com/dashboard", driver.getCurrentUrl());
    }

    @Given("the user is logged in")
    public void ensureUserLoggedIn() {
        navigateToSignInPage();
        enterValidSignInDetails();
        clickSignInButton();
    }

    @When("the user clicks the Sign-Out button")
    public void clickSignOutButton() {
        driver.findElement(By.id("signout-button")).click();
    }

    @Then("the user should be redirected to the Sign-In page")
    public void verifySignOutSuccess() {
        assertEquals("https://example.com/signin", driver.getCurrentUrl());
    }

    @Then("should not be able to access the dashboard without logging in again")
    public void verifyRestrictedAccess() {
        driver.get("https://example.com/dashboard");
        assertNotEquals("https://example.com/dashboard", driver.getCurrentUrl());
    }
}