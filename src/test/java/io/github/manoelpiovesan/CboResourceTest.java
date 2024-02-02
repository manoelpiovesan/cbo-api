package io.github.manoelpiovesan;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CboResourceTest {

    private static Map<String, Object> validCboMap = new HashMap<>();

    @BeforeAll
    public static void setup() {
        validCboMap.put("code", "010105");
        validCboMap.put("description", "Oficial general da aeronáutica");
    }

    @Test
    @Order(1)
    public void testGetAll() {
        given()
                .when()
                .get("/cbo")
                .then()
                .statusCode(200)
                .body("$.size()", is(10));
    }

    @Test
    @Order(2)
    public void testGetOne() {
        given()
                .when()
                .pathParam("code", validCboMap.get("code"))
                .get("/cbo/{code}")
                .then()
                .statusCode(200)
                .body("code", is(validCboMap.get("code")),
                      "description", is(validCboMap.get("description")));
    }

}
