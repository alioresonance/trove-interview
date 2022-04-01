package trove.qa.drafts;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import trove.qa.BaseTest;
import trove.qa.model.draft.Draft;
import trove.qa.steps.DraftsSteps;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("create-draft"),
})
public class CreateDraftTest extends BaseTest {

    @Managed WebDriver driver;
    @Steps DraftsSteps user;

    @Title("User can create draft")
    @Test
    public void should_be_able_to_create_draft() {
        user
                .starts_on_the_tweeter_page()
                .creates_a_draft(Draft.getAny())
                .should_see_draft_count_increase();
    }

}