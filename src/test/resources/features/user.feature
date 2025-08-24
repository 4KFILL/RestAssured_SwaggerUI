Feature: Тесты User

  Scenario: POST запрос на создание USER
    Given Установлен базовый URL
    When Отправлен POST запрос по "/user" с телом запроса:
    """
    {
      "id": 889922,
      "username": "Nochka",
      "firstName": "Darkova",
      "lastName": "Darkovna",
      "email": "nochka@yandex.ru",
      "password": "889922",
      "phone": "89883224455",
      "userStatus": 10
    }
    """
    Then Получен статус код 200
    And Ответ должен содержать поле "message"
    And Я очищаю контекст

  Scenario: GET запрос на получение USER по id
    Given Установлен базовый URL
    When Отправлен GET запрос по "/user" и имени пользователя "Nochka"
    Then Получен статус код 200
    And Ответ должен содержать поле "lastName" со значением "Darkovna"
    And Я очищаю контекст