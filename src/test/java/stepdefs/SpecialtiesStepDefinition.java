package stepdefs;

import com.endava.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class SpecialtiesStepDefinition extends TestBase {
    public NavigationPage navigationPage;
    public SpecialtiesPage specialtiesPage;
    public AddNewSpecialtyPage addNewSpecialtyPage;
    public EditSpecialtyPage editSpecialtyPage;


// Scenario 1
    @Given("^I navigate to the add new specialties page$")
    public void i_navigate_to_the_add_new_specialties_page() throws Throwable {
        init();
        navigationPage = new NavigationPage(webDriver);
        navigationPage.clickSpecialties(webDriver);
        specialtiesPage = new SpecialtiesPage(webDriver);
        specialtiesPage.clickAddNewSpecialtiesBtn();
    }

    @When("^I enter a new specialty \"([^\"]*)\"$")
    public void i_enter_a_new_specialty(String specialtyName) throws Throwable {
        addNewSpecialtyPage = new AddNewSpecialtyPage(webDriver);
        addNewSpecialtyPage.addNewSpecialty(specialtyName);
    }

    @When("^I click on saveButton$")
    public void i_click_on_saveButton() throws Throwable {
        addNewSpecialtyPage.clickOnSaveButton();
        Thread.sleep(200);
    }

    @Then("^The newly added specialty \"([^\"]*)\" should be found on specialties list$")
    public void the_newly_added_specialty_should_be_found_on_specialties_list(String specialtyName) throws Throwable {
        specialtiesPage = new SpecialtiesPage(webDriver);
        specialtiesPage.isSpecialtyPresent(specialtyName);
        teardown();
    }

    //Scenario 2
    @Given("^I navigate to the all specialties page$")public void i_navigate_to_the_all_specialties_page() throws Throwable {
        init();
        navigationPage = new NavigationPage(webDriver);
        navigationPage.clickSpecialties(webDriver);
    }

    @Given("^I click on the edit button of the newly added specialty \"([^\"]*)\"$")
    public void i_click_on_the_edit_button_of_the_newly_added_specialty(String specialtyName) throws Throwable {
        specialtiesPage = new SpecialtiesPage(webDriver);
        specialtiesPage.editNewSpecialty(specialtyName);

    }

    @When("^I enter new specialty name \"([^\"]*)\"$")
    public void i_enter_new_specialty_name(String newSpecialtyName) throws Throwable {
        editSpecialtyPage = new EditSpecialtyPage(webDriver);
        editSpecialtyPage.editSpecialty(newSpecialtyName);
    }

    @When("^I click on update button$")
    public void i_click_on_update_button() throws Throwable {
        editSpecialtyPage.clickOnUpdateButton();

    }
    @Then("^The updated specialty \"([^\"]*)\" should be found on specialties list$")
    public void the_updated_specialty_should_be_found_on_specialties_list(String newSpecailtyName) throws Throwable {
        specialtiesPage = new SpecialtiesPage(webDriver);
        specialtiesPage.isSpecialtyPresent(newSpecailtyName);
        teardown();


    }

}
