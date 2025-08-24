package utils;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class TypeContext {
    private String baseUri;
    private Response response;

    public TypeContext(Response response) {
        this.response = response;
    }
    public TypeContext(String baseUri) {
        this.baseUri = baseUri;
    }

    public TypeContext() {}
}
