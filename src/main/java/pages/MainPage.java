package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    WebDriver driver;
    Actions action;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By sigInFieldButton = By.xpath("//a[@href='/auth/sign-in']");
    By authEmail = By.xpath("//input[@name='email']");
    By authPassword = By.xpath("//input[@name='password']");
    By sigInButton = By.xpath("//button[text()='Sign In']");
    By menuButton = By.xpath("//span[@class='sc-fzXfPg cysWNI']");
    By subscriptionButton = By.xpath("//a[text()='Subscription']");
    By addExchangeButton = By.xpath("//button[text()='Add Exchange']");
    By protocolTypeButton = By.xpath("//div[@class='sc-LzLtn ioQLZb subscription-add-exchange-dialog-protocol-type']");
    By fix42 = By.xpath("//div[text()='FIX 4.2']");
    By fix43 = By.xpath("//div[text()='FIX 4.3']");
    By fix44 = By.xpath("//div[text()='FIX 4.4']");
    By fix50 = By.xpath("//div[text()='FIX 5.0']");
    By fix50SP1 = By.xpath("//div[text()='FIX 5.0 SP1']");
    By fix50SP2 = By.xpath("//div[text()='FIX 5.0 SP2']");
    By numberOfSessionsButton = By.xpath("(//div[@class='sc-AykKC izHnre subscription-add-exchange-dialog-sessions']//div[@class='sc-LzLwq WefCk'])[2]");
    By minusNumberOfSessionsButton = By.xpath("//div[@class='sc-AykKC izHnre subscription-add-exchange-dialog-sessions']//div[@class='sc-LzLwq WefCk']");
    By addButton = By.xpath("//button[text()='Add']");
    By typeHeader = By.xpath("//span[text()='Type:']/following::p[1]");
    By plusButton = By.xpath("(//div[@class='sc-LzLwq WefCk'])[2]");
    By payButton = By.xpath("//button[@class='sc-AykKE guaEXt subscription-confirm-button']");
    By proceedToCheckoutButton = By.xpath("//span[@class='cb-button__text']");
    By agreeToTermsOfService = By.xpath("//input[@id='tos_agreed']");
    By paySubscribeButton = By.xpath("//span[@class='cb-button__text']");
    By afterPayHeader = By.xpath("//a[text()='Go to exchanges']");
    By firstSubscription = By.xpath("//label[@class='sc-LzLrk idGNXe']/input");
    By deleteButton = By.xpath("//div[@class='sc-AykKC fzTngT subscription-restore-delete-buttons']//*[name()='svg']");
    By confirmButton = By.xpath("//button[text()='Confirm']");
    By anotherConfirmButton = By.xpath("//div[@class='sc-AykKC kUOSAq']/button[text()='Confirm']");
    By deleteHeader = By.xpath("//h2[text()='Session Expired']");
    By cancelButton = By.xpath("//button[text()='Cancel']");
    By subscriptionHeader = By.xpath("//h1[text()='Subscription']");
    By protocolSum = By.xpath("(//div[@class='sc-AykKC izHnre']/span)[2]");
    By sessionsSum = By.xpath("(//div[@class='sc-AykKC izHnre']/span)[4]");
    By totalSum = By.xpath("(//span[@class='sc-fzXfRa cIeZEc'])[2]");


    public MainPage clickOnSigInFieldButton() {
        driver.findElement(sigInFieldButton).click();
        return this;
    }

    public MainPage typeEmail(String email) {
        driver.findElement(authEmail).sendKeys(email);
        return this;
    }

    public MainPage typePassword(String password) {
        driver.findElement(authPassword).sendKeys(password);
        return this;
    }

    public MainPage clickOnSigInButton() {
        driver.findElement(sigInButton).click();
        return this;
    }

    public MainPage sigIn(String email, String password) {
        this.clickOnSigInFieldButton();
        this.typeEmail(email);
        this.typePassword(password);
        this.clickOnSigInButton();
        return new MainPage(driver);
    }

    public MainPage clickOnMenuButton() {
        driver.findElement(menuButton).click();
        return this;
    }

    public MainPage clickOnSubscriptionButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(subscriptionButton));
        return this;
    }

    public MainPage clickOnAddExchangeButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(addExchangeButton));
        return this;
    }

    public MainPage clickOnProtocolTypeButton() {
        driver.findElement(protocolTypeButton).click();
        return this;
    }

    public MainPage clickOnFix42() {
        driver.findElement(fix42).click();
        return this;
    }

    public MainPage clickOnFix43() {
        driver.findElement(fix43).click();
        return this;
    }

    public MainPage clickOnFix44() {
        driver.findElement(fix44).click();
        return this;
    }

    public MainPage clickOnFix50() {
        driver.findElement(fix50).click();
        return this;
    }

    public MainPage clickOnFix50SP1() {
        driver.findElement(fix50SP1).click();
        return this;
    }

    public MainPage clickOnFix50SP2() {
        driver.findElement(fix50SP2).click();
        return this;
    }


    public MainPage clickOnNumberOfSessionsButton() {
        driver.findElement(numberOfSessionsButton).click();
        return this;
    }

    public MainPage clickOnMinusNumberOfSessionsButton() {
        driver.findElement(minusNumberOfSessionsButton).click();
        return this;
    }

    public MainPage clickOnAddButton() {
        driver.findElement(addButton).click();
        return this;
    }


    public MainPage addFix42() {
        this.clickOnMenuButton();
        this.clickOnSubscriptionButton();
        this.clickOnAddExchangeButton();
        this.clickOnProtocolTypeButton();
        this.clickOnFix42();
        this.clickOnNumberOfSessionsButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.clickOnAddButton();
        return new MainPage(driver);
    }

    public MainPage addFix43() {
        this.clickOnMenuButton();
        this.clickOnSubscriptionButton();
        this.clickOnAddExchangeButton();
        this.clickOnProtocolTypeButton();
        this.clickOnFix43();
        this.clickOnNumberOfSessionsButton();
        this.clickOnNumberOfSessionsButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.clickOnAddButton();
        return new MainPage(driver);
    }

    public MainPage addFix44() {
        this.clickOnMenuButton();
        this.clickOnSubscriptionButton();
        this.clickOnAddExchangeButton();
        this.clickOnProtocolTypeButton();
        this.clickOnFix44();
        this.clickOnNumberOfSessionsButton();
        this.clickOnNumberOfSessionsButton();
        this.clickOnNumberOfSessionsButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.clickOnAddButton();
        return new MainPage(driver);
    }

    public MainPage addFix50() {
        this.clickOnMenuButton();
        this.clickOnSubscriptionButton();
        this.clickOnAddExchangeButton();
        this.clickOnProtocolTypeButton();
        this.clickOnFix50();
        this.clickOnNumberOfSessionsButton();
        this.clickOnNumberOfSessionsButton();
        this.clickOnMinusNumberOfSessionsButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.clickOnAddButton();
        return new MainPage(driver);
    }

    public MainPage addFix50SP1() {
        this.clickOnMenuButton();
        this.clickOnSubscriptionButton();
        this.clickOnAddExchangeButton();
        this.clickOnProtocolTypeButton();
        this.clickOnFix50SP1();
        this.clickOnNumberOfSessionsButton();
        this.clickOnNumberOfSessionsButton();
        this.clickOnMinusNumberOfSessionsButton();
        this.clickOnNumberOfSessionsButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.clickOnAddButton();
        return new MainPage(driver);
    }

    public MainPage addFix50SP2() {
        this.clickOnMenuButton();
        this.clickOnSubscriptionButton();
        this.clickOnAddExchangeButton();
        this.clickOnProtocolTypeButton();
        this.clickOnFix50SP2();
        this.clickOnNumberOfSessionsButton();
        this.clickOnNumberOfSessionsButton();
        this.clickOnMinusNumberOfSessionsButton();
        this.clickOnNumberOfSessionsButton();
        this.clickOnNumberOfSessionsButton();
        this.clickOnNumberOfSessionsButton();
        this.clickOnMinusNumberOfSessionsButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.clickOnAddButton();
        return new MainPage(driver);
    }

    public String getTypeHeader() {
        return driver.findElement(typeHeader).getText();
    }


    public MainPage clickOnPlusButton() {
        driver.findElement(plusButton).click();
        return this;
    }

    public MainPage clickOnPayButton() {
        driver.findElement(payButton).click();
        return this;
    }

    public MainPage clickOnProceedToCheckoutButton() {
        driver.findElement(proceedToCheckoutButton).click();
        return this;
    }

    public MainPage clickOnAgreeToTermsOfService() {
        driver.findElement(agreeToTermsOfService).click();
        return this;
    }

    public MainPage clickOnPaySubscribeButton() {
        driver.findElement(paySubscribeButton).click();
        return this;
    }

    public String getAfterPayHeader() {
        return driver.findElement(afterPayHeader).getText();
    }

    public MainPage highlightFirstSubscription() {
        action = new Actions(driver);
        WebElement we = driver.findElement(firstSubscription);
        action.moveToElement(we).click().build().perform();
        return this;
    }


    public MainPage clickOnConfirmButton() {
        driver.findElement(confirmButton).click();
        return this;
    }

    public MainPage clickOnAnotherConfirmButton() {
        driver.findElement(anotherConfirmButton).click();
        return this;
    }

    public MainPage clickOnCancelButton() {
        driver.findElement(cancelButton).click();
        return this;
    }

    public MainPage clickOnDeleteButton() {
        action = new Actions(driver);
        WebElement we2 = driver.findElement(deleteButton);
        action.moveToElement(we2).click().build().perform();
        this.clickOnConfirmButton();
        this.clickOnAnotherConfirmButton();
        return this;
    }

    public String getDeleteHeader() {
        return driver.findElement(deleteHeader).getText();
    }

    public MainPage getCancel() {
        this.clickOnMenuButton();
        this.clickOnSubscriptionButton();
        this.clickOnAddExchangeButton();
        this.clickOnCancelButton();
        return new MainPage(driver);
    }

    public String getSubscriptionHeader() {
        return driver.findElement(subscriptionHeader).getText();
    }

    public String getProtocolSum() {
        return driver.findElement(protocolSum).getText();
    }

    public String getSessionsSum() {
        return driver.findElement(sessionsSum).getText();
    }

    public String getTotalSum() {
        return driver.findElement(totalSum).getText();
    }

    public MainPage totalCost() {
        this.clickOnMenuButton();
        this.clickOnSubscriptionButton();
        this.clickOnAddExchangeButton();
        this.clickOnProtocolTypeButton();
        this.clickOnFix42();
        this.clickOnProtocolTypeButton();
        return new MainPage(driver);
    }
}
