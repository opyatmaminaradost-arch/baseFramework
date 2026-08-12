package api.booking;

import base.BaseTest;
import dto.responses.BookingSuccessResponse;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import steps.GetBookingStep;

import java.util.List;

public class GetBookingByIdTest extends BaseTest {

    private GetBookingStep getBookingStep;

    @BeforeEach
    void initSteps() {
        getBookingStep = new GetBookingStep(requestSpec);
    }

    @Test
    void getBookingById() {

        List<BookingSuccessResponse> booking = getBookingStep.getBookingList();

        SoftAssertions.assertSoftly(softly -> {

            softly.assertThat(booking)
                    .extracting(BookingSuccessResponse::bookingId)
                    .contains(1);
        });

    }

}
