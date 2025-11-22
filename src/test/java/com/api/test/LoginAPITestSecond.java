package com.api.test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITestSecond {
    @Test(description = "Verify if login API is working...")

    public void loginTest() {
//        RestAssured.baseURI = "http://64.227.160.186:8080";
//        RequestSpecification x = RestAssured.given();
//        RequestSpecification y = given().header("Content-Type","application/json");
//        RequestSpecification z = y.body("{\"username\": \"vamsikrishna2001\" , \"password\" : \"Vamsi123\"}");
        Response response =  given()
                .baseUri("http://64.227.160.186:8080")
                .header("Content-Type","application/json")
                .body("{\"username\": \"vamsikrishna2001\" , \"password\" : \"Vamsi123\"}")
                .post("api/auth/login");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
