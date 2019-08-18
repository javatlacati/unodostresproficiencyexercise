/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.javatlacati.unodostres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Ruslan López Carro <scherzo16 at gmail.com>
 */
public class Home {
    private final String URL = "http://prueba.undostres.com.mx";

    public void go(WebDriver driver) {
        driver.get(URL);
    }

    public void selectOperator(WebDriver driver, String operator) {
        WebElement inputField = driver.findElement(By.xpath("//div[@class='field']/div/input")); // //div[@class='form']/ul/li[1]/div/div/input
        inputField.click();
        WebElement inputOption = driver.findElement(By.xpath("//div[@class='suggestion']/ul/li/a[contains(string(), \"" + operator + "\")]"));
        inputOption.click();
    }

    public void selectTelephoneNumber(WebDriver driver, String telephone) {
        WebElement inputField = driver.findElement(By.xpath("//div[@class='form']/ul/li[2]/div/div/input"));
        inputField.click();
        inputField.sendKeys(telephone);
    }
}
