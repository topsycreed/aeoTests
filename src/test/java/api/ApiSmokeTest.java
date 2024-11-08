package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiSmokeTest {
    RequestSpecification requestSpecification = given();

    @Test
    void authTest() {
        requestSpecification.header("authorization", "Basic MjBlNDI2OTAtODkzYS00ODAzLTg5ZTctODliZmI0ZWJmMmZlOjVmNDk5NDVhLTdjMTUtNDczNi05NDgxLWU4OGVkYjQwMGNkNg==");
        requestSpecification.baseUri("https://www.ae.com/ugp-api/auth/oauth/v4/token");
        this.requestSpecification.contentType(ContentType.JSON);
        this.requestSpecification.accept(ContentType.JSON);
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("grant_type", "client_credentials");
        requestSpecification.body(requestBody);
        Response response = given(this.requestSpecification).post().andReturn();
        response.prettyPrint();
    }
}
