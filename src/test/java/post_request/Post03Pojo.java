package post_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03Pojo extends JsonplaceholderBaseUrl {
   //Pojo en cok tercih edilen yontemlerdendir.
  /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void postPojo01(){
        //1. Step: Set the Url  ===> URL'yi ayarlayın
        spec.pathParam("first","todos");

        //2. Step: Set the expected data ===> beklenen verileri ayarla
        JsonPlaceHolderPojo payload = new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("ExpectedData: "+payload);


        //3. Step: Send Post Request and get the Response ===> 3. Adım: Gönderi İsteği Gönderin ve Yanıtı alın
        Response response = given().spec(spec).contentType(ContentType.JSON).body(payload).when().post("/{first}");
        response.prettyPrint();

        //4. Step: Do Assertion
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
        System.out.println("actualData: "+actualData);
        assertEquals(payload.getUserId(),actualData.getUserId());
        assertEquals(payload.getTitle(),actualData.getTitle());
        assertEquals(payload.getCompleted(),actualData.getCompleted());
        assertEquals(201,response.getStatusCode());
    }
}
