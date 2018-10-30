package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OwnersPage {
    private List<WebElement> ownersList;

    public OwnersPage(WebDriver webDriver){
        ownersList = webDriver.findElements(By.className("ownerFullName"));
    }

    public List<WebElement> getOwnersList () {
        return ownersList;
    }

    public List<String> getOwnersListName (){
        List<String> ownerTextList = new ArrayList<String>();
        for (WebElement we : getOwnersList()) {
            ownerTextList.add(we.getText());
        }
        return ownerTextList;
    }

    public boolean isOwnerPresent(String owner){
        for (String elem : getOwnersListName()){
            if (elem.equals(owner)){
                return true;
            }
        }
        return false;
    }
}
