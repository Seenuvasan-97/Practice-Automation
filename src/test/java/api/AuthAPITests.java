package api;

import com.aventstack.extentreports.gherkin.model.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthAPITests {
    @Test
    public void validLoginAPITest(){
        Response response = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body("{\n" +
                        "  \"username\": \"UAT.1\",\n" +
                        "  \"password\": \"POS4Liberty@4001\"\n" +
                        "}").when().post("https://support-pos.b2bsoft.com/api/account/login/")
                .then().statusCode(200).extract().response();

    }
}
