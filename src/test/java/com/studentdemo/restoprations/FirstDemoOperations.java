package com.studentdemo.restoprations;


import com.studentdemo.utils.Properties;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.pages.PageObject;

public class FirstDemoOperations extends PageObject {


    public void initializeRestBaseApi(){
        RestAssured.baseURI = Properties.BASEURI;
    }
    public int getStatusCodeForStudentsList(){
       return SerenityRest.rest()
                .given()
                .when()
                .get("/list")
                .then()
                .extract()
                .statusCode();


    }
}
