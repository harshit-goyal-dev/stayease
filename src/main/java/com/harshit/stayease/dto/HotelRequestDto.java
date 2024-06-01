package com.harshit.stayease.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelRequestDto {
    @NotEmpty
    private String name;

    @NotEmpty
    private String location;

    @NotEmpty
    private String description;

    @Min(1)
    private int availableRooms;

}
