package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountPage extends Utility {

    //Declaring the By variable to locate web element
    By logoutButton = By.xpath("//div[@class='box mainhdr']/button[2]");
    By customerAccountPageOptions = By.xpath("//div[@class='borderM box padT20 ng-scope']/div[3]//button");
    By amountToBeDepositedField = By.xpath("//input[@placeholder='amount']");
    By depositButton = By.xpath("//button[@type='submit']");
    By depositSuccessfulMessage = By.xpath("//span[contains(text(),'Deposit Successful')]");
    By transactionSuccessfulMessage = By.xpath("//span[contains(text(),'Transaction successful')]");

    public boolean verifyLogoutButton(){
        return isDisplayed(logoutButton);
    }
    //This method will get text for login button
    public String getTextFromLogoutButton() {
        WebElement logoutText = driver.findElement(logoutButton);
        return logoutText.getText();
    }

    //this method will click on 'Logout' button
    public void clickOnLogoutButton() {
        clickOnElement(logoutButton);
    }

    //This method will select options available to customers
    public void selectCustomerAccountPageOption(String customerOption) {

        List<WebElement> options = driver.findElements(customerAccountPageOptions);

        for (WebElement e : options) {
            if (e.getText().equalsIgnoreCase(customerOption)) {
                e.click();
            }
        }
    }

    //This method will send the amount figure to amount field
    public void sendTextToAmountField(String amount) {
        sendTextToElement(amountToBeDepositedField, amount);
    }

    //This method will click on 'Deposit' button
    public void clickOnDepositButton() {
        clickOnElement(depositButton);
    }

    //This method will return text for successful message
    public String getDepositSuccessfulMessage() {
        return getTextFromElement(depositSuccessfulMessage);
    }

    public String getTransactionSuccessfulText() {
        return getTextFromElement(transactionSuccessfulMessage);
    }

}