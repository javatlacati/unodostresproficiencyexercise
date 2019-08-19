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

/**
 * Abstraction of a WebElement handles the data and conversion to WebElement.
 *
 * @author Ruslan López Carro <scherzo16 at gmail.com>
 * @see org.openqa.selenium.WebElement
 */
@Setter
@Getter
@Builder
public class PageElement {
    /**
     * XPATH
     */
    private String xpathReference;
    /**
     * Unique identifier
     */
    private String id;
    /**
     * CSS Selector
     */
    private String cssSelector;
    /**
     * CSS class name
     */
    private String className;
    /**
     * Element name
     */
    private String name;

    /**
     * Detects a WebElement using the xpath reference value
     *
     * @param driver selenium web driver instance
     * @return the WebElement detected by the driver
     * @see #getWebElementByXpathWithWait(WebDriver)
     */
    public WebElement getWebElementByXpath(WebDriver driver) {
        Objects.requireNonNull(xpathReference, "no xpath has been provided during the construction of this object");
        return driver.findElement(By.xpath(xpathReference));
    }

    /**
     * Detects a WebElement using the xpath reference value and waits until it-s clickable
     *
     * @param driver selenium web driver instance
     * @return the WebElement detected by the driver
     * @see #getWebElementByXpath(WebDriver)
     */
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
    }
}
