package com.raphaelrossi.cartservice.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import java.math.BigDecimal;


@Data
@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @JsonProperty(value = "id", required = true)
    private Integer id;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "price")
    private BigDecimal price;
}
