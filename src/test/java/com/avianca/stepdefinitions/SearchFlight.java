package com.avianca.stepdefinitions;

import com.avianca.Pages.SearchPage;
import com.avianca.Pages.SelectFlight;
import com.avianca.model.ItemSearch;
import com.avianca.utilities.JsonReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SearchFlight {

    private WebDriver driver= SetUp.driver;
    @When("Search some flight with {string} {string}")
    public void search_some_flight_with(String nameJson, String numTestCase) throws Exception {
        String file = "src/test/resources/dataDriver/"+nameJson+".json";
        List<ItemSearch> itemsSearch=new JsonReader().getObjects(file,ItemSearch[].class);
        ItemSearch item=  itemsSearch.get(Integer.parseInt(numTestCase)-1);
        SearchPage searchFlight= new SearchPage(this.driver);
        searchFlight.setFromCity(item.getFromCity());
        searchFlight.setToCity(item.getToCity());
        searchFlight.setInitDate(item.getInitDate());
        searchFlight.setEndDate(item.getEndDate());
        searchFlight.setSelectPassengers(item.getPassengers());
        searchFlight.clickSearchFlight();
    }
    @Then("Select flight")
    public void select_flight() {
        SelectFlight selectFlight= new SelectFlight(driver);
        selectFlight.selectDepartureFlight();
        selectFlight.selectReturnFlight();
    }


}
