package dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BookingSuccessResponse(
        //Юзаем когда объект джава называется немного иначе, чем поле из жсон
        @JsonProperty("bookingid")
        int bookingId
) {
}
