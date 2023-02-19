package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThirdOrderPage {
    private final WebDriver webDriver;
    // ------------------ Третья панель --------------------
    // private By thirdOkButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // --------- локатор кнопки с текстом ДА - на 3 экране подтверждения заказа
    private final By thirdOkButton = By.xpath(".//*[text()='Да']");
    // private By orderStatus = By.className("Order_ModalHeader__3FDaJ"); - не подходит из-за того что в
    // браузере Хром и браузере Мозилла - этот класс соответствует разным окнам
    private final By orderStatus = By.xpath("//div[text()='Заказ оформлен']");

    public ThirdOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // метод для клика по кнопке Да
    public void clickOnThirdOkButton() {
        webDriver.findElement(thirdOkButton).isDisplayed();
        String text = webDriver.findElement(thirdOkButton).getText();
        System.out.println("Нажали на кнопку " + text);
        webDriver.findElement(thirdOkButton).click();
    }

    // метод для проверки - появилась ли панель статуса заказа и какой на ней текст
    public void orderStatusText() {
        Assert.assertTrue(webDriver.findElement(orderStatus).isEnabled());
        String text = webDriver.findElement(orderStatus).getText();
        System.out.println("--------------------------------------------------- ");
        System.out.println("Появляется панель с информацией о заказе с текстом: ");
        System.out.println("--------------------------------------------------- ");
        System.out.println(text);
        System.out.println("--------------------------------------------------- ");
    }
}


