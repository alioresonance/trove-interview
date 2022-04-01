package trove.qa.drafts;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import trove.qa.BaseTest;
import trove.qa.steps.DraftsSteps;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("delete-draft"),
})
public class DeleteDraftTest extends BaseTest {

    @Managed WebDriver driver;
    @Steps DraftsSteps user;

    @Title("User can delete draft")
    @Test
    public void should_be_able_to_delete_draft() {
        user
                .starts_on_the_drafts_page()
                .deletes_first_draft_on_page()
                .should_see_drafts_list_empty();
    }
}