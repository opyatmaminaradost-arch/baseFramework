package api.auth;

import base.BaseTest;
import dto.responses.AuthFailResponse;
import io.restassured.response.Response;
import dto.requests.AuthRequest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadCredentialsTest extends BaseTest {

    @Test
    void getErrorWithIncorrectUserCred() {

        AuthRequest authRequest = AuthRequest.builder()
                .username("aboba")
                .password("aboba")
                .build();

        Response response = given()
                .contentType("application/json")
                .body(authRequest)
                .when()
                .post("/auth");

        response.then()
                .log().all()
                .statusCode(200);

        AuthFailResponse authFailResponse = response.as(AuthFailResponse.class);
        assertEquals("Bad credentials", authFailResponse.reason());
    }
}
