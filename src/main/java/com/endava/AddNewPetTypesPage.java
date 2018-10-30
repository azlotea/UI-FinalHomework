package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewPetTypesPage {
    private WebElement petTypeNameField;
    private WebElement saveBtn;

    public AddNewPetTypesPage(WebDriver webDriver) {
        petTypeNameField = webDriver.findElement(By.id("name"));
        saveBtn = webDriver.findElement(By.xpath("//button[contains(text(),'Save')]"));
    }

    public void addPetType(String petname) {
        petTypeNameField.sendKeys(petname);
    }

    public void saveNewPetType() {
        saveBtn.click();
    }
}
