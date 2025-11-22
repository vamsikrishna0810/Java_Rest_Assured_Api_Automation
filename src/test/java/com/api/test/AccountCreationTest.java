package com.api.test;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {
    @Test(description = "Verify if signup API is working...")
    public void createAccountTest(){
        SignUpRequest signUpRequest = new SignUpRequest.Builder().username("manoj2001")
                .firstName("Manoj")
                .lastName("Manu")
                .password("Manoj123")
                .mobileNumber("1234567899")
                .email("manojmanu2001@gmail.com")
                .build();
        AuthService authService = new AuthService();
        Response response = authService.signup(signUpRequest);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.asPrettyString(), "User registered successfully!" );
    }
}
