package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

// Created for perform Create, REad, Update, Delete requests to the user API
public class UserEndPoints2 {

    //method created for getting URL's from properties file
    static ResourceBundle getURL(){
        ResourceBundle routes = ResourceBundle.getBundle("routes"); // Load properties file, name of the property file
        return routes;
    }
    public static Response createUser(User payload) {
        String post_url = getURL().getString("post_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_url);
        return response;
    }

    public static Response readUser(String userName) {
        String get_url = getURL().getString("get_url");

        Response response = given()
                .pathParam("username", userName)
                .when()
                .get(Routes.get_url);
        return response;
    }

    public static Response updateUser(String userName, User payload) {

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(Routes.update_url);
        return response;
    }

    public static Response deleteUser(String userName) {
        Response response = given()
                .pathParam("username", userName)
                .when()
                .delete(Routes.delete_url);
        return response;
    }

}
