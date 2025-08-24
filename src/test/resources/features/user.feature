Feature: Тесты User

  Scenario: POST запрос на создание USER
    Given Установлен базовый URL
    When Отправлен POST запрос "/user" с телом запроса "json/user/nochka-post.json"
    Then Получен статус код 200
    And Ответ должен содержать поле "message"
    And Я очищаю контекст

  Scenario: GET запрос на получение USER по id
    Given Установлен базовый URL
    When Отправлен GET запрос по "/user" и имени пользователя "Nochka"
    Then Получен статус код 200
    And Ответ должен содержать поле "lastName" со значением "Darkovna"
    And Я очищаю контекст