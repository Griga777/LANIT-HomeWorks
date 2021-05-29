package org.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.example.model.Order;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class HomeTaskApiTest {

    @BeforeClass
    public void prepare() throws IOException {

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my"));

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .addHeader("api_key", "api.key")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        RestAssured.filters(new ResponseLoggingFilter());
    }

    @Test
    public void checkOrderSave() {

        Order order = new Order();
        int id = new Random().nextInt(10);
        int petId = new Random().nextInt(10);
        int quantity = new Random().nextInt(10);
        order.setId(id);
        order.setPetId(petId);
        order.setQuantity(quantity);

        given()
                .body(order)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200);

        Order actual =
                given()
                        .pathParam("orderId", id)
                        .when()
                        .get("/store/order/{orderId}")
                        .then()
                        .statusCode(200)
                        .extract().body()
                        .as(Order.class);
        Assert.assertEquals(actual.getId(), order.getId());
    }

    @Test
    public void orderDelete() throws IOException {

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my"));

        given()
                .pathParam("orderId", System.getProperty("orderId"))
                .when()
                .delete("/store/order/{orderId}")
                .then()
                .statusCode(200);
        given()
                .pathParam("orderId", System.getProperty("orderId"))
                .when()
                .get("/store/order/{orderId}")
                .then()
                .statusCode(404);
    }
}
