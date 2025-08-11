package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class CountryCountTest extends BaseTest {

    @Test
    public void verifyCountryCountIs195() {
        String response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/independent?status=true")
                .then()
                .statusCode(200)
                .extract()
                .asString();

        JsonPath jsonPath = new JsonPath(response);
        int count = jsonPath.getList("independent").size();
        Assert.assertEquals(count, 195, "Country count should be 195");
    }
}
