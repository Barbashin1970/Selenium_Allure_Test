package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FirstOrderPage {
    private final WebDriver webDriver;
    // локатор Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // ревью замена - By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    // локатор Фамилия
    private final By sureNameField = By.xpath("//input[@placeholder='* Фамилия']");
    // ревью замена -  By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input");
    // локатор Адрес
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // ревью замена -  By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input");
    // локатор Станция метро
    private final By stationField = By.className("select-search__input");
    // By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input");
    // локатор селектора Станция метро
    // private final By stationFieldOrder = By.className("select-search__select");
    // локатор номер телефона
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // ревью замена - By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input");
    // локатор кнопки Дальше - в первом окне Для кого самокат
    private final By firstOkButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    public FirstOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    // ревью замена - By.xpath("/html/body/div/div/div[2]/div[3]/button");

    // методы для заполнения полей формы ДЛЯ КОГО САМОКАТ ---------
    // первое поле - Имя
    public void setNameField(String text) {
        webDriver.findElement(nameField).clear();   // очищаем поле
        webDriver.findElement(nameField).sendKeys(text); // вводим Имя из параметра
        System.out.println("Имя: " + text); // выводим на экран Имя
    }

    // метод для ввода фамилии
    public void setSureNameField(String text) {
        webDriver.findElement(sureNameField).clear();
        webDriver.findElement(sureNameField).sendKeys(text);
        System.out.println("Фамилия: " + text);
    }

    // метод для ввода адреса
    public void setAddressField(String text) {
        webDriver.findElement(addressField).clear();
        webDriver.findElement(addressField).sendKeys(text);
        System.out.println("Адрес: " + text);
    }

    // метод для выбора станции метро
    public void setStationField(int j) {
        webDriver.findElement(stationField).isDisplayed(); // ждем чтобы появился список станций
        // webDriver.findElement(stationField).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
        // жмем стрелку вниз и жмем ENTER - в цикле столько раз - какой номер станции ввели
        for (int i = 0; i < j; i++) {
            webDriver.findElement(stationField).sendKeys(Keys.ARROW_DOWN); // стрелка вниз
        }
        webDriver.findElement(stationField).sendKeys(Keys.ENTER); // жмем ввод для выбора станции j
        System.out.println("Номер станции метро по списку в API: " + j);  // выводим на печать просто комментарий для проверки теста
    }

    // метод для ввода номера телефона
    public void setPhoneField(String text) {
        webDriver.findElement(phoneField).clear();
        webDriver.findElement(phoneField).sendKeys(text);
        System.out.println("Номер телефона: " + text);
    }

    // метод для нажатия на кнопку Далее - переход к форме ПРО АРЕНДУ
    public void clickOnFirstOkButton() {
        String text = webDriver.findElement(firstOkButton).getText();
        webDriver.findElement(firstOkButton).click();
        System.out.println("Нажали на кнопку: " + text);
    }
}