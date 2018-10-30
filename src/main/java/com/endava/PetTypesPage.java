package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PetTypesPage {
    private WebElement addNewPetType;
    private List<WebElement> petTypesNameList;
    private List<WebElement> deleteBtnList;


    public PetTypesPage(WebDriver webDriver) {
        addNewPetType = webDriver.findElement(By.xpath("//button[contains(text(),'Add')]"));
        petTypesNameList = webDriver.findElements(By.xpath("//input[@id]"));
        deleteBtnList = webDriver.findElements(By.xpath("//tbody//tr//td[2]//button[2]"));

    }

    public void clickAddNewPetType() {
        addNewPetType.click();
    }


    public boolean isPetTypePresent(String petTypeName) {
        for(int i = 0; i < petTypesNameList.size(); i++) {
            String savePetName = petTypesNameList.get(i).findElement(By.id(String.valueOf(i))).getAttribute("value");
            if(petTypeName.equals(savePetName)) {
                return true;
            }
        }
        return false;
    }

    public void deleteNewPetType(String petTypeName) {
        for(int i = 0; i < petTypesNameList.size(); i++) {
            String savePetName = petTypesNameList.get(i).findElement(By.id(String.valueOf(i))).getAttribute("value");
            if(petTypeName.equals(savePetName)) {
                deleteBtnList.get(i).click();
                break;
            }
        }
    }


}
