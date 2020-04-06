package com.studentdemo.steps;


import com.studentdemo.restoprations.DataDrivenOperations;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;


public class DataDrivenSteps {

    public DataDrivenOperations dataDrivenOperations;
    ValidatableResponse validatableResponse;
    public String studentName;
    static int idnum;
    @Step
    public void performPostOperationUsingData(ArrayList<String> studentData){
        studentName=studentData.get(0);
       validatableResponse=dataDrivenOperations.createStudent(studentData);
    }
    @Step
    public void getStudentInfoByName(){
       HashMap<String,Object> value= dataDrivenOperations.getStudentInfoByFirstName(studentName);
        idnum=(int)value.get("id");
        System.out.println(idnum);
        System.out.println(value+"san");
    }

    @Step
    public void validatePostOperationStatusCode(int code){
        System.out.println(validatableResponse.extract().statusCode());

    validatableResponse.statusCode(code);
    }

    @Step
    public void performputOperation(ArrayList<String> data){
        System.out.println(idnum);
        validatableResponse =dataDrivenOperations.updateStudent(data,idnum);


    }
    @Step
    public void checkupdatetOperation(){
        System.out.println(idnum+" "+validatableResponse);
        validatableResponse = dataDrivenOperations.getStudentInfoById(idnum);
        System.out.println(validatableResponse.extract().path("firstName").toString());
    }

    @Step
    public void deleteStudent(int studentID){
        validatableResponse=dataDrivenOperations.deleteSelectedStudent(studentID);
    }
}
