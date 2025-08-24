package stepdefs.user;

import groovy.util.logging.Slf4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ConfProperties;
import utils.ContextManeger;
import utils.JsonReader;
import utils.TypeContext;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Slf4j
public class UserStep {
    private String baseUri;
    private Response response;

    @Given("Установлен базовый URL")
    public void setBaseURL() {
        this.baseUri = ConfProperties.getProperty("base_url");
    }

    @When("Отправлен POST запрос {string} с телом запроса {string}")
    public void resquestPost(String endpoint, String path) throws IOException {
        String jsonContent = JsonReader.jsonReader(path);

        response = given().baseUri(baseUri)
                .contentType(ContentType.JSON).body(jsonContent).post(endpoint);
        TypeContext context = new TypeContext(response);
        ContextManeger.setCurrentContext(context);
    }

    @Then("Получен статус код {int}")
    public void getStatusCode(int code) {
        TypeContext context = ContextManeger.getContext();
        context.getResponse().then().statusCode(code).log().all();
    }

    @Then("Ответ должен содержать поле {string}")
    public void getPole(String pole) {
        TypeContext context = ContextManeger.getContext();
        context.getResponse().then().body(pole, notNullValue());
    }

    @When("Отправлен GET запрос по {string} и имени пользователя {string}")
    public void getUser(String endpoint, String user) {
        response = given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .get(endpoint + "/" + user);
        TypeContext context = new TypeContext(response);
        ContextManeger.setCurrentContext(context);
    }

    @Then("Ответ должен содержать поле {string} со значением {string}")
    public void getPoleAndValue(String pole, String lastName) {
        TypeContext context = ContextManeger.getContext();
        context.getResponse().then().body(pole, equalTo(lastName));
    }

    @When("Я очищаю контекст")
    public void removeContext() {
        ContextManeger.clearContext();
    }
}
