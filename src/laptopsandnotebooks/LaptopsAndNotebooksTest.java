package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

import java.time.Duration;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));

        //1.2 Click on “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        //1.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = Mydriver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText(" Default ");
        selectByVisibleTextFromDropDown(By.className("form-control"), "Price (High > Low)");
        select.selectByValue("https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");

        //1.4 Verify the Product price will arrange in High to Low order.
        List<WebElement> element1 = Mydriver.findElements(By.xpath("//p[@class= 'price']"));
        for (WebElement result : element1) {
            System.out.println(result.getText());
        }
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {

        // Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));

        // Click on “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        //Select Sort By "Price (High > Low)"
        WebElement dropDown = Mydriver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText(" Default ");
        selectByVisibleTextFromDropDown(By.className("form-control"), "Price (High > Low)");
        select.selectByValue("https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");


        //  Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
        Mydriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Verify the text “MacBook”
        String expectedMacbook = "MacBook";
        String actualMacBook = getTextFromElement(By.xpath("//h1[normalize-space()='MacBook']"));
        Assert.assertEquals("Wrong Msg Shown", expectedMacbook, actualMacBook);

        //Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Mydriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedSuccess = "Success: You have added MacBook to your shopping cart!";
        String actualSuccess = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Wrong Msg shown", expectedSuccess, actualSuccess);


        //Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));


        // Verify the text "Shopping Cart
        String expectedShopping = "Shopping Cart";
        String actualShopping = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("Wrong Msg shown", expectedShopping, actualShopping);

        //Verify the Product name "MacBook"
        String expectedProduct = "MacBook";
        String actualProduct = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]"));
        Assert.assertEquals("Wrong Displayed", expectedProduct, actualProduct);

        //  Change Quantity "2"
        Mydriver.findElement(By.xpath("//input[@class='form-control']")).clear();
        Mydriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        sendTextToElement(By.xpath("//input[@class='form-control']"), "2");

        // Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));


        // Verify the message “Success: You have modified your shopping cart!”
        String expectedCart = "Success: You have modified your shopping cart!";
        String actualCart = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Wrong Displayed", expectedCart, actualCart);

        // Verify the Total £737.45
        String expectedTotal = "£737.45";
        String actualTotal = getTextFromElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        Assert.assertEquals("Wrong Displayed", expectedTotal, actualTotal);

        // Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        // Verify the text “Checkout”
        String expectedCheckOut = "Checkout";
        String actualCheckOut = getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']"));
        Assert.assertEquals("Wrong Display", expectedCheckOut, actualCheckOut);

        // Verify the Text “New Customer”
        String expectedNew = "New Customer";
        String actualNew = getTextFromElement(By.id("//h2[normalize-space()='New Customer']"));

        Assert.assertEquals("New Customer", expectedNew, actualNew);

        // Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));


        // Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        // Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Jack");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Sparrow");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "JackSpawwor097689@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "9858658");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "Rua Dr. Albert");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "PO4 5RT");
        Mydriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement dropDown3 = Mydriver.findElement(By.xpath("//select[@id='input-payment-zone']"));
        Select select3 = new Select(dropDown3);
        select3.selectByVisibleText("Buckinghamshire");

        // Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        // Add Comments About your order into text area

        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Please Give order at PresentPerson");

        // Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@id='button-shipping-method']"));

        // Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-shipping-method']"));

        // Verify the message “Warning: Payment method required!”
        String expectedMethod = "Warning: Payment method required!";
        String actualMethod = getTextFromElement(By.xpath("//div[contains(text(), 'Warning: Payment method required!')]"));
        Assert.assertEquals(" Wrong Displayed", expectedMethod, actualMethod);
    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}
