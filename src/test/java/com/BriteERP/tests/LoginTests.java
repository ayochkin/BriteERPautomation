package com.BriteERP.tests;

import com.BriteERP.pages.LoginPage;
import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.Driver;
import com.BriteERP.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase { //negative test

    @Test(description = "Login with invalid credentials and verify warning message")
    public void negativeLoginTest() {
        LoginPage login=new LoginPage();
        extentLogger = report.createTest("Negative login test");
        extentLogger.info("Login with wrongusername username and wrongpassword password");
        login.login("wrongusername", "wrongpassword");
        BrowserUtils.waitPlease(3);
        //Assert.assertTrue(login.getErrorMessage().contains("Wrong login/password"));  //OPTIONAL
        Assert.assertEquals(login.getErrorMessage(), "Wrong login/password");
        extentLogger.pass("Verified that Message present: " + login.getErrorMessage());
    }
}