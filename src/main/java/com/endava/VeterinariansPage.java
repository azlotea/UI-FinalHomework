package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VeterinariansPage {
    private List<WebElement> veterinariansList;
    private List<WebElement> deleteVetBtnList;



    public VeterinariansPage(WebDriver webDriver) {
        veterinariansList = webDriver.findElements(By.xpath("//tbody//tr//td[1]"));
        deleteVetBtnList = webDriver.findElements(By.xpath("//tbody//tr//td[3]//button[2]"));

    }

    public void deleteNewVet(String nameVet) {
        for (int i = 0; i < veterinariansList.size(); i++) {
            String nameNewVet = veterinariansList.get(i).getText();
            if (nameVet.equals(nameNewVet)) {
                deleteVetBtnList.get(i).click();
                break;
            }
        }
    }

    public List<String> getVeterinariansListName() {
        List<String> veterinariansTextList = new ArrayList<String>();
        for (WebElement vet : veterinariansList) {
            veterinariansTextList.add(vet.getText());
        }
        return veterinariansTextList;
    }

    public boolean isVeterinarianPresent(String veterinarianName) {
        for (String elem : getVeterinariansListName()) {
            if (elem.equals(veterinarianName)) {
                return true;
            }
        }
        return false;
    }
}
