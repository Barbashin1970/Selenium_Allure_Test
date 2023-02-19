package scootertest;

import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;

public class MainQuestionsTest extends TestBaseChrome {
    // TestBaseFox { - вариант класса для проверки ФайрФокса

    ArrayOfTextData arrayOfTextData = new ArrayOfTextData();

    @Test
    public void testOfMainQuestionPanel() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();                 // открываем браузер
        mainPage.clickCookieButton();   // закрываем окно куки
        for (int i = 0; i < 8; i++) {
            mainPage.scrollToMainQuestions(i);   // в цикле скроллим до кнопки с вопросом
            mainPage.clickToQuestionButton(i);  // кликаем на вопрос
            mainPage.getAndPrintTextFromNumberButton(i);  // берем текст ответа и печатем в консоль
            String textActual = mainPage.getTextFromNumberButton(i); // сравниваем с текстовым массивом поэлементно
            Assert.assertEquals("Текст ответа отличается от ожидаемого", textActual, arrayOfTextData.expectedAnswerTextArray[i]);
            //  сравниваем ожидаемый ответ с актуальным, если не совпадает то идет ошибка и комментарий
        }
    }
}