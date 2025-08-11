package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidationTest extends BaseTest {

    @Test
    public void validateResponseSchema() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/all?fields=name,currencies,capital,languages,region,subregion,continents,flags,capitalInfo,population")
                .then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("countrySchema.json"));
    }
}
