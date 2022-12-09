package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomerPage extends Utility {
    //Declaring the By variable to locate web element
    By yourNameField = By.xpath("//select[@id='userSelect']");
    By customerLoginButton = By.xpath("//button[contains(text(),'Login')]");

    //This method will select name of customer
    public void selectYourName(String yourName) {
        selectByContainsTextFromDropDown(yourNameField, yourName);
    }

    //This method will click on 'Login' Button
    public void clickOnCustomerLoginButton() {
        clickOnElement(customerLoginButton);
    }

}
