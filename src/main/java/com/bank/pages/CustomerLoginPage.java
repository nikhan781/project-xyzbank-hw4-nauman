package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage extends Utility {
    //Declaring the By variable to locate web element
    By yourNameText = By.xpath("//label[contains(text(),'Your Name :')]");

    //This method will get 'Your Name' text on customer login page
    public String getYourNameTextOnCustomerLoginPage() {
        return getTextFromElement(yourNameText);

    }
}
