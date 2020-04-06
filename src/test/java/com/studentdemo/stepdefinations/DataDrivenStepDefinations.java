package com.studentdemo.stepdefinations;

import com.studentdemo.steps.DataDrivenSteps;
import com.studentdemo.steps.FirstDesfinationSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.ArrayList;

public class DataDrivenStepDefinations {


    @Steps
    FirstDesfinationSteps firstDemoSteps;
    @Steps
    DataDrivenSteps dataDrivenSteps;
    @Given("user have a request for posting student data")

    public void givenUserHaveARequestForPostingStudentData() {
        firstDemoSteps.initializeRestBaseUri();
    }


    @When("user perform post operation on given request DataDriven way from external source: $studentTable")

    public void whenUserPerformPostOperationOnGivenRequestDataDrivenWayFromExternalSource(ExamplesTable studentTable) {


        studentTable.getRows().stream().forEach(row->{
            ArrayList<String> data = new ArrayList<>();
            data.add( row.get("firstName"));
            data.add( row.get("lastName"));
            data.add( row.get("email"));
            data.add( row.get("programme"));
            data.add( row.get("course"));
            dataDrivenSteps.performPostOperationUsingData(data);
            dataDrivenSteps.getStudentInfoByName();

        });





    }


    @Then("user will verify status code as 201")

    public void thenUserWillVerifyStatusCodeAs201() {
       dataDrivenSteps.validatePostOperationStatusCode(201);
    }

    @When("user perform put operation on Student id: $exampletable")

    public void whenUserPerformPutOperationOnStudentId(ExamplesTable studentTable) {
        studentTable.getRows().stream().forEach(row->{
            ArrayList<String> data = new ArrayList<>();
            data.add( row.get("firstName"));
            data.add( row.get("lastName"));
            data.add( row.get("email"));
            data.add( row.get("programme"));
            data.add( row.get("course"));
            dataDrivenSteps.performputOperation(data);


        });
    }

    @Then("Student record should update in the application")

    public void thenStudentRecordShouldUpdateInTheApplication() {
      dataDrivenSteps.checkupdatetOperation();
    }

    @Then("statusCode shpuld be $status")

    public void thenStatusCodeShpuldBe200(int status) {
        dataDrivenSteps.validatePostOperationStatusCode(status);
    }
    @When("user delete the student based on id $id")

    public void whenUserDeleteTheStudentBasedOnId(int id) {
    dataDrivenSteps.deleteStudent(id);
    }





}
