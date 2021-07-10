package com.avianca.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SelectFlight {

    private final WebDriver driver;

    public SelectFlight(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[contains(., 'Desde') and @class='select-cabin-button'])[3]")
    WebElement departureFlight;
    @FindBy(xpath = "(//div[@class='flight-container'])[2]")
    WebElement labelDeparture;
    @FindBy(xpath = "(//button[contains(@aria-label,'Tipo de tarifa')])[3]")
    WebElement cheapFlight;
    @FindBy(xpath = "//div[contains(., 'Acepto tarifa') and @class='cro-button cro-no-accept-upsell-button']")
    WebElement acceptRate;

    @FindBy(xpath = "(//button[contains(., 'Desde') and @class='select-cabin-button'])[3]")
    WebElement returnFlight;
    @FindBy(xpath = "(//button[contains(@aria-label,'Tipo de tarifa')])[3]")
    WebElement returnCheapFlight;

    public void selectDepartureFlight(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        JOptionPane.showMessageDialog(null,"Vuelo partida seleccionado: "+labelDeparture.getAttribute("aria-label"));
        departureFlight.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        cheapFlight.click();

    }

    public void selectReturnFlight () {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        JOptionPane.showMessageDialog(null,"Vuelo regreso seleccionado: "+labelDeparture.getAttribute("aria-label"));
        returnFlight.click();
        returnCheapFlight.click();



    }
}
