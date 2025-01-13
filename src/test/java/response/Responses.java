package response;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

import static request.Requests.*;
import static service.Resources.getResourceBundle;

public class Responses {

    public static Response getResponse() {
        int empId = Integer.parseInt(getResourceBundle().getString("employee.id").trim());
        if (empId != 0) {
            RestAssured.baseURI = getResourceBundle().getString("base.url") + empId;
        } else {
            RestAssured.baseURI = getResourceBundle().getString("base.url");
        }
        return RestAssured.get();
    }

    public static Response postResponse() {
        return createPostRequest().post();
    }

    public static Response putResponse(String id) {
        return createPutRequest(id).put();
    }

    public static Response patchResponse(String id) {
        return createPatchRequest(id).patch();
    }

    public static Response deleteResource(String id) {
        RestAssured.baseURI = getResourceBundle().getString("base.url") + id;
        return RestAssured.when()
                .delete();
    }

    public static void main(String[] args) {
        //System.out.println(getResponse().body().asString());
        List<String> list = getResponse().jsonPath().getList("contact.phone");
        System.out.println(list.get(3));
        //System.out.println(patchResponse().body());
        // System.out.println(patchResponse("e6ae").body());
        // System.out.println(deleteResource("e6ae"));
    }
}

