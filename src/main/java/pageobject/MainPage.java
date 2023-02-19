package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver webDriver;
    // локатор кнопки Куки
    private By cookieButton = By.id("rcc-confirm-button");
    // локатор для кнопки Заказать которая внизу
    private By orderButtonDown = By.className("Button_Middle__1CSJM");
    // ревью замена -  By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");
    // локатор для кнопки Заказать которая вверху
    private By orderButtonUp = By.className("Button_Button__ra12g");
    // локаторы кнопок раздела Вопросы о важном с номера 0 до номера 7 - 8 штук
    private By questionButton_0 = By.id("accordion__heading-0");
    private By questionButton_1 = By.id("accordion__heading-1");
    private By questionButton_2 = By.id("accordion__heading-2");
    private By questionButton_3 = By.id("accordion__heading-3");
    private By questionButton_4 = By.id("accordion__heading-4");
    private By questionButton_5 = By.id("accordion__heading-5");
    private By questionButton_6 = By.id("accordion__heading-6");
    private By questionButton_7 = By.id("accordion__heading-7");
    //Массив из локаторов кнопок раздела Вопрсоы о важном
    private By[] questionButtonArray = {
            questionButton_0,
            questionButton_1,
            questionButton_2,
            questionButton_3,
            questionButton_4,
            questionButton_5,
            questionButton_6,
            questionButton_7
    };
    //локаторы к полям текстовых ответов раздела Вопросы о важном
    private By answerField_0 = By.xpath(".//div[@id='accordion__panel-0']/p");
    private By answerField_1 = By.xpath(".//div[@id='accordion__panel-1']/p");
    private By answerField_2 = By.xpath(".//div[@id='accordion__panel-2']/p");
    private By answerField_3 = By.xpath(".//div[@id='accordion__panel-3']/p");
    private By answerField_4 = By.xpath(".//div[@id='accordion__panel-4']/p");
    private By answerField_5 = By.xpath(".//div[@id='accordion__panel-5']/p");
    private By answerField_6 = By.xpath(".//div[@id='accordion__panel-6']/p");
    private By answerField_7 = By.xpath(".//div[@id='accordion__panel-7']/p");
    //Массив локаторов из текстовых ответов раздела Вопрсоы о важном
    private By[] answerFieldTextArray = {
            answerField_0,
            answerField_1,
            answerField_2,
            answerField_3,
            answerField_4,
            answerField_5,
            answerField_6,
            answerField_7
    };

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // открываем сайт тестового стенда
    public void open() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // метод кликает на кнопку Куки чтобы закрыть окно куки для открытия обзора полей вопросов и ответов
    public void clickCookieButton() {
        webDriver.findElement(cookieButton).click();
    }

    // метод скроллит страницу сайта к кнопке вопроса с параметром 0-7
    public void scrollToMainQuestions(int j) {
        WebElement element = webDriver.findElement(questionButtonArray[j]);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // метод кликает по кнопке с вопросом чтобы открыть панель с ответом
    public void clickToQuestionButton(int j) {
        webDriver.findElement(questionButtonArray[j]).click();
    }

    // метод берет текст из панели ответа с соответствующим порядковым номером и выводит на печать
    public void getAndPrintTextFromNumberButton(int j) {
        String text = webDriver.findElement(answerFieldTextArray[j]).getText();
        System.out.println(text);
    }

    // геттер возвращает по параметру j тот текст ответа, который там найдется
    public String getTextFromNumberButton(int j) {
        String text = webDriver.findElement(answerFieldTextArray[j]).getText();
        return text;
    }

    // метод скроллит до кнопки Заказать которая внизу
    public void scrollToOrderButton() {
        WebElement element = webDriver.findElement(orderButtonDown);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // метод кликает в кнопку Заказать внизу
    public void clickToOrderButtonDown() {
        webDriver.findElement(orderButtonDown).click();
    }

    // метод кликает в кнопку Заказать которая вверху справа
    public void clickToOrderButtonUp() {
        webDriver.findElement(orderButtonUp).click();
    }
}


