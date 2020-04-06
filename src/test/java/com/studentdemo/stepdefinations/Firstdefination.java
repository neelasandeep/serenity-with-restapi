package com.studentdemo.stepdefinations;

import com.studentdemo.steps.FirstDesfinationSteps;
import net.thucydides.core.annotations.Steps;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.When;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Firstdefination{

    static Logger logger = Logger.getLogger(Firstdefination.class);
    @Steps
    FirstDesfinationSteps firstDemoSteps;
    @Given("user should have api link")
    public void givenUserShouldHaveApiLink(){
        firstDemoSteps.initializeRestBaseUri();
    }

    @When("user sends a get request and verifies status coe200 or not")
    public void whenUserSendsAGetRequestAndVerifiesStatusCoe200OrNot() {
    firstDemoSteps.checkStudentsListStatusCodeIs200();
    }
    @When("this is just check")

    public void whenThisIsJustCheck() {
      firstDemoSteps.check();
    }
    @Pending
    @When("user sends add get request and verifies status coe200 or not")
    public void whenUserSendsAGetRequestVerifiesStatusCoe200OrNot() {
        firstDemoSteps.checkStudentsListStatusCodeIs200();
    }

    @When("user sends adgd get request and verifies status coe200 or not")
    public void whenUserSendsAGetRequestVerifiesStatusCoe200Not() throws FileNotFoundException{
        File file=new File("E://file.txt");
        FileReader fr=new FileReader(file);
    }

    @When("user sends adgdd get request and verifies status coe200 or not")
    public void whenUserSendsAGetRequestVerifiesStatusCo200Not() {
        System.out.println(5/0);
    }

    @When("print datadriventest details from testdata/studentinfo.csv")
    public void whenUserSendsAGetRequestVerifffiesStatCo200Not()throws IOException {
    firstDemoSteps.printData();
           }



}

