package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

    //Declaring By variable to locate web elements
    By homeButton = By.xpath("//button[contains(text(),'Home')]");


    By homePageOptions = By.xpath("//div[@class='borderM box padT20']//button");

    public void clickOnHomeButton() {
        clickOnElement(homeButton);
    }

    //This method will select option available on home page
    public void selectHomePageOptions(String homeOptions) {
        List<WebElement> managerOptions = driver.findElements(homePageOptions);

        for (WebElement options : managerOptions) {
            if (options.getText().equalsIgnoreCase(homeOptions))
                options.click();
        }
    }

    //This method will accept the alert
    public void handleAndAcceptTheAlertMessage() {
        acceptAlert();
    }

    //This method will get the text from alert
    public String getTextFromTheAlertMessage() {
        return getTextFromAlert();
    }


}


