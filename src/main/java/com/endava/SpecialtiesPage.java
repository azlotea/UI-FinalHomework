package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SpecialtiesPage {
    private WebElement addNewSpecialityBtn;
    private List<WebElement> specialtiesNameList;
    private List<WebElement> editBtnList;


    public SpecialtiesPage(WebDriver webDriver) {
        addNewSpecialityBtn = webDriver.findElement(By.xpath("//button[contains(text(),'Add')]"));
        specialtiesNameList = webDriver.findElements(By.xpath("//input[@id]"));
        editBtnList = webDriver.findElements(By.xpath("//tbody//tr//td[2]//button[1]"));

    }

    public void clickAddNewSpecialtiesBtn() {
        addNewSpecialityBtn.click();
    }

    public void editNewSpecialty(String nameSpecialty) {
        for(int i = 0; i < specialtiesNameList.size(); i++) {
            String saveSpecialty = specialtiesNameList.get(i).findElement(By.id(String.valueOf(i))).getAttribute("value");
            if(nameSpecialty.equals(saveSpecialty)) {
                editBtnList.get(i).click();
                break;
            }
        }
    }


    public boolean isSpecialtyPresent(String nameSpecialty) {
        for(int i = 0; i < specialtiesNameList.size(); i++) {
            String saveSpecialty = specialtiesNameList.get(i).findElement(By.id(String.valueOf(i))).getAttribute("value");
            if(nameSpecialty.equals(saveSpecialty)) {
                return true;
            }
        }
        return false;
    }

}
