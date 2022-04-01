package trove.qa.pageobject.draft;

import org.openqa.selenium.By;
import trove.qa.model.Draft;
import trove.qa.pageobject.TrovePageObject;

public class CreateDraftPage extends TrovePageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By TITLE_INPUT = By.cssSelector("input[placeholder='Title']");
    private static final By AUTHOR_INPUT = By.cssSelector("input[placeholder='Author (email address)']");
    private static final By CONTENT_INPUT = By.cssSelector("textarea[placeholder='Content']");
    private static final By CREATE_BUTTON = By.cssSelector("input[value='Create']");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public CreateDraftPage submit(Draft draft) {
        this
                .enterTitle(draft.getTitle())
                .enterAuthor(draft.getAuthor())
                .enterContent(draft.getContent())
                .clickCreate();
        return this;
    }

    public CreateDraftPage enterTitle(String title) {
        $(TITLE_INPUT).sendKeys(title);
        return this;
    }

    public CreateDraftPage enterAuthor(String author) {
        $(AUTHOR_INPUT).sendKeys(author);
        return this;
    }

    public CreateDraftPage enterContent(String content) {
        $(CONTENT_INPUT).sendKeys(content);
        return this;
    }

    public CreateDraftPage clickCreate() {
        $(CREATE_BUTTON).click();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS


    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY

}
