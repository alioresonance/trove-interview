package trove.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class OrdersPage extends SightlyPageObject {

    final Logger LOG = Logger.getLogger(OrdersPage.class.getName());

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By TITLE_TEXT = By.cssSelector(".orders-title");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY
    public OrdersPage verifyOrderPageDisplayed() {
        new WebDriverWait(getDriver(), 20)
                .until(ExpectedConditions.textToBePresentInElementLocated(TITLE_TEXT, "Orders"));
        LOG.info("Verified Orders Page is displayed.");
        return this;
    }
}
