package api.auth;
import base.BaseTest;
import dto.responses.AuthSuccessResponse;
import io.restassured.response.Response;
import dto.requests.AuthRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GetTokenTest extends BaseTest {

    // Не надо вызывать сетап тестов. JUnit делает это в аннотации

    @Test
    @Tag("Auth")
    void getUserTokenByCorrectCred() {

        AuthRequest authRequest = AuthRequest.builder()
                .username("admin")
                .password("password123")
                .build();

        Response response = given()
                .contentType("application/json")
                .body(authRequest)
        .when()
                .post("/auth");

        response.then()
                .log().ifValidationFails()
                .statusCode(200);

        AuthSuccessResponse authSuccessResponse = response.as(AuthSuccessResponse.class);

        assertThat(authSuccessResponse.token())
                .isNotBlank();
    }
}
