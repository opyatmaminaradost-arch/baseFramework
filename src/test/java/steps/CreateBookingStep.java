package steps;

import dto.requests.CreateBookingRequest;
import dto.responses.BookingSuccessResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CreateBookingStep {

    private final RequestSpecification spec;

    public CreateBookingStep(RequestSpecification spec) {
        this.spec = spec;
    }

    public Response postBookingRaw(CreateBookingRequest request) {
        return given()
                .spec(spec)
                .body(request)
                .when()
                .post("/booking");
    }

    public BookingSuccessResponse createBooking(
            CreateBookingRequest request
    ) {
        return postBookingRaw(request)
                .then()
                .statusCode(200)
                .extract()
                .as(BookingSuccessResponse.class);
    }
}