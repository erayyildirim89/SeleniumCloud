package com.example.pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

public class WidgetPage {

    WebDriver driver;

    @FindBy(xpath="//div[@class='widget-button']")
    WebElement widgetBtn;

    @FindBy(xpath="//*[contains(text(),'Next Page')]")
    WebElement nextPageBtn;

    @FindBy(xpath="//*[contains(text(),'Submit')]")
    WebElement submitBtn;

    @FindBy(xpath="//*[contains(@placeholder,'Click here')]")
    WebElement commentTxt;

    @FindBy(xpath="//span[contains(text(),'I have read and accept')]")
    WebElement acceptRadioBtn;

    @FindBy(xpath="//span[contains(text(),'I don')]")
    WebElement rejectRadioBtn;

    @FindBy(xpath="//span[contains(text(),'Pisano')]")
    WebElement pisanoCheckbox;

    @FindBy(xpath="//span[contains(text(),'Others')]")
    WebElement othersCheckbox;

    @FindBy(xpath="//input[@type='email']")
    WebElement emailTxt;

    @FindBy(xpath="//input[@type='text']")
    WebElement nameTxt;

    @FindBy(xpath="//input[@type='tel']")
    WebElement phoneTxt;

    @FindBy(xpath="//div[@class='label']/div")
    WebElement validationMessage;

    @FindBy(xpath="//img[@src='https://cdn.jsdelivr.net/emojione/assets/3.1/png/64/1f642.png']")
    WebElement validationReject;


    public WidgetPage(WebDriver driver)
    {
        this.driver= driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver,this);

    }

    public String fillWidget(CheckboxEnum check)
    {
            String result="";

            Faker faker = new Faker(Locale.forLanguageTag("en"));

            int recommendation = faker.number().numberBetween(1,10);

            int emoji = faker.number().numberBetween(1,5);

            String comment = "I liked the service";

            String email = faker.internet().emailAddress();

            String name = faker.name().fullName();

            String phoneNumber  = "90" + faker.number().numberBetween(532,555) + faker.number().digits(7);
            //the upper method is used instead of faker.phoneNumber().cellPhone() to get better results

            driver.switchTo().frame("psn-widget-button-frame");

            widgetBtn.click();

            driver.switchTo().defaultContent();

            driver.switchTo().frame("psn-widget-content-frame");

            List<WebElement> groupElements = driver.findElements(By.xpath("//div[@class='button-group']"));
            groupElements.get(0).findElement(By.xpath("//div[" + recommendation + "]")).click();
            groupElements.get(1).findElement(By.xpath("//div[" + emoji + "]/span/img")).click();

            nextPageBtn.click();

            commentTxt.sendKeys(comment);

            if (check == CheckboxEnum.accept) {
                acceptRadioBtn.click();
            }
            else if (check == CheckboxEnum.reject) {
                rejectRadioBtn.click();
            }

            pisanoCheckbox.click();
            othersCheckbox.click();

            nextPageBtn.click();


            if (check == CheckboxEnum.accept) {

                emailTxt.sendKeys(email);
                nameTxt.sendKeys(name);
                phoneTxt.sendKeys(phoneNumber);
                submitBtn.click();

                result = validationMessage.getText();

            }
            else if (check == CheckboxEnum.reject) {

                String searchFirstPage;

                try {
                    validationReject.getAttribute("class");
                    searchFirstPage = "Returned to first page";
                } catch (Exception ex) {
                    searchFirstPage = "Failed to return first page";
                }


                result= searchFirstPage;
            }

            return  result;
        }

    }

