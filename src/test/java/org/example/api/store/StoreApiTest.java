package org.example.api.store;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class StoreApiTest {

    @BeforeClass
    public void prepare() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .addHeader("api_key", System.getProperty("api.key"))
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        RestAssured.filters(new ResponseLoggingFilter());
    }

    @Test
    public void orderForPet() {}

    @Test
    public void deleteOrderForPet() {}

}
