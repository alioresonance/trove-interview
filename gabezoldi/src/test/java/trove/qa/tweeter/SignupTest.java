package trove.qa.tweeter;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import trove.qa.BaseTest;
import trove.qa.model.common.User;
import trove.qa.model.usertype.QAUser;
import trove.qa.steps.SignupSteps;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("signup"),
})
public class SignupTest extends BaseTest {

    @Managed WebDriver driver;
    @Steps SignupSteps user;

    @Title("User can signup")
    @Test
    public void should_be_able_to_signup() {
        final User NEW_USER = QAUser.firstTimeUser();
        LOGGER.info("Signup as: " + NEW_USER);
        user
                .starts_on_the_tweeter_page()
                .signup_as(NEW_USER)
                .should_see_success_confirmation_message();
    }

}