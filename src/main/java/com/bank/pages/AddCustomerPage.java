package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class AddCustomerPage extends Utility {


    //Declaring By variable to locate web elements
    By firstNameField = By.xpath("//input[@placeholder='First Name']");
    By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    By postcodeField = By.xpath("//input[@placeholder='Post Code']");
    By addCustomerButton = By.xpath("//button[@class='btn btn-default']");

    //This method will send text to first name field
    public void sendTextToFirstNameField(String fNames) {
        sendTextToElement(firstNameField, fNames + getAlphaNumericString(3));
    }

    //This method will send text to last name field
    public void sendTextToLastNameField(String lNames) {
        sendTextToElement(lastNameField, lNames + getAlphaNumericString(3));
    }

    //This method will send text to first name field
    public void sendTextToPostCodeField(String postCode) {
        sendTextToElement(postcodeField, postCode + getAlphaNumericString(3));
    }

    //This method will click on Add Customer Button
    public void clickOnAddCustomerButton() {
        clickOnElement(addCustomerButton);
    }

}
