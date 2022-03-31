package trove.qa.steps;

import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import trove.qa.model.common.Expected;
import trove.qa.model.common.User;
import trove.qa.model.report.ReportSelection;
import trove.qa.model.report.inputs.AdditionalColumns;
import trove.qa.model.report.inputs.Granularity;
import trove.qa.model.report.inputs.TimePeriod;
import trove.qa.pageobject.LoginPage;
import trove.qa.pageobject.NavigationPage;
import trove.qa.pageobject.OrdersPage;
import trove.qa.pageobject.ReportsPage;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CreateReportSteps extends AbstractSteps {

    ReportsPage reportsPage;

    EnvironmentVariables environmentVariables;

    // -----------------------------------------------------------------------------------------------------------------
    // STEPS
    public CreateReportSteps starts_on_the_reports_page(User forThisUser) {
        Expected.user = forThisUser;

        /*
         * below looks different just to give you different flavors of invocation methods;
         * I do prefer Fluent method style LoginPage.enterEmail().enterPassword().clickLogIn();
         */
        // static
        new LoginPage() {{
            login(forThisUser);
        }};

        // constructor
        new OrdersPage().verifyOrderPageDisplayed();
        new NavigationPage().gotoReports();

        // declaration
        reportsPage.verifyReportsPageDisplayed();


        String baseUrl = ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(environmentVariables);
        return this;
    }

    public CreateReportSteps creates_a_report_for_order_name(String orderName) {
        Expected.orderName = orderName;
        new File(getDownloadedReportWith(orderName)).delete();
        reportsPage
                .clickALLTab()
                .search(orderName)
                .selectTheFirstOrderName()
                .createReport(
                        ReportSelection.PERFORMANCE_DETAIL_REPORT,
                        Granularity.DAILY,
                        AdditionalColumns.NONE,
                        TimePeriod.ALL_TIME
                );
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // ASSERTIONS
    public CreateReportSteps should_see_in_downloaded_report(String expectedCSVLineItem) {
        List<String> actualDownloadReport = xslxToCSV(getDownloadedReportWith(Expected.orderName));
        assertThat(actualDownloadReport.contains(expectedCSVLineItem)).as("CSV Line Item not found: " + expectedCSVLineItem)
                .isTrue();
        return this;
    }

    public CreateReportSteps should_not_see_in_downloaded_report(String unexpectedCSVLineItem) {
        List<String> actualDownloadReport = xslxToCSV(getDownloadedReportWith(Expected.orderName));
        assertThat(actualDownloadReport.contains(unexpectedCSVLineItem)).as("CSV Line Item found: " + unexpectedCSVLineItem)
                .isFalse();
        return this;
    }

    public void should_see_that_success_alert_says(String expectedPlaceholderText) {
        //assertThat(todoListPage.placeholderText()).isEqualTo(expectedPlaceholderText);
    }

    public void should_see_that_that_following_items_are_marked_as_complete(String... items) {
        //asList(items).forEach(this::should_see_that_that_following_item_is_marked_as_complete);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // SUPPORTS
    private String getDownloadedReportWith(String theOrderName) {
        return String.format(
                "/Users/gzoldi/Downloads/PerformanceDetail-AdWords-%s-%s.xlsx",
                theOrderName.trim().replace(" ", "_"),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"))
        );
    }

    private List xslxToCSV(String filepath) {
        List<String> results = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(filepath)));
            XSSFSheet firstSheet = workbook.getSheetAt(0);
            // Loop through all the rows
            Iterator lines = firstSheet.iterator();
            while (lines.hasNext()) {
                Row row = (Row) lines.next();
                // Loop through all rows and add ","
                Iterator col = row.cellIterator();
                StringBuffer buf = new StringBuffer();
                while (col.hasNext()) {
                    Cell cell = (Cell) col.next();
                    if (buf.length() != 0) {
                        buf.append(",");
                    }
                    switch(cell.getCellType()) {
                        case STRING:    buf.append(cell.getStringCellValue());     break;
                        case NUMERIC:   buf.append(cell.getNumericCellValue());    break;
                        case BOOLEAN:   buf.append(cell.getStringCellValue());     break;
                        case ERROR:     buf.append(cell.getErrorCellValue());      break;
                        case FORMULA:   buf.append(cell.getCellFormula());         break;
                        case BLANK:
                        case _NONE:     buf.append("");    break;
                    }
                }
                results.add(buf.toString());
            }
            workbook.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
