import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

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
    public void get01(){

        //1. Step: Set theUrl
        String url = "https://restful-booker.herokuapp.com/booking/1005";

        //2. Step: Set the expected data(Post - Put - Patch)

        //3. Step: Type code to send request

        Response response = given().when().get(url);
        response.prettyPrint();
        //4. Do Assertion

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        //Response body'de bulunan spesifik bir veri nasıl assert edilir:
        //assertTrue() methodu parantezin içindeki değer true is testi geçirir.
        assertTrue(response.asString().contains("Not Found"));


        //Response body'de spesifik bir veri bulunmadığını nasıl assert edilir:
        //assertFalse() methodu parantezin içindeki değer false is testi geçirir.
        assertFalse(response.asString().contains("TechProEd"));

        //assertEquals() methodu parantez icinde ki iki deger esit ise testi gecirir.
        assertEquals("Cowboy",response.header("Server"));

    }
}

/*
 Response response;
        try {
             response=given().when().get(url);
            response.prettyPrint();
            // 4. Step :Do Assert
            response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
            // Respon body de spesifik bir veri nasıl assert edilir
            // assertTrue methodu parentesin içi tru ise assertTrue olması beklenir
            // assertFalse ise false doneceğimizi düşündüğümüz için assertFalse kullanılıır
            assertTrue(response.asString().contains("Not Found"));
            // response body ın  spessifik bir veri bulunmadığını nasıl test edilir
            assertFalse(response.asString().contains("TechProEd"));
        }
        catch(Exception e) {
            e.printStackTrace();

 */
