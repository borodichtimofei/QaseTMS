package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseApiClient {

    RequestSpecification requestSpecification;
    String baseURL;
    String token;

    public BaseApiClient() {
        requestSpecification = given().
                header("Token", PropertyReader.getProperty("token")).
                header("Content-Type", "application/json").
                log().all();
        baseURL = PropertyReader.getProperty("baseURL");
    }

    Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public void post(String body, String uri) {
        requestSpecification.
                body(body).
        when().
                post(baseURL + uri).
        then().
                log().all().
                statusCode(200);
    }

    public Response get(String uri) {
        return requestSpecification.
        when().
                get(baseURL + uri).
        then().
                log().all().
                statusCode(200).
                extract().response();
    }
}
