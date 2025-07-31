package com.enyoi.ms_orders.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientResponseDto {

    @JsonProperty("id")
    private String id;
    @JsonProperty("email")
    private String email;

}
