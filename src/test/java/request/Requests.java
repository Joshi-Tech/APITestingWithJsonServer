package request;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static utils.CreateResources.createEmployeePatchRequest;
import static utils.CreateResources.createResource;
import static service.Resources.getResourceBundle;

public class Requests {

    public static RequestSpecification createPostRequest() {
        RestAssured.baseURI = getResourceBundle().getString("base.url");
        RequestSpecification requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Connection", "Connection")
                .body(createResource())
                .when();
        return requestSpecification;
    }

    public static RequestSpecification createPutRequest(String id) {
        RestAssured.baseURI = getResourceBundle().getString("base.url") + id;
        RequestSpecification requestSpecification = RestAssured.given()
                .body(createResource())
                .when();
        return requestSpecification;
    }

    public static RequestSpecification createPatchRequest(String id) {
        RestAssured.baseURI = getResourceBundle().getString("base.url") + id;
        RequestSpecification requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json") // Ensure the content type is specified
                .body(createEmployeePatchRequest())
                .when();
        return requestSpecification;
    }
}
