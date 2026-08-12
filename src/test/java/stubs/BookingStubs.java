package stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public final class BookingStubs {

    private BookingStubs() {

    }

    public static void stubBookingListsSuccess() {

        stubFor(
                get(urlPathEqualTo("/booking"))
                        .willReturn(
                                aResponse()
                                        .withStatus(200)
                                        .withHeader(
                                                "Content-Type",
                                                "application/json"
                                        )
                                        .withBody("""
                                                                                                [
                                                                                                  {
                                                                                                    "bookingid": 1
                                                                                                  },
                                                                                                  {
                                                                                                    "bookingid": 2
                                                                                                  },
                                                                                                  {
                                                                                                    "bookingid": 3
                                                                                                  },
                                                                                                  {
                                                                                                    "bookingid": 4
                                                                                                  }
                                                                                                ]
                                                """)
                        )
        );
    }
}
