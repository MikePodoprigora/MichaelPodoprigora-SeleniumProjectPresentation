package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchAutoTraderCarTests {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver(); // to chose what driver you want to use
        wd.manage().window().maximize(); // open your page to full size resolution
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.navigate().to("https://www.autotrader.ca/");

    }

    @Test
    public void searchFromNavMenuTest(){
        // click on reception points
        click(By.cssSelector("#advancedSearch"));

        // get page title
        String pageTitle = wd.findElement(By.cssSelector("h1 #titleText")).getText();
        System.out.println(pageTitle);

        // click on Pop-up window "Goi It"
        click(By.cssSelector("#btnGotIt"));

        // click on Logo button
        click(By.cssSelector("#logo"));

        //click on Make field
        click(By.cssSelector("select#rfMakes"));

        //choose Car category
        click(By.cssSelector("#rfMakes option[value=\"Volkswagen\"]"));


    }


    public void click(By locator) {
        wd.findElement(locator).click();
    }


    @AfterMethod(enabled = false)
    public void tearDown(){
        wd.quit();

    }

}
