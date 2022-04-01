package trove.qa.pageobject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.stream.IntStream;

public class TrovePageObject extends PageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    protected static final By TRACKING_CONSENT_NO_BUTTON = By.cssSelector("#consent-tracking button.decline");
    protected static final By PRIVACY_DISCLAIMER_CLOSE_BUTTON = By.cssSelector("#privacyDisclaimer > .secondary.privacy-disclaimer-accept");
    protected static final By IN_PROGRESS_SPINNER = By.cssSelector(".veil");
    protected static final By IN_PROGRESS_SPINNER_FIXED = By.cssSelector(".veil.position-fixed");

    // -----------------------------------------------------------------------------------------------------------------
    // COMMON ACTIONS
    protected void waitForInProgress() {
        $(IN_PROGRESS_SPINNER).waitUntilNotVisible();
    }

    protected void clearTrackingAndPrivacy() {
        // dismiss any tracking and/or privacy popups
        if ($(TRACKING_CONSENT_NO_BUTTON).isVisible())
            clickOn($(TRACKING_CONSENT_NO_BUTTON));
        if ($(PRIVACY_DISCLAIMER_CLOSE_BUTTON).isVisible())
            clickOn($(PRIVACY_DISCLAIMER_CLOSE_BUTTON));
    }

    protected void goTo(String url) {
        getDriver().get(url);
    }

    protected void refresh() {
        getDriver().navigate().refresh();
    }

    protected WebElement waitForRefresh(WebElement forElement) {
        WebElement element = new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.refreshed( ExpectedConditions.elementToBeClickable(forElement) ));
        return new WebDriverWait(getDriver(), 30).
                until( ExpectedConditions.visibilityOf(element) );
    }

    protected void waitForApp(int timeOutInSeconds) {
        waitForApp(Duration.ofSeconds(timeOutInSeconds));
    }

    protected void waitForApp(Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        }
        catch(InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }

    protected void scrollDown() {
        scrollDown(1);
    }

    protected void scrollDown(int howMany) {
        IntStream.range(0, howMany).forEach(i -> scrollBy(0, 250));
    }

    /**
     *
     * @param X  pixels to the right
     * @param Y  pixels to scroll down
     */
    protected void scrollBy(final int X, final int Y) {
        ((JavascriptExecutor) getDriver()).executeScript(String.format("window.scrollBy(%s, %s)", X, Y));
    }

    protected void hoverOver(WebElement element) {
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.visibilityOf(element));
        new Actions(getDriver()).moveToElement(element).perform();
    }

    protected void typeSlowlyOn(By by, String enter) {
        for (char c : enter.toCharArray()) {
            waitForRefresh(find(by));
            find(by).sendKeys(String.valueOf(c));
            waitForApp(Duration.ofMillis(50));
        }
    }

    protected void selectOptionOn(WebElement element, String byText) {
        // TODO: later add option to select byValue as needed
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.elementToBeClickable(element));
        new Select($(element)).selectByVisibleText(byText);
    }

    protected void typeOn(WebElement element, String enter) {
        typeOn(element, (CharSequence) enter);
    }

    protected void typeOn(WebElement element, CharSequence... charSequences) {
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.elementToBeClickable(element));
        $(element).type(charSequences);
    }

    protected String getTextOn(WebElement element) {
        new WebDriverWait(getDriver(),30).
                until(ExpectedConditions.visibilityOf($(element)));
        return $(element).getText();
    }


    public void clickOn(WebElement element) {
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.elementToBeClickable(element));
        try {
            $(element).click();
        }
        catch (StaleElementReferenceException | ElementClickInterceptedException ex) {
            waitForRefresh(element);
            $(element).click();
        }
    }
}
