package steps;

import dto.requests.CreateBookingRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetBookingByIdStep {

    private final RequestSpecification spec;

    public GetBookingByIdStep(RequestSpecification spec){
        this.spec = spec;
    }


    public Response getBookingRaw(int id){
        return given()
                .spec(spec)
                .pathParam("id", id)
                .when()
                .get("/booking/{id}");
    }

    public CreateBookingRequest getBookingById(int id){
        return getBookingRaw(id)
                .then()
                .statusCode(200)
                .extract()
                .as(CreateBookingRequest.class);
    }

}
