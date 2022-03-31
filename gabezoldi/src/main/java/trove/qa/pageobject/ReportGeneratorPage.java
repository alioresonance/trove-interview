package trove.qa.pageobject;

import org.assertj.core.util.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import trove.qa.model.report.ReportSelection;
import trove.qa.model.report.inputs.AdditionalColumns;
import trove.qa.model.report.inputs.Granularity;
import trove.qa.model.report.inputs.TimePeriod;

import java.io.File;

public class ReportGeneratorPage extends SightlyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By MODAL_TITLE_TEXT = By.cssSelector(".modal-name-container");

    private static final By PERF_SUMMARY = By.cssSelector("#performanceSummaryReportOption");
    private static final By PERF_DETAIL = By.cssSelector("#performanceDetailReportOption");
    private static final By REPORT_SELECTION_RADIO = By.cssSelector("input[type='radio']");

    private static final By GRANULARITY_DROPDOWN = By.cssSelector(".granularitySelect");
    private static final By ADDITIONAL_COLUMNS_DROPDOWN = By.cssSelector(".addColSelect");
    private static final By TIME_PERIOD_DROPDOWN = By.cssSelector(".timePeriodSelect");

    private static final By RUN_REPORT_BUTTON = By.cssSelector(".run-report-button");
    private static final By PROGRESS_MODAL = By.cssSelector(".v-dialog__content--active");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public ReportGeneratorPage select(ReportSelection reportType) {
        new WebDriverWait(getDriver(), 20)
                .until(ExpectedConditions.textToBePresentInElementLocated(MODAL_TITLE_TEXT, "Report Generator"));
        switch (reportType) {
            case PERFORMANCE_SUMMARY_REPORT:
                $(PERF_SUMMARY).findElement(REPORT_SELECTION_RADIO).click();
                break;
            case PERFORMANCE_DETAIL_REPORT:
                $(PERF_DETAIL).findElement(REPORT_SELECTION_RADIO).click();
                break;
            default:
                throw new RuntimeException("EnumConstantNotPresentException: " + reportType);
        }
        return this;
    }

    public ReportGeneratorPage select(Granularity option) {
        selectByVisibleText($(GRANULARITY_DROPDOWN), option.getName());
        return this;
    }

    public ReportGeneratorPage select(AdditionalColumns option) {
        selectByVisibleText($(ADDITIONAL_COLUMNS_DROPDOWN), option.getName());
        return this;
    }

    public ReportGeneratorPage select(TimePeriod option) {
        selectByVisibleText($(TIME_PERIOD_DROPDOWN), option.getName());
        return this;
    }

    public ReportGeneratorPage runReport() {
        cleanupReports();
        $(RUN_REPORT_BUTTON).click();
        waitForApp(2);
//        new WebDriverWait(getDriver(), 20)
//                .until(ExpectedConditions.invisibilityOf($(PROGRESS_MODAL)));
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY



    private ReportGeneratorPage selectByVisibleText(WebElement dropdown, String optionText) {
        new Select(dropdown).selectByVisibleText(optionText);
        return this;
    }

    private ReportGeneratorPage cleanupReports() {
        // delete previously downloaded report
        Files.delete(new File("~/Downloads/PerformanceDetail-AdWords-Ad_Group_Mapping*.xslx"));
        return this;
    }
}