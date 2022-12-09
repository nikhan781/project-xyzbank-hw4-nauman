package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {
    HomePage homePage = new HomePage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    AddCustomerPage addCustomerPage = new AddCustomerPage();
    OpenAccountPage openAccountPage = new OpenAccountPage();

    CustomerPage customerPage = new CustomerPage();
    AccountPage accountPage = new AccountPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();

    //TEST 1
    @Test
    public void bankManagerShouldAddCustomerSuccessfully() {
        //click On "Bank Manager Login" Tab
        homePage.selectHomePageOptions("Bank Manager Login");
        //	click On "Add Customer" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Add Customer");
        //	enter FirstName
        addCustomerPage.sendTextToFirstNameField("Shaun");
        //	enter LastName
        addCustomerPage.sendTextToLastNameField("Dead");
        //	enter PostCode
        addCustomerPage.sendTextToPostCodeField("BB1 ");
        //	click On "Add Customer" Button
        addCustomerPage.clickOnAddCustomerButton();
        //	verify message "Customer added successfully"
        Assert.assertTrue(homePage.getTextFromTheAlertMessage().contains("Customer added successfully with customer"), "Customer added successfully with customer");
        //	click on "ok" button on popup.
        homePage.handleAndAcceptTheAlertMessage();
    }

    //Test 2
    @Test
    public void bankManagerShouldOpenAccountSuccessfully() {
        //	click On "Bank Manager Login" Tab
        homePage.selectHomePageOptions("Bank Manager Login");
        //	click On "Open Account" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Open Account");
        //	Search customer that created in first test
        openAccountPage.selectName("Ron");
        //	Select currency "Pound"
        openAccountPage.selectCurrency("Pound");
        //	click on "process" button
        openAccountPage.clickOnProcessButton();
        //	verify message "Account created successfully"
        Assert.assertTrue(homePage.getTextFromTheAlertMessage().contains("Account created successfully with account Number"), "Account created successfully with account Number");
        //	click on "ok" button on popup.
        homePage.acceptAlert();
    }

    //Test 3
    @Test
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        homePage.selectHomePageOptions("Customer Login");
        //	search customer that you created.
        openAccountPage.selectName("Ron");
        //	click on "Login" Button
        customerPage.clickOnCustomerLoginButton();
        Thread.sleep(1500);
        //	verify "Logout" Tab displayed.
        Assert.assertTrue(accountPage.verifyLogoutButton(),"Logout");
       // Assert.assertEquals(accountPage.getTextFromLogoutButton(), "Logout");
        //	click on "Logout"
        accountPage.clickOnLogoutButton();
        //	verify "Your Name" text displayed.
        Assert.assertTrue(customerLoginPage.getYourNameTextOnCustomerLoginPage().contains("Your Name"), "Your Name");
    }

    //Test 4
    @Test
    public void customerShouldDepositMoneySuccessfully() {
        //click on "Customer Login" Tab
        homePage.selectHomePageOptions("Customer Login");
        //	search customer that you created.
        openAccountPage.selectName("Ron");
        //	click on "Login" Button
        customerPage.clickOnCustomerLoginButton();
        //	click on "Deposit" Tab.
        accountPage.selectCustomerAccountPageOption("Deposit");
        //	Enter amount 100
        accountPage.sendTextToAmountField("100");
        //	click on "Deposit" Button
        accountPage.clickOnDepositButton();
        //	verify message "Deposit Successful"
        Assert.assertEquals(accountPage.getDepositSuccessfulMessage(), "Deposit Successful");
    }

    //Test 5
    @Test
    public void customerShouldWithdrawMoneySuccessfully() {
        //click on "Customer Login" Tab
        homePage.selectHomePageOptions("Customer Login");
        //	search customer that you created.
        openAccountPage.selectName("Hermoine");
        //	click on "Login" Button
        customerPage.clickOnCustomerLoginButton();
        //	click on "Withdrawl" Tab
        accountPage.selectCustomerAccountPageOption("Withdrawl");
        //	Enter amount 50
        accountPage.sendTextToAmountField("50");
        //	click on "Withdraw" Button
        accountPage.clickOnDepositButton();
        //	verify message "Transaction Successful"
        Assert.assertEquals(accountPage.getTransactionSuccessfulText(),"Transaction successful");
    }
}
