package com.github.javatlacati.unodostres.pages.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageElement {
    private String xpathReference;

    public WebElement getWebElementByXpath(WebDriver driver) {
        return driver.findElement(By.xpath(xpathReference));
    }
}
