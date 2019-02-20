package com.raphaelrossi.cartservice.services;

import com.raphaelrossi.cartservice.exceptions.InvalidDataException;
import com.raphaelrossi.cartservice.resources.Product;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ProductServiceImpl implements ProductService{

    @Value("${product.provider.uri}")
    private String baseURI;

    public Product getProduct(int id){
        Product product;

        Response response = requestSpecification()
            .when()
            .get(Endpoints.PRODUCT, id);

        if(response.getBody().asString().length()>1 && response.getStatusCode() == 200){
            product = response.getBody().as(Product.class);
        }else{
            throw new InvalidDataException("Invalid product id: " + id);
        }
        return product;
    }

    private RequestSpecification requestSpecification() {
        RequestSpecification requestSpecification = RestAssured.given()
                .relaxedHTTPSValidation()
                .baseUri(String.format(baseURI))
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .contentType("application/json");

        return requestSpecification;
    }

    private class Endpoints{
        private static final String PRODUCT = "products/{0}";
    }


}
