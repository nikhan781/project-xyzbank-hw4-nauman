package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenAccountPage extends Utility {

    //Declaring By variable to locate web elements
    By customerField = By.xpath("//select[@id='userSelect']");
    By currencyField = By.xpath("//select[@id='currency']//option[@value]");
    By processButton = By.xpath("//button[contains(text(),'Process')]");

    //This method will select customer name from drop down menu
    public void selectName(String name) {

       selectByContainsTextFromDropDown(customerField,name);
    }

    //This method will select the currency
    public void selectCurrency(String sCurrency) {
        List<WebElement> currencyName = driver.findElements(currencyField);
        for (WebElement currency : currencyName) {
            if (currency.getText().equalsIgnoreCase(sCurrency)) {
                currency.click();
            }
        }
    }
    //This method will click process button
    public void clickOnProcessButton() {
        clickOnElement(processButton);
    }

}
