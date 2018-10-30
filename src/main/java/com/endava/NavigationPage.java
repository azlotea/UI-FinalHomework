package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationPage {
    private WebElement owners;
    private WebElement allOwners;
    private WebElement addNewOwner;
    private WebElement veterinarians;
    private WebElement addNewVeterinarians;
    private WebElement allVeterinarians;
    private WebElement petTypes;
    private WebElement specialties;



    public NavigationPage(WebDriver webDriver) {
        owners = webDriver.findElement(By.xpath("//a[text()='Owners']"));
        allOwners = webDriver.findElement(By.xpath("//a[@href='/petclinic/owners']"));
        addNewOwner = webDriver.findElement(By.xpath("//a[@href='/petclinic/owners/add']"));
        veterinarians = webDriver.findElement(By.xpath("//a[text()='Veterinarians']"));
        addNewVeterinarians = webDriver.findElement(By.xpath("//a[@href='/petclinic/vets/add']"));
        allVeterinarians = webDriver.findElement(By.xpath("//a[@href='/petclinic/vets']"));
        petTypes = webDriver.findElement(By.xpath("//a[@title='pettypes']"));
        specialties = webDriver.findElement(By.xpath("//a[@href='/petclinic/specialties']"));

    }

    public void clickAllOwners(WebDriver webDriver) {
        owners.click();
        allOwners.click();
    }

    public void clickAddNewOwner(WebDriver webDriver) {
        owners.click();
        addNewOwner.click();
    }

    public void clickAddNewVeterinarians(WebDriver webDriver) {
        veterinarians.click();
        addNewVeterinarians.click();
    }

    public void clickAllVeterinarians(WebDriver webDriver) {
        veterinarians.click();
        allVeterinarians.click();
    }

    public void clickPetTypes (WebDriver webDriver) {

        petTypes.click();
    }

    public void clickSpecialties(WebDriver webDriver) {

        specialties.click();
    }

}
