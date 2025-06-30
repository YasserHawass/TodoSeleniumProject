package todo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import todo.base.BasePage;
import todo.config.EndPoint;
import todo.utils.ConfigUtils;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css= "[data-testid=welcome]")
    private WebElement WelcomeMessage;

    @FindBy(css= "[data-testid=add]")
    private WebElement AddButton;

    @FindBy(css = "[data-testid=todo-item]")
    private WebElement TodoItem;

    @FindBy(css="[data-testid=delete]")
    private WebElement DeleteButton;

    @FindBy(css="[data-testid=no-todos]")
    private WebElement NoTodosMessage;

    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }

    @Step
    public boolean isWelcomeMessageDisplayed (){

        return WelcomeMessage.isDisplayed();

    }

    @Step
    public NewTodoPage clickOnPlusButton(){
        AddButton.click();
        return new NewTodoPage(driver);
    }

    @Step
    public String getTodoText(){
         return TodoItem.getText();
    }

    @Step
    public TodoPage clickOnDeleteButton(){
        DeleteButton.click();
        return this;
    }

    @Step
    public boolean isNoTodosMessageDisplayed(){
        return NoTodosMessage.isDisplayed();
    }
}
