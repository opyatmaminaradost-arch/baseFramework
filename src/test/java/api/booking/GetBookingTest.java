package api.booking;
import base.BaseTest;
import dto.responses.BookingSuccessResponse;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GetBookingTest extends BaseTest {

    @Test
    void getBookingList() {

        List<BookingSuccessResponse> bookingSuccessResponseList =
                given()
                        .contentType("application/json")
                .when()
                    .get("/booking")
                .then()
                        .statusCode(200)
                        .extract()
                        .as(new TypeRef<List<BookingSuccessResponse>>() {});

        assertThat(bookingSuccessResponseList)
                .extracting(BookingSuccessResponse::bookingId)
                .contains(3);
    }
}