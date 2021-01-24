package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchMisradApnimTests {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
//        wd = new ChromeDriver(); // to chose what driver you want to use
        wd = new FirefoxDriver();
        wd.manage().window().maximize(); // open your page to full size resolution
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.navigate().to("https://www.autotrader.ca/");

    }

    @Test
    public void searchFromNavMenuTest(){
        // click on reception points
        wd.findElement(By.cssSelector("#advancedSearch")).click();

        // get page title
        String pageTitle = wd.findElement(By.cssSelector("h1 #titleText")).getText();
        System.out.println(pageTitle);

    }


    @AfterMethod(enabled = false)
    public void tearDown(){
        wd.quit();

    }

}
