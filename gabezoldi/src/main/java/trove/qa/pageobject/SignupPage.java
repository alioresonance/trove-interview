package trove.qa.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import java.time.Duration;

public class SignupPage extends TrovePageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By NAME_INPUT = By.cssSelector("input[placeholder='Name']");
    private static final By EMAIL_ADDRESS_INPUT = By.cssSelector("input[placeholder='Email address']");
    private static final By SIGNUP_BUTTON = By.cssSelector("input[value='Signup']");
    private static final By CONFIRMATION_MESSAGE_TEXT = By.cssSelector(".signup.confirm");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public SignupPage enterName(String name) {
        $(NAME_INPUT).sendKeys(name);
        return this;
    }

    public SignupPage enterEmailAddress(String email) {
        $(EMAIL_ADDRESS_INPUT).sendKeys(email);
        return this;
    }

    public SignupPage clickSignup() {
        $(SIGNUP_BUTTON).click();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS
    public String getConfirmationMessage() {
        return $(CONFIRMATION_MESSAGE_TEXT).getText();
    }

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
    public SignupPage verifyTweeterPageDisplayed() {
        //withTimeoutOf(Duration.ofSeconds(20)).waitFor(TITLE_TEXT);
        return this;
    }
}
