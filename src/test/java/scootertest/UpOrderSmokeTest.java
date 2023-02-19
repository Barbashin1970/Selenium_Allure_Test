package scootertest;

import org.junit.Test;
import pageobject.FirstOrderPage;
import pageobject.MainPage;
import pageobject.SecondOrderPage;
import pageobject.ThirdOrderPage;

public class UpOrderSmokeTest extends TestBaseFox {
    // TestBaseFox { - вариант класса для проверки ФайрФокса
    @Test
    public void testSmokeWithMinimumData() {         // создаем 4 страницы для теста
        MainPage mainPage = new MainPage(driver);
        FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        ThirdOrderPage thirdOrderPage = new ThirdOrderPage(driver);
        // ----------------------------------------------------------- //
        mainPage.open();                  // открываем браузер
        mainPage.clickCookieButton();     // закрываем окно куки
        mainPage.clickToOrderButtonUp();  // кликаем по кнопке Заказать которая вверху справа
        // -------------- страница ДЛЯ КОГО САМОКАТ ---------------
        firstOrderPage.setNameField("Ии");    // вводим имя в поле Имя в заказе
        firstOrderPage.setSureNameField("Фф");   // вводим фамилию в поле Фамилия в заказе
        firstOrderPage.setAddressField("город"); // вводим адрес
        firstOrderPage.setStationField(1); // выбираем станцию в списке 1
        firstOrderPage.setPhoneField("+79139858777"); // вводим валидный номер
        firstOrderPage.clickOnFirstOkButton();  // переходим на 2 страницу заказа
        //------------- страница ПРО АРЕНДУ ------------
        secondOrderPage.setDateField("31.12.2022"); // вводим валидную дату доставки самоката
        secondOrderPage.setPeriodFieldOneDay(); // выбираем срок аренды - сутки
        secondOrderPage.clickColourBoxGrey();  // ставим один чек-бокс цвета самоката
        secondOrderPage.setCommentField("К"); // коммент
        secondOrderPage.clickOnSecondOkButton();   // жмем кнопку Заказать (вторая панель)
        // -------------- страница Хотите оформить заказ ? ДА / НЕТ ----------
        thirdOrderPage.clickOnThirdOkButton(); // жмем кнопку ДА
        thirdOrderPage.orderStatusText(); // проверяем текст в окне с номером заказа
        // ---- можно считать номер заказа и проверить его валидность - существует ли такой заказ?
        // --- можно кликнуть по кнопке Посмотреть статус - проверить что есть баги
        // -- например станция метро не соответствует выбранной и т д
    }
}