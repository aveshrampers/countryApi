package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class LanguageValidationTest extends BaseTest {

    @Test
    public void verifySASLInSouthAfricaLanguages() {
        String response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/name/south africa?fields=name,languages")
                .then()
                .statusCode(200)
                .extract()
                .asString();

        JsonPath jsonPath = new JsonPath(response);
        var southAfrica = jsonPath.getList("languages");
        boolean saslExists = southAfrica.contains("South African Sign Language");

        Assert.assertTrue(saslExists, "SASL should be listed as an official language of South Africa");
    }
}
