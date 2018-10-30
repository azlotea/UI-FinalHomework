package stepdefs;

import com.endava.AddNewOwnerPage;
import com.endava.NavigationPage;
import com.endava.OwnersPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;


public class OwnersStepDefinition  extends TestBase{
    private NavigationPage navigationPage;
    private AddNewOwnerPage addNewOwnerPage;
    private OwnersPage ownersPage;

// Scenario 1
    @Given("^I navigate to the add new owner page$")
    public void i_navigate_to_the_add_new_owner_page() throws Throwable {
        init();
        navigationPage = new NavigationPage(webDriver);
        navigationPage.clickAddNewOwner(webDriver);
    }

    @When("^I enter valid data for first name \"([^\"]*)\", last name \"([^\"]*)\", address \"([^\"]*)\", city \"([^\"]*)\" and telephone \"([^\"]*)\" fields$")
    public void iEnterValidDataForFirstNameLastNameAddressCityAndTelephoneFields(String firstName, String lastName, String address, String city, String telephone) throws Throwable {
        addNewOwnerPage = new AddNewOwnerPage(webDriver);
        addNewOwnerPage.addOwner(firstName, lastName, address, city, telephone);
        //Thread.sleep(2000);
    }

    @When("^I click on AddOwner button$")
    public void i_click_on_AddOwner_button() throws Throwable {
        addNewOwnerPage.clickAddOwnerBtn();

    }

    @Then("^The newly added veterinarian should be found on the list$")
    public void the_newly_added_veterinarian_should_be_found_on_the_list() throws Throwable {
        navigationPage.clickAllOwners(webDriver);
        ownersPage = new OwnersPage(webDriver);
        Assert.assertTrue(ownersPage.isOwnerPresent("Adrian Cucumber"));
        teardown();
    }

    //Scenario 2
    @When("^I enter valid data for first name \"([^\"]*)\", last name \"([^\"]*)\", address \"([^\"]*)\", city \"([^\"]*)\" fields and invalid for telephone \"([^\"]*)\" field$")
    public void iEnterValidDataForFirstNameLastNameAddressCityFieldsAndInvalidForTelephoneField(String firstName, String lastName, String address, String city, String telephone) throws Throwable {
        addNewOwnerPage = new AddNewOwnerPage(webDriver);
        addNewOwnerPage.addOwner(firstName, lastName, address, city, telephone);

    }

    @Then("^The error message \"([^\"]*)\" should appear$")
    public void theErrorMessageShouldAppear(String message) throws Throwable {
        Assert.assertEquals(message,addNewOwnerPage.checkErrorMessage(webDriver));
        teardown();
    }

    @When("^I do not complete any field$")
    public void iDoNotCompleteAnyField() throws Throwable {

    }
    @Then("^The AddOwner button is invalid$")
    public void theAddOwnerButtonIsInvalid() throws Throwable {
        addNewOwnerPage = new AddNewOwnerPage(webDriver);
        Assert.assertFalse(addNewOwnerPage.isValidAddOwnerBtn());
    }


}
