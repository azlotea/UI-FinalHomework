package stepdefs;

import com.endava.AddNewPetTypesPage;
import com.endava.NavigationPage;
import com.endava.PetTypesPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PetTypeStepDefinition extends TestBase{
    public NavigationPage navigationPage;
    public PetTypesPage petTypePage;
    public AddNewPetTypesPage addNewPetType;
    public WebDriverWait webDriverWait;

//Scenario 1
    @Given("^I navigate to the add new pet type page$")
    public void i_navigate_to_the_add_new_pet_type_page() throws Throwable {
        init();
        navigationPage = new NavigationPage(webDriver);
        navigationPage.clickPetTypes(webDriver);
        petTypePage = new PetTypesPage(webDriver);
        petTypePage.clickAddNewPetType();
    }

    @When("^I enter a new pet type name \"([^\"]*)\"$")
    public void iEnterANewPetTypeName(String petTypeName) throws Throwable {
        addNewPetType = new AddNewPetTypesPage(webDriver);
        addNewPetType.addPetType(petTypeName);
    }

    @When("^I click on save Button$")
    public void iClickOnSaveButton() throws Throwable {
        addNewPetType.saveNewPetType();
        Thread.sleep(200);
    }

    @Then("^The newly added pet type \"([^\"]*)\" should be found on pet type list$")
    public void theNewlyAddedPetTypeShouldBeFoundOnPetTypeList(String petTypeName) throws Throwable {
        petTypePage = new PetTypesPage(webDriver);
        Assert.assertTrue(petTypePage.isPetTypePresent(petTypeName));
        teardown();
    }

//Scenario 2
    @Given("^I navigate to the pet types page$")
    public void i_navigate_to_the_pet_types_page() throws Throwable {
        init();
        navigationPage = new NavigationPage(webDriver);
        navigationPage.clickPetTypes(webDriver);

    }

    @When("^I delete the newly \"([^\"]*)\" pet type$")
    public void i_delete_the_newly_pet_type(String petTypeName) throws Throwable {
        petTypePage = new PetTypesPage(webDriver);
        petTypePage.deleteNewPetType(petTypeName);
        Thread.sleep(200);
    }

    @Then("^The deleted pet type \"([^\"]*)\" can no longer be found in the list$")
    public void the_deleted_pet_type_can_no_longer_be_found_in_the_list(String petTypeName) throws Throwable {
        petTypePage = new PetTypesPage(webDriver);
        Assert.assertFalse(petTypePage.isPetTypePresent(petTypeName));
        teardown();
    }
}
