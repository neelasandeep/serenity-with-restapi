package com.studentdemo.steps;

import com.studentdemo.restoprations.FirstDemoOperations;
import com.studentdemo.utils.ExcelDataProvider;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;

import java.io.IOException;


public class FirstDesfinationSteps {

    FirstDemoOperations firstDemo;
   @Step("#act initialising maim uri")
   public void initializeRestBaseUri(){
       firstDemo.initializeRestBaseApi();
   }
    @Step("checking status code")
    public void checkStudentsListStatusCodeIs200(){
        Assert.assertEquals(200,firstDemo.getStatusCodeForStudentsList());
    }
    @Step("checking status code wrong")
    public void checkStudentsListStatusCodeIs500(){
        Assert.assertEquals(500,firstDemo.getStatusCodeForStudentsList());
    }
    @Title("this is how i check")
    @Step("checking status code wrong")
    public void check(){
        Assert.assertEquals(500,firstDemo.getStatusCodeForStudentsList());
    }

    @Step("checking status code wrong")
    public void printData() throws IOException{

        System.out.println(ExcelDataProvider.getdata("data"));

    }



}
