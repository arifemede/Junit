package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW02_DropDown extends TestBase {
//Go to https://testcenter.techproeducation.com/index.php?page=dropdown





    @Test
    public void selectByIndexTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
//1.Create method selectByIndexTest and Select Option 1 using index from Simple dropdown
//        1. locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
//        2. Create Select object cause dropdown is in the select tag. this is for only dropdowns
        Select select = new Select(dropdown);
//        3. Select any option using the select object
        select.selectByIndex(1); // index starts at 0
    }
    //2.Create method selectByValueTest Select Option 2 by value from Simple dropdown
    @Test
    public void selectByVisibleTextTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
    }
    //3.Create method selectByVisibleTextTest Select Option 1 value by visible text from Simple dropdown
    @Test
    public void selectByValueTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(3000);//HARD WAIT. WAITS 3 SECONDS
        select.selectByValue("1");
        Thread.sleep(3000);
        select.selectByValue("2");
        Thread.sleep(3000);
        select.selectByValue("1");
        Thread.sleep(3000);
        select.selectByValue("2");
    }
//4.Create method printAllTest
//    Print all dropdown elements from State selection dropdown,
//    and print the size of  State selection dropdown
//    and Verify State selection dropdown contains Texas text
    @Test
    public void printAllTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement dropdown = driver.findElement(By.id("state"));
        Select select = new Select(dropdown);
//    and print the size of  State selection dropdown
        List<WebElement> allOptions = select.getOptions();
        System.out.println(allOptions.size());
        for (WebElement eachOption : allOptions){
//    Print all dropdown elements from State selection dropdown,
            System.out.println(eachOption.getText());
        }
 //    and Verify State selection dropdown contains Texas text
        boolean isTexasExist=false;
        for (WebElement eachOption : allOptions){
            if (eachOption.getText().equals("Texas")){
                isTexasExist=true;
            }
        }

        Assertions.assertTrue(isTexasExist);
    }
//5. Create method printFirstSelectedOptionTest Print first selected option of State selection dropdown

    @Test
    public void printFirstSelectedOptionTest(){
        WebElement dropdown = driver.findElement(By.id("state"));
        Select select = new Select(dropdown);
//        printing the selected option
        System.out.println("Selected Option : "+select.getFirstSelectedOption().getText());
//        selecting a different option from the dropdown
        select.selectByIndex(2);
//        printing the selected option
        System.out.println("Selected Option : "+select.getFirstSelectedOption().getText());
    }

}
