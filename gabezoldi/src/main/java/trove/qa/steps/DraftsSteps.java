package trove.qa.steps;

import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;
import trove.qa.model.common.Expected;
import trove.qa.model.draft.Draft;
import trove.qa.pageobject.draft.CreateDraftPage;
import trove.qa.pageobject.draft.DraftPage;
import trove.qa.pageobject.TweeterPage;

import static org.assertj.core.api.Assertions.assertThat;

public class DraftsSteps extends AbstractSteps {

    TweeterPage tweeterPage;
    CreateDraftPage createDraftPage;
    DraftPage draftPage;

    EnvironmentVariables environmentVariables;

    // -----------------------------------------------------------------------------------------------------------------
    // STEPS
    public DraftsSteps starts_on_the_tweeter_page() {
        tweeterPage
                .openBrowser()
                .verifyTweeterPageDisplayed();
        String baseUrl = ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(environmentVariables);
        return this;
    }

    public DraftsSteps starts_on_the_drafts_page() {
        starts_on_the_tweeter_page();
        tweeterPage.gotoDrafts();
        draftPage.verifyDraftsPageDisplayed();
        return this;
    }

    public DraftsSteps creates_a_draft(Draft draft) {
        Expected.draft = draft;
        tweeterPage.clickCreateDraft();
        createDraftPage.submit(draft);
        return this;
    }

    public DraftsSteps deletes_first_draft_on_page() {
        draftPage.deleteDraftOnThePage(1);
        tweeterPage.gotoDrafts();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // ASSERTIONS
    public DraftsSteps should_see_draft_count_increase() {
        assertThat(draftPage.getDraftsCount()).as("Drafts count did not increase")
                .isGreaterThan(1);
        return this;
    }

    public DraftsSteps should_see_drafts_list_empty() {
        assertThat(draftPage.getDraftsCount()).as("Drafts count did not decrease")
                .isEqualTo(0);
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // SUPPORTS

}
