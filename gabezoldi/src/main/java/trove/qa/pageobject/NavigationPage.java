package trove.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage extends SightlyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By NAVBAR_ORDERS_ICON = By.cssSelector("#header-orders");
    private static final By NAVBAR_REPORTS_ICON = By.cssSelector("#header-reports");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public NavigationPage gotoOrders() {
        $(NAVBAR_ORDERS_ICON).click();
        return this;
    }

    public NavigationPage gotoReports() {
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(NAVBAR_REPORTS_ICON));
        $(NAVBAR_REPORTS_ICON).click();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY

}
