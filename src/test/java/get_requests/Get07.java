package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends JsonplaceholderBaseUrl {
      /*
        Given
	   	    https://jsonplaceholder.typicode.com/todos
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 190 on the console
			   Assert that there are 10 ids greater than 190
			 3)Print all userIds whose ids are less than 5 on the console
			   Assert that the number of userIds whose ids are less than 5 is 4
			 4)Print all titles whose ids are less than 5
			   Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */

    @Test
    public void get01(){
        //1. Step: Set the Url
        spec.pathParam("first","todos");

        //2. Step: Set the expected data


        //3. Step: Send the request and get the response

        Response response = given().spec(spec).when().get("/{first}");
       // response.prettyPrint();

        //4. Step: Do Assertion

        response.then().assertThat().statusCode(200);


        //2)Print all ids greater than 190 on the console
        JsonPath json = response.jsonPath();
        List<Integer> ids = json.getList("findAll{it.id>190}.id");//Groovy Language = Java temelli bir proglamlama dili
        System.out.println(ids); // yukarda it yazan yer ids yi simgeliyor yani id>190 dan buyuk olan .id ver deemek istiyor

        //Assert that there are 10 ids greater than 190
        assertEquals(10,ids.size());

        // 3)Print all userIds whose ids are less than 5 on the console

        List<Integer> ids2 = json.getList("findAll{it.id<5}.userId");
        System.out.println(ids2);

        //Assert that the number of userIds whose ids are less than 5 is 4
        assertEquals(4, ids2.size());

        // 4)Print all titles whose ids are less than 5

        List<String> titles = json.getList("findAll{it.id<5}.title");
        System.out.println(titles);

        // Assert that "delectus aut autem" is one of the titles whose id is less than 5
        assertTrue(titles.contains("delectus aut autem"));
    }
}
