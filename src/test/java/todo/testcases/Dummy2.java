package todo.testcases;

import io.restassured.response.Response;
import todo.objects.User;

import static io.restassured.RestAssured.given;

public class Dummy2 {
    public static void main(String[] args){
      /* String requestBody = "{\n" +
               "    \"email\":\"test8@ro7.com\",\n" +
               "    \"firstName\":\"test\",\n" +
               "    \"lastName\":\"test\",\n" +
               "    \"password\":\"Test123!\"\n" +
               "}"; */
        User user = new User("Toqa","test", "test12@example.com","Test123!");

        Response response = given()
                .baseUri("https://todo.qacart.com/")
                .header("Content-Type", "application/json")
                .body(user)
        .when()
                .post("/api/v1/users/register")
        .then()
                //.log().all()
                .extract().response();

        String accessToken = response.path("access_token");
        response.cookies();

        System.out.println(accessToken);

        //Given -> request
        //When -> type of request and endpoint
        //Then -> all things related to the response

    }
}
