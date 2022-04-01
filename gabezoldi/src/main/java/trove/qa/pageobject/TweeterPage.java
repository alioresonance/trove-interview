package trove.qa.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class TweeterPage extends TrovePageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By TITLE_TEXT = By.cssSelector("#__next h1");
    private static final By DRAFTS_LINK = By.linkText("Drafts");
    private static final By SIGNUP_BUTTON = By.linkText("Signup");
    private static final By CREATE_DRAFT_BUTTON = By.linkText("+ Create draft");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public TweeterPage openBrowser() {
        open();
        verifyTweeterPageDisplayed();
        return this;
    }

    public TweeterPage gotoDrafts() {
        getDriver().get("http://localhost:3000/drafts");
        return this;
    }

    public TweeterPage clickSignup() {
        $(SIGNUP_BUTTON).click();
        return this;
    }

    public TweeterPage clickCreateDraft() {
        $(CREATE_DRAFT_BUTTON).click();
        return this;
    }

    private boolean isShownAsCompleted(WebElementFacade itemRow) {
        return itemRow.find(By.tagName("label")).getCssValue("text-decoration").contains("line-through");
    }

    public void toggleAll() {
        evaluateJavascript("arguments[0].click();",$ ("#toggle-all"), $("."));
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS


    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY
    public TweeterPage verifyTweeterPageDisplayed() {
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.textToBe(TITLE_TEXT, "Tweeter"));
        return this;
    }
}
