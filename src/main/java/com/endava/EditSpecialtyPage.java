package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditSpecialtyPage {
    private WebElement nameSpecialtyField;
    private WebElement updateBtn;

    public EditSpecialtyPage(WebDriver webDriver) {
        nameSpecialtyField = webDriver.findElement(By.id("name"));
        updateBtn = webDriver.findElement(By.xpath("//button[@type='submit']"));
    }

    public void editSpecialty(String newUpdatedSpecialtity) {
        nameSpecialtyField.clear();
        nameSpecialtyField.sendKeys(newUpdatedSpecialtity);
    }

    public void clickOnUpdateButton() {
        updateBtn.click();
    }
}
