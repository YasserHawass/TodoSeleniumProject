package todo.testcases;

import todo.api.RegisterApi;

public class Dummy3 {
    public static void main(String[] args){
        RegisterApi registerApi= new RegisterApi();
        registerApi.register();

        System.out.println(registerApi.getToken());
        System.out.println(registerApi.getUserId());
        System.out.println(registerApi.getFirstName());



    }
}
