package com.BriteERP.tests;


import com.BriteERP.pages.CRMPage;
import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import java.util.List;


public class BriteERPTests extends TestBase {

    /**
     * User story:
     *     The system should display the correct information
     *     for each opportunity on the view list page and the pivot table.
     * Acceptance Criteria:
     *     1.Verify that second opportunity’ Expected Revenue value on the Pivot board
     *     should be the same as the Expected revenue column value on the list board.
     * Acceptance Criteria:
     *     2. Verify that on the pivot table, the total expected revenue should be the
     *     sum of all opportunities’ expected revenue.
     */

    @Test(priority = 1)
    public void verifyExpectedRevenue(){
        CRMPage page = new CRMPage();
        extentLogger = report.createTest("Verify Expected Revenues");
        extentLogger.info("Login in");
        String username = ConfigurationReader.getProperty("scrummanagerusername");
        String password = ConfigurationReader.getProperty("scrummanagerpassword");
        page.login(username,password);
        extentLogger.info("Navigating to the CRM module");
        page.crmModuleLocator.click();
        extentLogger.info("Clicking on pivot board");
        page.pivotBoardLocator.click();
        extentLogger.info("Clicking on total Button");
        Actions action = new Actions(driver);
        action.doubleClick(page.totalButtonLocator).perform();
        extentLogger.info("Selecting Opportunity option");
        page.opportunityOptionLocator.click();
        extentLogger.info("Getting expected revenue value from the pivot board");
        String revenueOnPivot = page.expectedRevenuePivotLocator.getText();
        extentLogger.info("Clicking on list button");
        page.listLocator.click();
        extentLogger.info("Getting expected revenue value from the list");
        String revenueOnList = page.expectedRevenueListLocator.getText();
        extentLogger.info("Verify that revenues are equal");

        assertEquals(revenueOnPivot, revenueOnList,"Expected revenues did not match!");
        extentLogger.pass("Verified that expected revenue are the same");
    }

    @Test(priority = 2)
    public void verifyTotalExpectedRevenue() {
        //we are instantiating page class inside a test class,
        //because for second  test, if we run all tests in a row , driver will have null session
        CRMPage page = new CRMPage();
        extentLogger.info("Login in");
        String username = ConfigurationReader.getProperty("scrummanagerusername");
        String password = ConfigurationReader.getProperty("scrummanagerpassword");
        page.login(username, password);
        extentLogger.info("Navigating to the CRM module");
        page.crmModuleLocator.click();
        extentLogger.info("Clicking on pivot board");
        page.pivotBoardLocator.click();
        extentLogger.info("Clicking on Total Button");
        Actions action = new Actions(driver);
        action.doubleClick(page.totalButtonLocator).perform();
        extentLogger.info("Selecting Opportunity option");
        page.opportunityOptionLocator.click();
        List<WebElement> listOfRevenues = page.expectedRevenueLocators;
        BrowserUtils.waitPlease(4);

        double sum = 0;
        double total = 0;

        for( WebElement each : listOfRevenues ){
            //3,200.00
            String price = each.getText().replaceAll(",","");
            if(each.equals(listOfRevenues.get(0))){
                total = Double.parseDouble(price);
                continue;
            }

            double doublePrice = Double.parseDouble(price);

            sum += doublePrice;
        }

        System.out.println(sum + " : " + total);
        assertEquals(total,sum,"Total and sum didn't match!");
        extentLogger.pass("Total and sum are equal");
    }


}
