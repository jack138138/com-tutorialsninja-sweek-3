package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class TopMenuTest extends Utility {
    String MyUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp()
    {
        openBrowser(MyUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        //Mouse hover on “Desktops” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));

        //all selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");

        //Verify the text ‘Desktops’
        String expectedDesktop = "Desktops";
         String actualDesktop = getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']")) ;
        Assert.assertEquals("Wrong Desktop", expectedDesktop, actualDesktop);

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals("Laptops & Notebooks", getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']")));
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        //Mouse hover on “Components” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Components']"));

        //call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");

        //Verify the text ‘Components’
        Assert.assertEquals("Components", getTextFromElement(By.xpath("//h2[normalize-space()='Components']")));
    }

    @After
    public void closeBrowser() {
        Mydriver.close();

    }

}
