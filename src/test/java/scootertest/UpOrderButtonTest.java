package scootertest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.FirstOrderPage;
import pageobject.MainPage;
import pageobject.SecondOrderPage;
import pageobject.ThirdOrderPage;

public class UpOrderButtonTest extends TestBaseFox {
    // TestBaseFox { - вариант класса для проверки ФайрФокса
    @Test
    @DisplayName("Проверяем верхнюю кнопку заказа")
    @Description("Тестируем обычную среднюю длину вводимых строк для заполнения полей формы заказа")
    public void testOfUpOrderButton() {         // создаем 4 страницы для теста
        MainPage mainPage = new MainPage(driver);
        FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        ThirdOrderPage thirdOrderPage = new ThirdOrderPage(driver);
        //------------------------------------------------------------------ //
        mainPage.open();                  // открываем браузер
        mainPage.clickCookieButton();     // закрываем окно куки
        mainPage.clickToOrderButtonUp();  // кликаем по кнопке Заказать которая вверху справа
        // -------------- страница ДЛЯ КОГО САМОКАТ ---------------
        firstOrderPage.setNameField("Олег");    // вводим имя в поле Имя в заказе
        firstOrderPage.setSureNameField("Барбашин");   // вводим фамилию в поле Фамилия в заказе
        firstOrderPage.setAddressField("Новосибирск, улица Полевая, дом 1"); // вводим адрес
        firstOrderPage.setStationField(199); // выбираем станцию в списке 199
        firstOrderPage.setPhoneField("+79139858777"); // вводим валидный номер
        firstOrderPage.clickOnFirstOkButton();  // переходим на 2 страницу заказа
        //----------- проверяем что кнопка Назад работает (можно ещё проверить данные полей)
        secondOrderPage.clickOnBackButton(); // возвращаемся по кнопке назад на 1 страницу заказа
        firstOrderPage.clickOnFirstOkButton(); // снова жмем Дальше (первая панель)
        //------------- страница ПРО АРЕНДУ ------------
        secondOrderPage.setDateField("31.12.2022"); // вводим валидную дату доставки самоката
        secondOrderPage.setPeriodFieldOneDay(); // выбираем срок аренды - сутки
        secondOrderPage.setPeriodFieldSevenDays(); // теперь выбираем срок аренды - семеро суток
        secondOrderPage.clickColourBoxBlackAndGrey();  // ставим два чек-бокса цвета самоката
        secondOrderPage.setCommentField("Сообщение для курьера русскими буквами"); // коммент
        secondOrderPage.clickOnSecondOkButton();   // жмем кнопку Заказать (вторая панель)
        // -------------- страница Хотите оформить заказ ? ДА / НЕТ ----------
        thirdOrderPage.clickOnThirdOkButton(); // жмем кнопку ДА
        thirdOrderPage.orderStatusText(); // проверяем текст в окне с номером заказа
        // ---- можно считать номер заказа и проверить его валидность - существует ли такой заказ?
        // --- можно кликнуть по кнопке Посмотреть статус - проверить что есть баги
        // -- например станция метро не соответствует выбранной и т д
    }
}
