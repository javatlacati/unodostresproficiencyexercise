package com.github.javatlacati.unodostres.pages.elements;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Setter
@Getter
@Builder
public class PageElement {
    private String xpathReference;
    private String id;
    private String cssSelector;
    private String className;
    private String name;

    public WebElement getWebElementByXpath(WebDriver driver) {
        Objects.requireNonNull(xpathReference, "no xpath has been provided during the construction of this object");
        return driver.findElement(By.xpath(xpathReference));
    }

    public WebElement getWebElementByXpathWithWait(WebDriver driver) {
        Objects.requireNonNull(xpathReference, "no xpath has been provided during the construction of this object");
        WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toMillis(3));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathReference)));
    }

    public WebElement getWebElementById(WebDriver driver) {
        Objects.requireNonNull(id, "no id has been provided during the construction of this object");
        return driver.findElement(By.id(id));
    }

    public WebElement getWebElementByCssSelector(WebDriver driver) {
        Objects.requireNonNull(cssSelector, "no CSS selector has been provided during the construction of this object");
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public WebElement getWebElementByClassName(WebDriver driver) {
        Objects.requireNonNull(className, "no class name has been provided during the construction of this object");
        return driver.findElement(By.className(className));
    }

    public WebElement getWebElementByName(WebDriver driver) {
        Objects.requireNonNull(name, "no name has been provided during the construction of this object");
        return driver.findElement(By.name(name));
    }

    public WebElement getWebElementByNameWithWait(WebDriver driver) {
        Objects.requireNonNull(name, "no name has been provided during the construction of this object");
        WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toMillis(3));
        return wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
        //return driver.findElement(By.name(name));
    }
}
