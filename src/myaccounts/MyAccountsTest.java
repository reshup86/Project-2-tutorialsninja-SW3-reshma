package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String menu) {
        String exp = String.format("//a[text()='%s']", menu);
        driver.findElement(By.xpath(exp)).click();
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //1.3Verify the text “Register Account”
        verifyText(By.xpath("//h1[text()='Register Account']"), "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        //2.1Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //2.2Call the method “selectMyAccountOptions”
        selectMyAccountOptions("Login");

        //2.3Verify the text “Returning Customer”.
        verifyText(By.xpath("//h2[text()='Returning Customer']"), "Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {

        //3.1Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //3.2Call the method “selectMyAccountOptions”
        selectMyAccountOptions("Register");

        //fill registration
        Thread.sleep(2000);
        sendTextToElement(By.id("input-firstname"), "Jane");
        sendTextToElement(By.id("input-lastname"), "Taylor");
        sendTextToElement(By.id("input-email"), "janet4@gmail.com");
        sendTextToElement(By.id("input-telephone"), "9436543213");
        sendTextToElement(By.id("input-password"), "jane12345");
        sendTextToElement(By.id("input-confirm"), "jane12345");
        clickOnElement(By.name("newsletter"));
        clickOnElement(By.name("agree"));
        clickOnElement(By.xpath("//input[@type='submit']"));
        verifyText(By.xpath("//h1[text()='Your Account Has Been Created!']"), "Your Account Has Been Created!");
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']"));
        //3.14 Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));
        selectMyAccountOptions("Logout");
        //3.16Verify the text “Register Account”
        verifyText(By.xpath("//h1[text()='Account Logout']"), "Account Logout");
        clickOnElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.2
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendTextToElement(By.id("input-email"),"janet4@gmail.com");

        //4.5 Enter Password
        sendTextToElement(By.id("input-password"),"jane12345");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@class='btn btn-primary']"));

    }

    @After
    public void teardown() {
        // closeBrowser();
    }

}
