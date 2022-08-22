package com.java.reactive.models;

import lombok.Data;

@Data
public class QueryJsonResponse {

    private String stock;
    private String price;
    private String title;
    private String brand;
    private String category;
    private String description;



    public QueryJsonResponse() {
    }

}
