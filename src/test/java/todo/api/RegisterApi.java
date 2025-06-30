package todo.api;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
import todo.config.EndPoint;
import todo.objects.User;
import todo.utils.ConfigUtils;
import todo.utils.UserUtils;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private List<io.restassured.http.Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;

    private String firstName;


    public String getToken(){
        return this.accessToken;
    }


    public String getUserId(){
        return this.userId;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public List<Cookie> getCookies(){
        return this.restAssuredCookies;
    }

    public void register(){
        //User user = new User("Toqa","test", "test14@example.com","Test123!");
        User user= UserUtils.generateRandomUser();

        Response response =
                given()
                        .baseUri(ConfigUtils.getInstance().getBaseUrl())
                        .header("Content-Type", "application/json")
                        .body(user)
                        .log().all()
                .when()
                        .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                        .log().all()
                        .extract().response();


        if(response.statusCode() != 201){
            throw new RuntimeException("something went wrong with the request");
        }

        restAssuredCookies= response.getDetailedCookies().asList();
        accessToken=response.path("access_token");
        userId = response.path("userID");
        firstName= response.path("firstName");

    }
}
