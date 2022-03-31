package trove.qa.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import trove.qa.model.common.Expected;
import trove.qa.model.common.User;

import java.time.Duration;

public class LoginPage extends SightlyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By EMAIL_ADDRESS_INPUT = By.cssSelector("input[placeholder='Your email address']");
    private static final By PASSWORD_INPUT = By.cssSelector("input[placeholder='Your password']");
    private static final By LOG_IN_BUTTON = By.xpath("//button[contains(.,'Log In')]");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public LoginPage login(User forThisUser) {
        Expected.user = forThisUser;
        openBrowser();
        verifyLoginPageDisplayed();
        enterCredentials(forThisUser);

        $(LOG_IN_BUTTON).click();
        return this;
    }

    public LoginPage openBrowser() {
        open();
        return this;
    }

    public LoginPage enterCredentials(User user) {
        $(EMAIL_ADDRESS_INPUT).sendKeys(user.getEmail());
        $(PASSWORD_INPUT).sendKeys(user.getPassword());
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
    //public AccountStatus statusOf(String todoItem) {
    //    WebElementFacade itemRow = inItemRowFor(todoItem);
    //    return isShownAsCompleted(itemRow) ? TodoStatus.Completed : TodoStatus.Active;
    //}

    //public List<String> displayedItems() {
    //    return findAll(".view").stream()
    //            .map(WebElementFacade::getText)
    //            .collect(Collectors.toList());
    //}

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY
    public LoginPage verifyLoginPageDisplayed() {
        withTimeoutOf(Duration.ofSeconds(20)).waitFor(LOG_IN_BUTTON);
        return this;
    }
}
