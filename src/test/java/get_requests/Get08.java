package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonplaceholderBaseUrl {

    //De-Serialization: JSON formatından Java objesine çevirme.
    //Serialization: Java objesini JSON formatına çevirme.
    // De-Serialization ve Serialization iki türlü yapılır:
    //Gson: Google tarafından üretiliştir.
    //Object Mapper: Daha popüler ***

     /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */
     @Test
     public void get01(){

         //1. Step: Set the Url
         spec.pathParams("first","todos","second",2);

         //2. Step: Set the expected data

         Map<String,Object> expectedData = new HashMap<>();
         expectedData.put("userId",1);
         expectedData.put("title","quis ut nam facilis et officia qui");
         expectedData.put("completed",false);
         expectedData.put("StatusCode",200);
         expectedData.put("Via","1.1 vegur");
         expectedData.put("Server", "cloudflare");

         //3. Step: Send the request and get the Response
         Response response = given().spec(spec).when().get("/{first}/{second}");

         Map<String, Object> actualData = response.as(HashMap.class);


         //4. Step: Do Assertion
         assertEquals(expectedData.get("userId"),actualData.get("userId"));
         assertEquals(expectedData.get("title"),actualData.get("title"));
         assertEquals(expectedData.get("completed"),actualData.get("completed"));
         assertEquals(expectedData.get("StatusCode"),response.getStatusCode());
         assertEquals(expectedData.get("Via"), response.getHeader("Via"));
         assertEquals(expectedData.get("Server"), response.getHeader("Server"));

     }

}
