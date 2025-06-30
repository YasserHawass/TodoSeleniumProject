package todo.testcases;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import todo.api.RegisterApi;
import todo.api.TasksApi;
import todo.base.BaseTest;
import todo.pages.LoginPage;
import todo.pages.NewTodoPage;
import todo.pages.TodoPage;
import todo.utils.ConfigUtils;

@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    @Story("Add Todo")
    @Test (description = "Should be able to add a new todo correctly")
    public void ShouldBeAbleToAddNewTodo(){

        RegisterApi registerApi= new RegisterApi();
        registerApi.register();
        /*LoginPage loginPage = new LoginPage(driver);
        String actualResult= loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .ClickOnPlusButton()
                .AddNewTask("Learn Selenium")
                .GetTodoText();*/
        //TodoPage todoPage = new TodoPage(driver);
        NewTodoPage newTodoPage= new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        String actualResult= newTodoPage
                .load()
                .addNewTask("Learn Selenium")
                .getTodoText();


        Assert.assertEquals(actualResult, "Learn Selenium");



    }

    @Story("Delete Todo")
    @Test (description = "Should be able to delete a todo correctly")
    public void ShouldBeAbleToDeleteTodo(){


        /*LoginPage loginPage = new LoginPage(driver);
        boolean isNoTodosDisplayed= loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .clickOnPlusButton()
                .addNewTask("Learn Selenium")
                .clickOnDeleteButton()
                .isNoTodosMessageDisplayed();*/
        RegisterApi registerApi= new RegisterApi();
        registerApi.register();

        TasksApi tasksApi= new TasksApi();
        tasksApi.addTask(registerApi.getToken());

        TodoPage todoPage= new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        boolean isNoTodosDisplayed= todoPage
                .load()
                .clickOnDeleteButton()
                .isNoTodosMessageDisplayed();

        Assert.assertTrue(isNoTodosDisplayed);

    }

}
