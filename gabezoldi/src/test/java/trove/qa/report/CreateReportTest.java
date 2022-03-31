package trove.qa.report;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import trove.qa.BaseTest;
import trove.qa.model.common.User;
import trove.qa.model.usertype.QAUser;
import trove.qa.steps.CreateReportSteps;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("create-report"),
})
public class CreateReportTest extends BaseTest {

    @Managed WebDriver driver;
    @Steps
    CreateReportSteps qaTester;

    @Title("Create a report as QA Tester")
    @Test
    public void should_be_able_to_create_report() {
        final User AS_HIMSELF = QAUser.user();
        LOGGER.info("Create report as: " + AS_HIMSELF);
        qaTester
                .starts_on_the_reports_page(AS_HIMSELF)
                .creates_a_report_for_order_name("Ad Group Mapping")
                .should_see_in_downloaded_report("43999.0,TEST IOG,Ad Group Mapping,1.0,Instream,2.75122034E8,OBJECTIVE  - Online Visits + ADFORMAT - TrueView In-Stream Video CPV + LOCATIONS - United States_Cat Owners_:15,22795.0,0.0,0.0,47.0,0.00206185,0.0,11.85648177,270.268502,21945.0,21065.0,20529.0,20127.0")
                .should_see_in_downloaded_report("44001.0,TEST IOG,Ad Group Mapping,1.0,Instream,2.75122034E8,OBJECTIVE  - Online Visits + ADFORMAT - TrueView In-Stream Video CPV + LOCATIONS - United States_Cat Owners_:15,16241.0,0.0,0.0,26.0,0.00160088,0.0,12.35602413,200.674188,15662.0,15062.0,14694.0,14420.0")
                .should_see_in_downloaded_report("44009.0,TEST IOG,Ad Group Mapping,1.0,Instream,2.75122034E8,OBJECTIVE  - Online Visits + ADFORMAT - TrueView In-Stream Video CPV + LOCATIONS - United States_Cat Owners_:15,15587.0,0.0,0.0,20.0,0.00128312,0.0,9.8393551,153.366028,14920.0,14428.0,14132.0,13906.0")
                .should_not_see_in_downloaded_report("blah blah blah");
    }

}