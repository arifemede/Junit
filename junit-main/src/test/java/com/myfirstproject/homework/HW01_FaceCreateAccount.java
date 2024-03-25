package com.myfirstproject.homework;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HW01_FaceCreateAccount extends TestBase {
@Test
public void accountSignUp(){
    //    Navigate to Go to https://www.facebook.com/
        driver.get("https://facebook.com");
    //        click on 'Create new account'
        driver.findElement(By.linkText("Create new account")).click();
    //        driver.findElement(By.xpath("Xpath of the popup")).click();

        Faker faker = new Faker();
    //    Enter first name
        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());

    //    Enter last name
        driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());

    //    Enter mobile number or email
        driver.findElement(By.name("reg_email__")).sendKeys(faker.phoneNumber().phoneNumber());

    //    Enter new password
        driver.findElement(By.name("reg_passwd__")).sendKeys(faker.internet().password());
    //    Enter birthday
    //        Jan 10 2000
    //        MONTH
    //        1. locate the month dropdown
        WebElement month = driver.findElement(By.id("month"));
    //        2. create select
        Select selectMonth=new Select(month);
    //        3. select your option using select object
        selectMonth.selectByVisibleText("Jan");

    //        DAY
    //        1. locate the day dropdown
        WebElement day = driver.findElement(By.id("day"));
    //        2. create select
        Select selectDay = new Select(day);
    //        3. select the day using select object
        selectDay.selectByVisibleText("10");

    //        YEAR
    //        1. locate the year dropdown
        WebElement year = driver.findElement(By.id("year"));
    //        2. create select
        Select selectYear = new Select(year);
    //        3. select the day using select object
        selectYear.selectByVisibleText("2000");


    //    Enter gender
        driver.findElement(By.xpath("//input[@value='2']")).click();

    //    Click Sign Up
        driver.findElement(By.name("websubmit")).click();

    }
}
