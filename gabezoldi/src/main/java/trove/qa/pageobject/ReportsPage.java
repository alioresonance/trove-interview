package trove.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import trove.qa.model.report.ReportSelection;
import trove.qa.model.report.inputs.AdditionalColumns;
import trove.qa.model.report.inputs.Granularity;
import trove.qa.model.report.inputs.TimePeriod;

public class ReportsPage extends SightlyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By REPORTS_TITLE_TEXT = By.cssSelector(".reports-title");

    private static final By LIVE_TAB = By.xpath("//a[contains(.,'Live')]");
    private static final By ALL_TAB = By.xpath("//a[contains(.,'All')]");

    private static final By SEARCH_INPUT = By.cssSelector("#reports-list-main-content > .search-container .search-input");
    private static final By REPORT_TABLE_ROWS = By.cssSelector(".tr.data-row");
    private static final By TABLE_COL_CHECKBOX = By.cssSelector("input[type='checkbox']");

    private static final By CREATE_REPORT_BUTTON = By.xpath("//span[contains(.,'Create Report')]");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public ReportsPage clickALLTab() {
        new WebDriverWait(getDriver(), 20)
                .until(ExpectedConditions.elementToBeClickable(ALL_TAB));
        $(ALL_TAB).click();
        return this;
    }

    public ReportsPage search(String term) {
        new WebDriverWait(getDriver(), 20)
                .until(ExpectedConditions.visibilityOf($(SEARCH_INPUT)));
        $(SEARCH_INPUT).sendKeys(term);
        return this;
    }

    public ReportsPage selectTheFirstOrderName() {
        new WebDriverWait(getDriver(), 20)
                .until(ExpectedConditions.visibilityOf($(REPORT_TABLE_ROWS)));
        selectCheckbox(
                getDriver().findElements(REPORT_TABLE_ROWS).get(0).findElement(TABLE_COL_CHECKBOX)
        );
        return this;
    }

    public ReportsPage selectCheckbox(WebElement element) {
        if (!element.isSelected())
            element.click();
        return this;
    }

    public ReportsPage unselectCheckbox(WebElement element) {
        if (element.isSelected())
            element.click();
        return this;
    }

    public ReportsPage createReport(ReportSelection reportSelection, Granularity granularity, AdditionalColumns additionalColumns, TimePeriod timePeriod) {
        new WebDriverWait(getDriver(), 20)
                .until(ExpectedConditions.elementToBeClickable(CREATE_REPORT_BUTTON));
        $(CREATE_REPORT_BUTTON).click();
        new ReportGeneratorPage()
                .select(reportSelection)
                .select(granularity)
                .select(additionalColumns)
                .select(timePeriod)
                .runReport();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY
    public ReportsPage verifyReportsPageDisplayed() {
        new WebDriverWait(getDriver(), 20)
                .until(ExpectedConditions.textToBePresentInElementLocated(REPORTS_TITLE_TEXT, "Reports"));
        return this;
    }
}