package todo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import todo.base.BasePage;
import todo.config.EndPoint;
import todo.utils.ConfigUtils;

public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css= "[data-testid=new-todo]")
    private WebElement NewTodoInput;

    @FindBy(css= "[data-testid=submit-newTask]")
    private WebElement NewTodoSubmit;


    @Step
    public NewTodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.NEW_TODO_ENDPOINT);
        return this;

    }

    @Step
    public TodoPage addNewTask(String item){
        NewTodoInput.sendKeys(item);
        NewTodoSubmit.click();
        return new TodoPage(driver);
    }

}
