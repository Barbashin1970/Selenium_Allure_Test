package scootertest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.FirstOrderPage;
import pageobject.MainPage;
import pageobject.SecondOrderPage;
import pageobject.ThirdOrderPage;

public class DownOrderButtonTest extends TestBaseFox {   // - это для Хрома -
    // TestBaseFox { // - вариант класса для проверки ФайрФокса

    @Test
    @DisplayName("Максимальная длина строк")
    @Description("Тестируем максимальные длины вводимых строк для заполнения полей формы заказа")
    public void testOfDownOrderButton() {
        MainPage mainPage = new MainPage(driver);
        FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        ThirdOrderPage thirdOrderPage = new ThirdOrderPage(driver);

        // -------------  эта часть проверяет вторую кнопку Заказать - нижнюю - надо скроллить
        mainPage.open();                 // открываем браузер
        mainPage.clickCookieButton();   // закрываем окно куки
        mainPage.scrollToOrderButton(); // скроллим экран до кнопки Заказать которая внизу
        mainPage.clickToOrderButtonDown();  // кликаем по кнопке Заказать которая внизу

        // ------------ ДЛЯ КОГО САМОКАТ  ------------------------
        firstOrderPage.setNameField("ДлинноеИмя");    // вводим имя в поле Имя в заказе
        firstOrderPage.setSureNameField("ДлиннаяФамилия");   // вводим фамилию в поле Фамилия в заказе
        firstOrderPage.setAddressField("Москва, улица Академика Королёва, дом 12"); // вводим адрес
        firstOrderPage.setStationField(10); // выбираем станцию метро - по номеру
        firstOrderPage.setPhoneField("+1234567890");  // номер телефона
        firstOrderPage.clickOnFirstOkButton();  // переходим на 2 страницу заказа
        // --------------- ПРО АРЕНДУ --------------------------------------
        secondOrderPage.setDateField("31.12.2021"); // вводим данные в прошлом
        secondOrderPage.setPeriodFieldSevenDays(); // выбираем срок аренды - семеро суток
        secondOrderPage.clickColourBoxBlack();  // ставим один чек-бокс цвета самоката
        secondOrderPage.setCommentField("Сообщение in English is possible");// коммент
        secondOrderPage.clickOnSecondOkButton();   // жмем кнопку Заказать (вторая панель)
        // -------------- страница Хотите оформить заказ ? ДА / НЕТ ----------
        thirdOrderPage.clickOnThirdOkButton(); // жмем кнопку ДА
        thirdOrderPage.orderStatusText(); // проверяем текст в окне с номером заказа
    }
}