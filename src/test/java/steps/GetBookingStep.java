package steps;

import dto.responses.BookingSuccessResponse;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetBookingStep {

    private final RequestSpecification spec;

    public GetBookingStep(RequestSpecification spec){
        this.spec = spec;
    }

    public Response getBookingRaw(){
        return given()
                .spec(spec)
                .when()
                .get("/booking");
    }

    public List<BookingSuccessResponse> getBookingList(){
        return getBookingRaw()
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<List<BookingSuccessResponse>>() {});
    }
}
