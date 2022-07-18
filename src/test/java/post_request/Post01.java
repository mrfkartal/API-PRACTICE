package post_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonplaceholderBaseUrl {
      /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)
        When
            I send POST Request to the Url
        Then
            Status code is 201 {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                              }
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01(){
        //1. Set the Url --- url yi olusturuyoruz
        spec.pathParam("first","todos"); // parametreleri ekliyoruz

        //2. Step: Set the expected data //  test datadan obje olusturuyoruz.
        JsonPlaceHolderTestData expectedData = new JsonPlaceHolderTestData();
        Map<String, Object> expectedDataMap = expectedData.expectedDataWithAllKeys(55, "Tidy your room", false);

        //3. Step: Send Post Request and get Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{first}");
        response.prettyPrint();

        //4. Step: Do Assertion
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));

    }
}
