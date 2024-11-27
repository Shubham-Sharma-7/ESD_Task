package com.example.esd_task1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponse(
        @JsonProperty("product_name")
        String productName,
        @JsonProperty("price")
        Double price
) {
}
