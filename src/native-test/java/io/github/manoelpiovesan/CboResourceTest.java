package io.github.manoelpiovesan;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class CboResourceTest {

    private static Map<String, Object> cboMap = new HashMap<>();

    @BeforeAll
    public static void setUp() {
        cboMap.put("code", "010105");
        cboMap.put("description", "Oficial general da aeronáutica");
    }

    @Test
    @Order(1)
    public void testGetAll() {
        given()
                .when().get("/cbo")
                .then()
                .statusCode(200)
                .body("$.size()", is(10));
    }

    @Test
    @Order(2)
    public void testGetByCode() {
        given()
                .when()
                .pathParam("code", cboMap.get("code"))
                .get("/cbo/{code}")
                .then()
                .statusCode(200)
                .body("id", notNullValue(),
                      "code", is(cboMap.get("code")))
                .body("description", is(cboMap.get("description")));
    }

}
