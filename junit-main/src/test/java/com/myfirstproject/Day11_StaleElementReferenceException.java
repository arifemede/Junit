package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day11_StaleElementReferenceException extends TestBase {


    @Test
    public void slateReferenceTest(){
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("tea pot"+ Keys.ENTER);
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();//amazon
        searchBox.sendKeys("tea pot"+ Keys.ENTER);//StaleElementReferenceException due to the reference is old
    }

    @Test
    public void slateReferenceSolutionTest(){
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("tea pot"+ Keys.ENTER);
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();//amazon
        searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));//REFRESHING THE REFERENCE SO THAT WE DO NOT GET STALE REFERENCE EXCEPTION
        searchBox.sendKeys("tea pot"+ Keys.ENTER);
//        OR ALTERNATIVELY
//        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("tea pot"+ Keys.ENTER);//StaleElementReferenceException due to the reference is old
    }


}
