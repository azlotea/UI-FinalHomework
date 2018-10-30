package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewSpecialtyPage {
    private WebElement specialtyNameField;
    private WebElement saveBtn;

    public AddNewSpecialtyPage(WebDriver webDriver){
        specialtyNameField = webDriver.findElement(By.xpath("//input[@id='name']"));
        saveBtn = webDriver.findElement(By.xpath("//button[contains(text(),'Save')]"));
    }

    public void addNewSpecialty(String specialtyName) {
        specialtyNameField.sendKeys(specialtyName);
    }

    public void clickOnSaveButton() {
        saveBtn.click();
    }
}
