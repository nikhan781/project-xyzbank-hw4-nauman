package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BankManagerLoginPage extends Utility {
    //Declaring the By variable to locate web element
    By bankManagerLoginPageOptions = By.xpath("//div[@class='center']//button[@class='btn btn-lg tab']");

    //This method will select options available to manager on Manager login page
    public void selectBankManagerLoginPageOptions(String managersOptions) {
        List<WebElement> managerOptions = driver.findElements(bankManagerLoginPageOptions);

        for (WebElement options : managerOptions) {
            if (options.getText().equalsIgnoreCase(managersOptions))
                options.click();
        }
    }

}
