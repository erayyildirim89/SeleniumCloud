package com.example.tests;

import com.example.pages.CheckboxEnum;
import com.example.pages.WidgetPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WidgetTests extends BaseTest {

    @Test
    public void ValidEntranceTest(){


        WidgetPage widget= new WidgetPage(driver);

        Assert.assertEquals("Thanks, I think test were succeeded", widget.fillWidget(CheckboxEnum.accept));

        status= true;

        System.out.println("ValidEntranceTest completed");
    }


    @Test
    public void RejectedTest() {


        WidgetPage widget= new WidgetPage(driver);

        Assert.assertEquals("Returned to first page", widget.fillWidget(CheckboxEnum.reject));

        status= true;

        System.out.println("RejectedTest completed");

    }

}
