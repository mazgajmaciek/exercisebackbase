package api;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import java.util.Base64;

import static io.restassured.RestAssured.given;

public class RestAPI {

    public static Response getUserArticles(String username) {
        RestAssured.defaultParser = Parser.JSON;

        String token = "candidatex:qa-is-cool";
        String encodedString = new String(Base64.getEncoder().encode(token.getBytes()));

        return given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON, "authorization", "Basic " + encodedString)
                .when().get("https://qa-task.backbasecloud.com/api/articles?limit=10&author=" + username)
                .then().contentType(ContentType.JSON).extract().response();

    }

    public static Response deleteArticle(String articleSlug) {
        RestAssured.defaultParser = Parser.JSON;

        String token = "candidatex:qa-is-cool";
        String encodedString = new String(Base64.getEncoder().encode(token.getBytes()));

        return given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON, "authorization", "Basic " + encodedString,
                //TODO should be passed from calling /login POST api
                "jwtauthorization", "Token eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmNzliZDA4NjkzMTg1OWE1ZWVjZTAzMiIsInVzZXJuYW1lIjoibWFjaWVrIiwiZXhwIjoxNjA3MDI4MzQyLCJpYXQiOjE2MDE4NDQzNDJ9.Yp7L_g1FPqmzIR2McjJXw4UIpoR7wQdMuF6gT78fGBc")
                .when().delete("https://qa-task.backbasecloud.com/api/articles/" + articleSlug)
                .then().extract().response();
    }
}
