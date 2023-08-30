package com.example.MakeYourTrip.RequestDto;

        import lombok.Data;

        import java.time.LocalDate;

@Data
public class GetAvailableSeatDTO {

    private LocalDate journeyDate;

    private Integer transportId;
}
