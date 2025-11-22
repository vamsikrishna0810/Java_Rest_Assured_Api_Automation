package com.api.test;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITestThrid {

    @Test(description = "Verify if login API is working...")

    public void loginTest() {
        LoginRequest loginRequest= new LoginRequest("vamsikrishna2001","Vamsi123");
        AuthService authService = new AuthService();
        Response response= authService.login(loginRequest);
        System.out.println(response.asPrettyString());

        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

       Assert.assertTrue(loginResponse.getToken() != null);
       Assert.assertNotNull(loginResponse.getEmail());
    }
}
