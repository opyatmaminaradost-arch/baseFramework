package api.booking;
import base.BaseBookingTest;
import base.BaseTest;
import dto.responses.BookingSuccessResponse;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import java.util.List;

class GetBookingTest extends BaseBookingTest { 

    @Test
    @Tag("booking") 
    void getBookingList() {

        List<BookingSuccessResponse> booking = getBookingStep.getBookingList();

        SoftAssertions.assertSoftly(softly -> {

            softly.assertThat(booking)
                    .extracting(BookingSuccessResponse::bookingId)
                    .contains(2);
        });

    }
}
