package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> topMenuNames = Mydriver.findElements(By.cssSelector("#top-links a"));
        for (WebElement names : topMenuNames) {
            //System.out.println(names.getText());
            if (names.getText().equalsIgnoreCase(option)) {
                names.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        //Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        // Verify the text “Register Account”
        String expectedRegister = "Register Account";
        String actualRegister = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        Assert.assertEquals("Wrong Display", expectedRegister, actualRegister);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        // Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        // Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        // Verify the text “Returning Customer”
        String expectedReturning = "Returning Customer";
        String actualReturning = getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));

        Assert.assertEquals("Wrong Displayed", expectedReturning, actualReturning);
    }

    public void verifyThatUserRegisterAccountSuccessfully() {

        // Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //  Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        // Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Jack");

        //  Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Sparrow");

        //  Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), "JackSparroe797809@gmail.com");

        //  Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "0731525823");

        //  Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Prime123");

        //  Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "Prime123");

        //  Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']"));

        //  Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //  Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        // Verify the message “Your Account Has Been Created!”
        String expectedYour = "Your Account Has Been Created!";
        String actualYour = getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        Assert.assertEquals("Wrong Display", expectedYour, actualYour);

        //  Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        //  Click on My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));

        //  Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //  Verify the text “Account Logout”
        String expectedLogOut = "Account Logout";
        String actualLogOut = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals("Wrong Displayed", expectedLogOut, actualLogOut);

        //  Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

    }

    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        // Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        // Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        // Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "JackSparroe797809@gmail.com");

        // Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']']"), "Prime123");

        // Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        // Verify text “My Account”
        String expectedAccount = "My Account";
        String actualAccount = getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
        Assert.assertEquals("Wrong Display", expectedAccount, actualAccount);

        //Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        // Verify the text “Account Logout”
        String expectedLog = "Account Logout";
        String actualLog = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals("Wrong", expectedLog, actualLog);

        // Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
