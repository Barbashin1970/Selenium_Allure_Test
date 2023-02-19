package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SecondOrderPage {
    private final WebDriver webDriver;
    // локатор Дата доставки ------- private By dateField = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input");
    private final By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // локатор Срок аренды ------ private By periodField = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div/div[1]");
    private final By periodField = By.className("Dropdown-placeholder");
    // локаторы для выбора срока аренды - можно сделать все 7 локаторов
    private final By oneDay = By.xpath(".//*[text()='сутки']");
    private final By sevenDays = By.xpath(".//*[text()='семеро суток']");
    // локаторы для выбора чек-боксов с цветом самоката
    private final By colourBoxBlack = By.xpath(".//input[@id='black']");
    // By.className("Checkbox_Input__14A2w");
    private final By colourBoxGrey = By.xpath(".//input[@id='grey']");
    // By.className("Checkbox_Label__3wxSf");
    // локатор поля комментарий
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // ревью замена - By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");
    // локатор кнопки Заказать в форма ПРО АРЕНДУ -----------
    private final By secondOkButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // ревью замена - By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
    // локатор кнопки Назад из формы ПРО АРЕНДУ в форму ДЛЯ КОГО САМОКАТ
    private final By backButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Назад']");

    public SecondOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // ревью замена - By.xpath("/html/body/div/div/div[2]/div[3]/button[1]");
    // <button class="Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i">Назад</button>
    // метод для заполнения даты доставки
    public void setDateField(String text) {
        webDriver.findElement(dateField).clear();
        webDriver.findElement(dateField).sendKeys(text);
        webDriver.findElement(dateField).sendKeys(Keys.ENTER);
        System.out.println("Когда доставить самокат: " + text);
    }

    // метод выбирает в поле срок аренды - сутки
    public void setPeriodFieldOneDay() {
        webDriver.findElement(periodField).click();
        webDriver.findElement(oneDay).isDisplayed();
        String text = webDriver.findElement(oneDay).getText();
        System.out.println("Срок аренды: " + text);
        webDriver.findElement(oneDay).click();
    }

    // метод выбирает срок аренды - семеро суток
    public void setPeriodFieldSevenDays() {
        webDriver.findElement(periodField).click();
        webDriver.findElement(sevenDays).isDisplayed();
        String text = webDriver.findElement(sevenDays).getText();
        System.out.println("Срок аренды: " + text);
        webDriver.findElement(sevenDays).click();
    }

    // метод выбора цвета ----
    // поле цвет необязательное по требованиям к приложению
    public void clickColourBoxBlackAndGrey() {
        webDriver.findElement(colourBoxBlack).click();
        webDriver.findElement(colourBoxGrey).click();
        System.out.println("Выбраны два чек-бокса: Чёрный и Серый");
    }

    public void clickColourBoxBlack() {
        webDriver.findElement(colourBoxBlack).click();
        System.out.println("Выбран чек-бокс цвета: Чёрный");
    }

    public void clickColourBoxGrey() {
        webDriver.findElement(colourBoxGrey).click();
        System.out.println("Выбран чек-бокса цвета: Серый");
    }

    // метод заполнения поля комментарий - необязательное поле по требованиям
    public void setCommentField(String text) {
        webDriver.findElement(commentField).clear();
        webDriver.findElement(commentField).sendKeys(text);
        webDriver.findElement(commentField).sendKeys(Keys.ENTER);
        System.out.println("Комментарий: " + text);
    }

    // метод для нажатия на кнопку Далее и вывода ее текста на экран
    public void clickOnSecondOkButton() {
        String text = webDriver.findElement(secondOkButton).getText();
        System.out.println("Нажали на кнопку: " + text);
        webDriver.findElement(secondOkButton).click();
    }

    // метод для нажатия на кнопку Назад и вывода ее текста на экран
    public void clickOnBackButton() {
        String text = webDriver.findElement(backButton).getText();
        System.out.println("Нажали на кнопку: " + text);
        webDriver.findElement(backButton).click();
    }
}


