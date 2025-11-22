package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.SignUpRequest;
import com.api.models.requests.UpdateRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUserDataTest {
    @Test(description = "Verify if signup API is working...")
    public void UpdateUserDatatest(){

        LoginRequest loginRequest= new LoginRequest("vamsikrishna2001","Vamsi123");
        AuthService authService = new AuthService();
        Response response= authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

        UpdateRequest updateRequest = new UpdateRequest.Builder()
                .firstName("Vamsi")
                .lastName("Vamsi")
                .mobileNumber("9999999999")
                .email("vamsikrishna9@gmail.com")
                .build();

        UserProfileManagementService userProfileManagementService= new UserProfileManagementService();
        response = userProfileManagementService.updateProfile(updateRequest,loginResponse.getToken());
        System.out.println(response.asPrettyString());
//        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
//        System.out.println(userProfileResponse.getId()); "User registered successfully!" );
    }
}