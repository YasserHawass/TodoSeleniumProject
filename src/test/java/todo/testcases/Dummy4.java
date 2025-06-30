package todo.testcases;

import io.restassured.http.Cookie;
//import org.openqa.selenium.Cookie;
//import io.restassured.http.Cookies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import todo.api.RegisterApi;
import todo.utils.ConfigUtils;
import java.util.List;

public class Dummy4 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        driver.manage().window().maximize();

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        /*List<io.restassured.http.Cookie> restAssuredCookies = registerApi.getCookies();

        for(io.restassured.http.Cookie cookie: restAssuredCookies){
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
            driver.manage().addCookie(seleniumCookie);
        }*/

        //Cookie accessTokenCookie = new Cookie("access_token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY4NWVjY2UyOTBhNGY0MDAxNDkzMmI2OCIsImZpcnN0TmFtZSI6InRlc3QiLCJsYXN0TmFtZSI6InRlc3QiLCJpYXQiOjE3NTEwNDMyOTh9.528xP7h-CEsh2IKitqNhqrESy146a0A9GEmRsoC2qbE");
        //Cookie firstNameCookie = new Cookie("firstName","test");

        //driver.manage().addCookie(accessTokenCookie);
        //driver.manage().addCookie(firstNameCookie);


        driver.get(ConfigUtils.getInstance().getBaseUrl());


        Thread.sleep(60000);

        driver.quit();
    }
}
