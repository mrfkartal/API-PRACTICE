package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06 extends HerOkuAppBaseUrl {
    /*
       Given
           https://restful-booker.herokuapp.com/booking/101
       When
           User send a GET request to the URL
       Then
           HTTP Status    Code should be 200
       And
           Response content type is “application/json”
       And
           Response body should be like;
         {
           "firstname": "GGS",
           "lastname": "FINCH",
           "totalprice": 111,
           "depositpaid": true,
           "bookingdates": {
               "checkin": "2018-01-01",
               "checkout": "2019-01-01"
           }
       }
    */
    @Test
    public void get01(){
        //1. Step: Set the Url

        spec.pathParams("first","booking", "second", 101);
        //2. Set the expected data

        //3. Step: Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        //  response.prettyPrint();

        //4. Step: Do Assertion

        //1. Yol ----> kullanisli bir yol
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Snovid"),
                        "lastname",equalTo("Chizhevskiy"),
                        "totalprice", equalTo(402),
                        "depositpaid", equalTo(false),
                        "bookingdates.checkin",equalTo("2022-07-13"),
                        "bookingdates.checkout",equalTo("2022-07-26"));

        //2. Yol: JsonPath Class kullanılır ** bayaga kullanislu bir yol

        JsonPath json = response.jsonPath();
        assertEquals("Snovid", json.getString("firstname"));
        assertEquals("Chizhevskiy", json.getString("lastname"));
        assertEquals(402, json.getInt("totalprice"));
        assertEquals(false, json.getBoolean("depositpaid"));
        assertEquals("2022-07-13", json.getString("bookingdates.checkin"));
        assertEquals("2022-07-26",json.getString("bookingdates.checkout"));

        //3. Yol: Soft Assertion
        //Soft Assertion için 3 adım izlenir;

        //1) SoftAssert Objesi oluşturulur.
        SoftAssert softAssert = new SoftAssert();

        //2) Obje aracılığı ile assert yapılır.

        softAssert.assertEquals(json.getString("firstname"), "Snovid","firstname uyuşmadı");
        softAssert.assertEquals(json.getString("lastname"),"Chizhevskiy","lastname uyuşmadı");
        softAssert.assertEquals(json.getInt("totalprice"),402,"totalprice uyuşmadı");
        softAssert.assertEquals(json.getBoolean("depositpaid"),false,"depositpaid uyuşmadı");
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2022-07-13","checkin uyuşmadı");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2022-07-26","checkout uyuşmadı");

        //3) assertAll() methodu kullanılır. Aksi taktirde kod her zaman pass olur.
        softAssert.assertAll();

    }


    }

