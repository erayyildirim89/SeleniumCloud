package com.example.tests;

import com.example.pages.CheckboxEnum;
import com.example.pages.WidgetPage;
import org.testng.Assert;
import org.testng.annotations.Test;

//TEST CLASS WHICH INHERITED BY BASE TEST CLASS
public class WidgetTests extends BaseTest {

    @Test
    public void ValidEntranceTest(){

        //PAGE OBJECT CREATION
        WidgetPage widget= new WidgetPage(driver);

        //TESTNG ASSERTION
        Assert.assertEquals("Thanks, I think test were succeeded", widget.fillWidget(CheckboxEnum.accept));

        status= true;

        System.out.println("ValidEntranceTest completed");
    }


    @Test
    public void RejectedTest() {

        //PAGE OBJECT CREATION
        WidgetPage widget= new WidgetPage(driver);

        //TESTNG ASSERTION
        Assert.assertEquals("Returned to first page", widget.fillWidget(CheckboxEnum.reject));

        status= true;

        System.out.println("RejectedTest completed");

    }

}
