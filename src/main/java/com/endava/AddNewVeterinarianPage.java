package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewVeterinarianPage {
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement typeField;
    private WebElement firstType;
    private WebElement saveVetBtn;



    public AddNewVeterinarianPage(WebDriver webDriver) {
        firstNameField = webDriver.findElement(By.id("firstName"));
        lastNameField = webDriver.findElement(By.id("lastName"));
        typeField = webDriver.findElement(By.id("specialties"));
        saveVetBtn = webDriver.findElement(By.xpath("//button[contains(text(),'Save Vet')]"));
    }

    public void addVeterinarians (String firstName, String lastName) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        typeField.click();
    }

    public void selectType (WebDriver webDriver) {
        firstType = webDriver.findElement(By.xpath("//option[@value='0: Object']"));
        firstType.click();
    }

    public void saveNewVet() {
        saveVetBtn.click();
    }
}
