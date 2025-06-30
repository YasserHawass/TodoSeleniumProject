package todo.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import todo.base.BaseTest;
import todo.pages.LoginPage;
import todo.utils.ConfigUtils;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login with Email and Password")
    @Description("It will login by filling the email and password and navigate to the todo page")
    @Test(description = "Test the login functionality using email and password")

    public void shouldBeAbleToLoginWithEmailAndPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcomeDisplayed=
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .isWelcomeMessageDisplayed();

        Assert.assertTrue(isWelcomeDisplayed);

    }
}
