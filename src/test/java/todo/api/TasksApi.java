package todo.api;

import io.restassured.response.Response;
import todo.config.EndPoint;
import todo.objects.Task;
import todo.utils.ConfigUtils;

import static io.restassured.RestAssured.given;

public class TasksApi {
    public void addTask(String token){
        Task task  = new Task("Learn Selenium", false);
        Response response=
            given()
                .baseUri(ConfigUtils.getInstance().getBaseUrl())
                .header("Content-Type", "application/json")
                .body(task)
                .auth().oauth2(token)
            .when()
                .post(EndPoint.API_TASK_ENDPOINT)
            .then()
                .log().all()
                .extract().response();

        if(response.statusCode() != 201){
            throw new RuntimeException("something went wrong in adding the todo");
        }
    }
}
