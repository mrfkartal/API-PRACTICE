import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class Get02 {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get02(){

        //1. Step  Set the Url

        String url ="https://restful-booker.herokuapp.com/booking/1005";

        //2. Step: Set the expected date(Post-Put-Patch)

        //3.Step: Type code  to send request

        Response response=given().when().get(url);
        response.prettyPrint();

        //4.Do Assertion

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        //Response body'de bulunan spesifik bir veri nasil assert edilir.

        Assert.assertTrue(response.asString().contains("Not Found"));

    }
}
