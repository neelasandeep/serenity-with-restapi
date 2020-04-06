package com.studentdemo.restoprations;


import com.studentdemo.model.StudentClass;
import com.studentdemo.utils.ReuseableSpecifications;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.pages.PageObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataDrivenOperations extends PageObject {


    public ValidatableResponse createStudent(ArrayList<String> studentData) {
        List<String> courses = new ArrayList<String>();
        courses.add(studentData.get(4));
        StudentClass student = new StudentClass();
        student.setFirstName(studentData.get(0));
        student.setLastName(studentData.get(1));
        student.setEmail(studentData.get(2));
        student.setProgramme(studentData.get(3));
        student.setCourses(courses);

        return	SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec())
                .when()
                .body(student)
                .post()
                .then();

    }

    public ValidatableResponse updateStudent(ArrayList<String> updateData, int studentid){
        List<String> courses = new ArrayList<String>();
        courses.add(updateData.get(4));
        StudentClass student = new StudentClass();
        student.setFirstName(updateData.get(0));
        student.setLastName(updateData.get(1));
        student.setEmail(updateData.get(2));
        student.setProgramme(updateData.get(3));
        student.setCourses(courses);

        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec()).log().all()
                .when().body(student).put("/" + studentid).then();


    }

    public ValidatableResponse getStudentInfoById(int id){
        return SerenityRest.rest()
                        .given()
                        .when()
                        .get("/" + id).then();

    }
    public HashMap<String,Object> getStudentInfoByFirstName(String firstName){
        System.out.println(firstName);
        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";

        return	SerenityRest.rest().given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .extract()
                .path(p1+firstName+p2);
    }

    public ValidatableResponse deleteSelectedStudent(int studentId){
        return SerenityRest.rest().given().when().delete("/" + studentId).then();
    }
}
