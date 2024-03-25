package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.awt.*;

public class Day10_RobotClass extends TestBase {
    @Test
    public void fileUploadTest(){
//        Given user goes to https://www.grammarly.com/plagiarism-checker
        driver.get("https://www.grammarly.com/plagiarism-checker");
//        Then click upload file
        driver.findElement(By.xpath("//div[@id='sectionGrammarCheck_4VB8kepvT7ciShVSz6rHX']//span[@class='iconWrapper_PbRSndwM']")).click();
//        Then selects a document and upload that file
        String path = System.getProperty("user.home")+"/Desktop/sampledoc.docx";//MAC
//        String path = System.getProperty("user.home")+"\\Desktop\\sampledoc.docx";//WIN
        uploadFile(path);

    }

    @Test
    public void fileUploadTest1() throws AWTException {
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html ");
        // IMPORTANT!!! click the "choose file" button
        driver.findElement(By.xpath("//div[@class='form-label'][1]")).click();
        waitFor(3);
        //find your image file in your computer, for my computer => "C:\Users\rpert\Downloads\flower.jpeg"
        //"C:\Users\rpert\Downloads\flower.jpeg"
        String pathOfFlower = System.getProperty("user.home") + "/Downloads/flower.jpeg";
//        String pathOfFlower = System.getProperty("user.home") + "\\Downloads\\flower.jpeg";
        System.out.println(pathOfFlower);
//        ROBOT CLASS REUSABLE METHOD
        uploadFile(pathOfFlower);
/*
//        ROBOT CLASS LONG WAY METHOD
        StringSelection ss = new StringSelection(pathOfFlower);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
//        pressing control V
        robot.keyPress(KeyEvent.VK_CONTROL);
        waitFor(3);
        robot.keyPress(KeyEvent.VK_V);
        waitFor(3);
//        release control V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        waitFor(3);
        robot.keyRelease(KeyEvent.VK_V);
        waitFor(3);
//        click enter
        robot.keyPress(KeyEvent.VK_ENTER);
        waitFor(3);
//        release enter
        robot.keyRelease(KeyEvent.VK_ENTER);
        waitFor(3);
*/


//      we choose the file above then click the "upload button"
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assertions.assertEquals(
                "flower.jpeg",
                driver.findElement(By.id("uploadedfilename")).getText(),
                "File upload is not successful : Actual file name is not flower.jpeg"
        );
//       Alternatively
        Assertions.assertEquals(
                "You uploaded a file. This is the result.",
                driver.findElement(By.xpath("//div[@class='explanation']//p")).getText(),
                "Upload is failed!!!"
        );
    }
}
