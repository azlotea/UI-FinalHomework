package stepdefs;

import com.endava.AddNewVeterinarianPage;
import com.endava.NavigationPage;
import com.endava.VeterinariansPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VeterinariansStepDefinition  extends TestBase{
    public NavigationPage navigationPage;
    public AddNewVeterinarianPage addNewVeterinarianPage;
    public VeterinariansPage veterinariansPage;
    public WebDriverWait wait;

//Scenario 1
    @Given("^I navigate to the add new veterinarian page$")
    public void i_navigate_to_the_add_new_veterinarian_page() throws Throwable {
        init();
        navigationPage = new NavigationPage(webDriver);
        navigationPage.clickAddNewVeterinarians(webDriver);
    }

    @When("^I enter valid data for first name \"([^\"]*)\", last name \"([^\"]*)\" and select first type$")
    public void i_enter_valid_data_for_first_name_last_name_and_select_first_type(String firstName, String lastName) throws Throwable {
        addNewVeterinarianPage = new AddNewVeterinarianPage(webDriver);
        addNewVeterinarianPage.addVeterinarians(firstName,lastName);
        addNewVeterinarianPage.selectType(webDriver);
        addNewVeterinarianPage.saveNewVet();

    }

    @Then("^The newly added veterinarian \"([^\"]*)\" should be found on the list$")
    public void theNewlyAddedVeterinarianShouldBeFoudOnTheList(String nameVet) throws Throwable {
        veterinariansPage = new VeterinariansPage(webDriver);
        Assert.assertTrue(veterinariansPage.isVeterinarianPresent(nameVet));
        teardown();
    }

// Scenario 2
    @Given("^I navigate to the all veterinarians page$")
    public void i_navigate_to_the_all_veterinarians_page() throws Throwable {
        init();
        navigationPage = new NavigationPage(webDriver);
        navigationPage.clickAllVeterinarians(webDriver);

    }

    @When("^I delete the newly added veterinarian \"([^\"]*)\"$")
    public void iDeleteTheNewlyAddedVeterinarian(String nameVet) throws Throwable {
        veterinariansPage = new VeterinariansPage(webDriver);
        veterinariansPage.deleteNewVet(nameVet);
        Thread.sleep(200);
    }

    @Then("^The deleted veterinarian \"([^\"]*)\" can no longer be found in the list$")
    public void theDeletedVeterinarianCanNoLongerBeFoundInTheList(String nameVet) throws Throwable {
        veterinariansPage = new VeterinariansPage(webDriver);
        Assert.assertFalse(veterinariansPage.isVeterinarianPresent(nameVet));
        teardown();
    }
}
