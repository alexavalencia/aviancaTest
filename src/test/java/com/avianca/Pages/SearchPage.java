package com.avianca.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SearchPage {

    private final WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="(//input[@data-name='pbOrigen'])[2]")
    WebElement fromCityInput;
    @FindBy(xpath="(//input[@data-name='pbDestino'])[5]")
    WebElement toCityInput;
    @FindBy(xpath = "(//input[@name='pbFechaIda'])[1]")
    WebElement departureDate;
    String departureDate2="(//div[@data-day='{?}'])[2]";
    @FindBy(xpath="(//input[@name='pbPasajeros'])[2]")
    WebElement selectPassengers;
    @FindBy(xpath = "(//div[@data-x-bind='passenger.normal.adults'])[2]")
    WebElement readNumPassengers;
    @FindBy(xpath = "(//div[@data-property='adults'])[4]")
    WebElement addAdults;
    @FindBy(xpath="(//div[@data-source='passenger.normal']//button[contains(.,'Continue')])[3]")
    WebElement closeNumPassengers;
    @FindBy(xpath = "(//button[@title='Buscar vuelos'])[3]")
    WebElement sendSearch;
    @FindBy(xpath="//li[@data-city='BOG']")
    WebElement prueba;



    private WebElement buildXpath(String xpath,String word){
        return this.driver.findElement(By.xpath(xpath.replace("{?}",word)));
    }

    public void setFromCity(String fromCity){
        fromCityInput.sendKeys(fromCity);
        fromCityInput.sendKeys(Keys.ARROW_DOWN);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        fromCityInput.sendKeys(Keys.ENTER);


    }
    public void setToCity(String toCity){
        toCityInput.sendKeys(toCity);
        toCityInput.sendKeys(Keys.ARROW_UP);
        toCityInput.sendKeys(Keys.ARROW_UP);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        toCityInput.sendKeys(Keys.ENTER);
    }

    public void setInitDate(String initDate){
        departureDate.click();
        buildXpath(departureDate2,initDate).click();
    }
    public void setEndDate(String endDate){
        buildXpath(departureDate2,endDate).click();
    }

    public void setSelectPassengers(String passengers){
        if(!passengers.equals("1")){
           selectPassengers.click();
           while(!(readNumPassengers.getText()).equals(passengers)){
               addAdults.click();
           }

        }
    }

    public void clickSearchFlight(){
        sendSearch.click();
    }

}
