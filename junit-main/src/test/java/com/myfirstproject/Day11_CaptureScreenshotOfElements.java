package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day11_CaptureScreenshotOfElements extends TestBase {

    @Test
    public void captureScreenshotOfElementsTest(){

        driver.get("https://www.google.com/");
        captureScreenshotOfElement(driver.findElement(By.xpath("//img[@alt='Google']")));

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iphone 15 prices");
        captureScreenshotOfElement(searchBox);
    }

}
