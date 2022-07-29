package patch_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Patch01 extends JsonplaceholderBaseUrl {
 /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									    }
     */

// patch'de datanin tamami degil parca yani bir kismini update ediyoruiz.

    @Test
    public void patch01() {
        //1. Step: Set the Url
        spec.pathParams("first", "todos", "second", 198);

        //2. Step: Set the Request Body
        JsonPlaceHolderTestData requestBody = new JsonPlaceHolderTestData();
        Map<String, Object> requestBodyMap = requestBody.expectedDataWithMissingKeys(null, "Wash the dishes", null);

        //3. Step: Send the Patch Request get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().patch("/{first}/{second}");
        response.prettyPrint();

       //4. Step: Do Assertion:
       response.then().assertThat().statusCode(200).body("title",equalTo(requestBodyMap.get("title")));

       Map<String,Object> mapToAssertAllDetails = requestBody.expectedDataWithAllKeys(10,"Wash the dishes",true);
       response.then().assertThat().statusCode(200).body("title",equalTo(mapToAssertAllDetails.get("title")),
               "userId",equalTo(mapToAssertAllDetails.get("userId")),
               "completed",equalTo(mapToAssertAllDetails.get("completed")));
    }
}
