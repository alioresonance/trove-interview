package trove.qa.pageobject.draft;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import trove.qa.pageobject.TrovePageObject;

public class DraftPage extends TrovePageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By TITLE_TEXT = By.cssSelector("#__next h1");
    private static final By NAME_INPUT = By.cssSelector("input[placeholder='Name']");
    private static final By EMAIL_ADDRESS_INPUT = By.cssSelector("input[placeholder='Email address']");
    private static final By SIGNUP_BUTTON = By.cssSelector("input[value='Signup']");
    private static final By DRAFTS_LIST = By.cssSelector("#__next > div > div > div > main > div");
    private static final By DELETE_BUTTON = By.cssSelector("#__next > div > div > div > div > button:nth-child(2)");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public DraftPage deleteDraftOnThePage(int indexOf) {
        final int OFFSET = 1;
        getDriver().findElements(DRAFTS_LIST).get(indexOf - OFFSET).click();
        getDriver().findElement(DELETE_BUTTON).click();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS
    public int getDraftsCount() {
        int count = 0;
        try {
            count = getDriver().findElements(DRAFTS_LIST).size();
        }
        catch(NoSuchElementException ex) {
            // skip return list empty
        }
        return count;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY
    public DraftPage verifyDraftsPageDisplayed() {
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.textToBe(TITLE_TEXT, "Drafts"));
        return this;
    }

}
