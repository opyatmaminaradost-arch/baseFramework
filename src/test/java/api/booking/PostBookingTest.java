package api.booking;

import base.BaseBookingTest;
import base.BaseTest;
import dto.requests.*;
import dto.responses.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.assertj.core.api.Assertions.assertThat;

public class PostBookingTest extends BaseBookingTest {

    @Test
    @Tag("booking") 
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
