package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {

    public static void main(String[] args) {
//        1. System.setProperty is used to instantiate the driver
//        System.setProperty("WHAT DRIVER","WHERE IS IT");
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");//MAC
//        System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");//WINDOWS

//        2. Create the ChromeDriver
        WebDriver driver = new ChromeDriver();

//        3. Now that we have our driver ready to use, we can start automation
        driver.get("https://www.google.com");

    }
}
