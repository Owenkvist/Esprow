package pageTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTests {

    WebDriver driver;
    MainPage mainPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        driver = new ChromeDriver(options);
        driver.get("https://spa-dev.etpmarkets.com:3000/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        mainPage = new MainPage(driver);
        mainPage.sigIn("test.qa.1@esprow.com", "temporaryAccount");
    }


    //Checking the operation of the "plus" button (in the number of sessions), add, pay and delete the protocol Fix42
    @Test
    public void addPayAndDeleteFix42Exchange() {
        String typeHeader = mainPage.addFix42()
                .getTypeHeader();
        String afterPayHeader = mainPage.clickOnPlusButton()
                .clickOnPayButton()
                .clickOnProceedToCheckoutButton()
                .clickOnAgreeToTermsOfService()
                .clickOnPaySubscribeButton()
                .getAfterPayHeader();
        deleteSubscription();
        assertEquals("FIX 4.2", typeHeader);
        assertEquals("Go to exchanges", afterPayHeader);
    }


    //Checking the operation of the "plus" button (in the number of sessions, 2 clicks on plus), add, pay and delete the protocol Fix43
    @Test
    public void addPayAndDeleteFix43Exchange() {
        String typeHeader = mainPage.addFix43()
                .getTypeHeader();
        String afterPayHeader = mainPage.clickOnPlusButton()
                .clickOnPayButton()
                .clickOnProceedToCheckoutButton()
                .clickOnAgreeToTermsOfService()
                .clickOnPaySubscribeButton()
                .getAfterPayHeader();
        deleteSubscription();
        assertEquals("FIX 4.3", typeHeader);
        assertEquals("Go to exchanges", afterPayHeader);
    }

    //Checking the operation of the "plus" button (in the number of sessions, 3 clicks on plus), add, pay and delete the protocol Fix44
    @Test
    public void addPayAndDeleteFix44Exchange() {
        String typeHeader = mainPage.addFix44()
                .getTypeHeader();
        String afterPayHeader = mainPage.clickOnPlusButton()
                .clickOnPayButton()
                .clickOnProceedToCheckoutButton()
                .clickOnAgreeToTermsOfService()
                .clickOnPaySubscribeButton()
                .getAfterPayHeader();
        deleteSubscription();
        assertEquals("FIX 4.4", typeHeader);
        assertEquals("Go to exchanges", afterPayHeader);
    }

    //Checking the operation of the "plus" and "minus" button (in the number of sessions, 2 clicks on plus and 1 press on minus), add, pay and delete the protocol Fix50
    @Test
    public void addPayAndDeleteFix50Exchange() {
        String typeHeader = mainPage.addFix50()
                .getTypeHeader();
        String afterPayHeader = mainPage.clickOnPlusButton()
                .clickOnPayButton()
                .clickOnProceedToCheckoutButton()
                .clickOnAgreeToTermsOfService()
                .clickOnPaySubscribeButton()
                .getAfterPayHeader();
        deleteSubscription();
        assertEquals("FIX 5.0", typeHeader);
        assertEquals("Go to exchanges", afterPayHeader);
    }

    //Checking the operation of the "plus" and "minus" button (in the number of sessions, 3 clicks on plus and 1 press on minus), add, pay and delete the protocol Fix50SP1
    @Test
    public void addPayAndDeleteFix50SP1Exchange() {
        String typeHeader = mainPage.addFix50SP1()
                .getTypeHeader();
        String afterPayHeader = mainPage.clickOnPlusButton()
                .clickOnPayButton()
                .clickOnProceedToCheckoutButton()
                .clickOnAgreeToTermsOfService()
                .clickOnPaySubscribeButton()
                .getAfterPayHeader();
        deleteSubscription();
        assertEquals("FIX 5.0 SP1", typeHeader);
        assertEquals("Go to exchanges", afterPayHeader);
    }

    //Checking the operation of the "plus" and "minus" button (in the number of sessions, 5 clicks on plus and 2 press on minus), add, pay and delete the protocol Fix50SP2
    @Test
    public void addPayAndDeleteFix50SP2Exchange() {
        String typeHeader = mainPage.addFix50SP2()
                .getTypeHeader();
        String afterPayHeader = mainPage.clickOnPlusButton()
                .clickOnPayButton()
                .clickOnProceedToCheckoutButton()
                .clickOnAgreeToTermsOfService()
                .clickOnPaySubscribeButton()
                .getAfterPayHeader();
        deleteSubscription();
        assertEquals("FIX 5.0 SP2", typeHeader);
        assertEquals("Go to exchanges", afterPayHeader);
    }

    //Checking the operation of the "Cancel" button when adding a subscription
    @Test
    public void checkCancelButton() {
        String subscriptionHeader = mainPage.getCancel()
                .getSubscriptionHeader();
        assertEquals("SUBSCRIPTION", subscriptionHeader);
    }

    //Checking the correctness of the Total cost calculation when increasing and decreasing the number of subscriptions
    @Test
    public void checkTotalCost() {
        String firstCost = mainPage.totalCost()
                .getTotalSum();
        String firstSessionsSum = mainPage.clickOnProtocolTypeButton()
                .getSessionsSum();
        String firstProtocolSum = mainPage.getProtocolSum();
        mainPage.clickOnNumberOfSessionsButton();
        mainPage.clickOnNumberOfSessionsButton();
        String secondSessionsSum = mainPage.getSessionsSum();
        String secondProtocolSum = mainPage.getProtocolSum();
        mainPage.clickOnMinusNumberOfSessionsButton();
        String thirdSessionsSum = mainPage.getSessionsSum();
        String totalSum = mainPage.getTotalSum();
        assertEquals("$50.0", firstCost);
        assertEquals("$0.0", firstSessionsSum);
        assertEquals("$50.0", firstProtocolSum);
        assertEquals("$20.0", secondSessionsSum);
        assertEquals("$10.0", thirdSessionsSum);
        assertEquals(firstProtocolSum, secondProtocolSum);
        assertEquals("$60.0", totalSum);
    }


    public void deleteSubscription() {
        driver.get("https://spa-dev.etpmarkets.com:3000/");
        mainPage.clickOnSigInFieldButton();
        mainPage.clickOnMenuButton();
        mainPage.clickOnSubscriptionButton();
        mainPage.highlightFirstSubscription();
        mainPage.clickOnDeleteButton();
        String deleteHeader = mainPage.getDeleteHeader();
        assertEquals("Session Expired", deleteHeader);
    }

    @AfterEach
    public void tearDownEach() {
        driver.quit();
    }

}
