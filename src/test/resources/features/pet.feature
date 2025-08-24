Feature: Тесты Pet

  Scenario: POST запрос на создание pet
    Given Установлен базовый URL
    When Отправлен POST запрос "/pet" с телом запроса "json/pet/babby-post.json"
    Then Получен статус код 200
    And Ответ должен содержать поле "name"
    And Я очищаю контекст