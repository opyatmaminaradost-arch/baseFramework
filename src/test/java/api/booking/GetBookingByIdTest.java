package api.booking;

import base.BaseBookingTest;
import base.BaseTest;
import dto.responses.BookingSuccessResponse;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GetBookingByIdTest extends BaseBookingTest {

    @Test
    @Tag("booking")
    void getBookingById() {

        List<BookingSuccessResponse> booking = getBookingStep.getBookingList(); 
        
        assertThat(booking).isNotNull();
        assertThat(booking).hasSizeGreaterThan(10);
    }

}
