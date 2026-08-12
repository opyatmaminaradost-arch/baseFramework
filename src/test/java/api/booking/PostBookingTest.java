package api.booking;

import base.BaseTest;
import dto.requests.*;
import dto.responses.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import steps.CreateBookingStep;
import net.datafaker.Faker;
import steps.GetBookingByIdStep;

import static org.assertj.core.api.Assertions.assertThat;

public class PostBookingTest extends BaseTest {

    private CreateBookingStep createBookingStep;
    private GetBookingByIdStep getBookingByIdStep;

    Faker faker = new Faker();


    @BeforeEach
    void initSteps(){
        createBookingStep = new CreateBookingStep(requestSpec);
        getBookingByIdStep = new GetBookingByIdStep(requestSpec);
    }

    @Test
    void postBooking() {

        CreateBookingRequest request = new CreateBookingRequest(
                "Jim",
                "Brown",
                1242,
                true,
                new BookingDates(
                        "2026-08-12",
                        "2026-08-15"
                ),
                "Breakfast"
        );

        BookingSuccessResponse created = createBookingStep.createBooking(request);

        int bookingId = created.bookingId();

        CreateBookingRequest actualBooking = getBookingByIdStep.getBookingById(bookingId);

        assertThat(actualBooking).isEqualTo(request);

    }
}
