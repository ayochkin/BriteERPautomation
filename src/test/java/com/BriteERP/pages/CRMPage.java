package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CRMPage {

    WebDriver driver = Driver.getDriver();

    public CRMPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#login")
    public WebElement loginLocator;

    @FindBy(css = "#password")
    public WebElement passwordLocator;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButtonLocator;

    @FindBy(xpath = "//span[@class='oe_menu_text'][contains(text(),'CRM')]")
    public WebElement crmModuleLocator;

    @FindBy(css = "button[class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']")
    public WebElement pivotBoardLocator;

    @FindBy(xpath = "//td[text()='Total']")
    public WebElement totalButtonLocator;

    @FindBy(css = "td[class='o_pivot_header_cell_closed']")
    public WebElement newButtonLocator;

    @FindBy(xpath = "//a[.='Opportunity']")
    public WebElement opportunityOptionLocator;

    @FindBy(xpath = "//table//tbody//tr[3]//td[2]")
    public WebElement expectedRevenuePivotLocator;

    @FindBy(css = "button[data-original-title='List']")
    public WebElement listLocator;

    @FindBy(xpath = "//tr[td[text()='MacBook Pro']]//td[9]")
    public WebElement expectedRevenueListLocator;

    @FindBy(xpath = "//table//tbody//tr[1]//td[2]")
    public WebElement totalExpectedRevenueLocator;

    @FindBy(xpath = "//table//tr//td[2]")
    public List<WebElement>  expectedRevenueLocators;





    public void login(String username, String password){
        loginLocator.sendKeys("eventscrmmanager34@info.com");
        passwordLocator.sendKeys("eventscrmmanager");
        loginButtonLocator.click();

    }

}
