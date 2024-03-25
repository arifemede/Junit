package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day07_Cookies extends TestBase {

    @Test
    public void cookiesTest() throws InterruptedException {
        driver.get("https://www.amazon.com");
//        1. Find the total number of cookies
        Set<Cookie> cookieList = driver.manage().getCookies();
        System.out.println("Cookie size : "+cookieList.size());
//        2. Print all the cookies
        for (Cookie eachCookie:cookieList){
            System.out.println("Each Cookies : "+eachCookie);
            System.out.println("Cookie Value : "+eachCookie.getValue());
            System.out.println("Cookie Names : "+eachCookie.getName());
        }
//        3. Get the cookies by their name
        System.out.println("Cookies By Name => "+driver.manage().getCookieNamed("i18n-prefs"));
//        4. Add new cookie
        Cookie myFavCookie = new Cookie("my-cookies","login-cookie");
        driver.manage().addCookie(myFavCookie);
        Thread.sleep(3000);
        for (Cookie each : driver.manage().getCookies()){
            System.out.println(each);//printing all cookies to see if the new cookie is added
        }
//        5. Delete all of the cookies
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        System.out.println("After deleting all cookies, there are "+driver.manage().getCookies().size()+" cookies");
    }
}
