package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/91
        When
            I send GET Request to the url
        Then
            Response body should be like that;
      {
        "firstname": "James",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
      }
     */
    @Test
    public void get01(){
        //1. Step: Set the Url
        spec.pathParams("first","booking","second",91);

        //2. Step: Set the expected data

        Map<String, String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin","2022-07-14");
        bookingdatesMap.put("checkout","2022-07-23");

        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname","\"Rebekka\"");
        expectedDataMap.put("lastname","\"Einvik\"");
        expectedDataMap.put("totalprice",472);
        expectedDataMap.put("depositpaid",true);
        expectedDataMap.put("bookingdates",bookingdatesMap);
        expectedDataMap.put("additionalneeds","\"Newspaper\"");

        System.out.println(expectedDataMap);

        //3. Step: Send the request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");

        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);


        //4. Step: Do Assertion

        assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("depositpaid"),actualDataMap.get("depositpaid"));
        assertEquals(expectedDataMap.get("totalprice"),actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("additionalneeds"),actualDataMap.get("additionalneeds"));

        assertEquals(bookingdatesMap.get("checkin"),((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"),((Map)actualDataMap.get("bookingdates")).get("checkout"));

    }






}
