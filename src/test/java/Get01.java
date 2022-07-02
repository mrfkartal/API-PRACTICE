import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

/*
   1-) Postman manuel API testi icin kullanilir.
   2-) API otomasyon icin Rest-Assured Library'yi kullanacagiz.
   3-) Otomasyon kodlarinin yazimi icin su adimlari izliyoruz:
        a) Gereksinimleri anlama- Yani bizden ne isteniyor bunu anlama
        b) Test Case'i yazma
            -) Test case yazimi icin 'Gherkin Language'  kullaniyoruz
                'Gherkin' bazi keywordlere sahip, bunlar:
                x)  Given: On kosullar icin
                y)  When: Aksiyonlar
                z)  Then: Donutler--> Assert ...
                t)  And: Coklu islemler icin kullanilir.


        c) Test kodunun yazimi

              i) Set the URL - URL'yi yazmak
              ii)Set the Expected data(POT-PUT-PATCH)-beklenen datanin kullanilmasi
              iii)Type code to send request-Talep gondermek icin kod yazacagiz
              iv)Do Assertion-Gelen data ile beklenen data uyusuyor mu buna bakacagiz
 */
    /*
    Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01(){
     //  i) Set the URL - URL'yi yazmak
        String url="https://restful-booker.herokuapp.com/booking/55";


     //  ii)Set the Expected data(POT-PUT-PATCH)-beklenen datanin kullanilmasi


     //  iii)Type code to send request-Talep gondermek icin kod yazacagiz
        Response response=given().when().get(url);

        response.prettyPrint();


     //  iv)Do Assertion-Gelen data ile beklenen data uyusuyor mu buna bakacagiz
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

     // 'Status Code' nasil yazdirilir:
        System.out.println("Status Code: "+response.statusCode());

     //'Content Type' nasil yazdirilir:
        System.out.println("Content Type: "+response.contentType());

     //'Status Line' nasil yazdirilir:
        System.out.println("Status Line:"+response.statusLine());

      //'Header' nasil yazdirilir:
        System.out.println(response.header("User-Agent"));

        //'Headers' nasil yazdirilir:
        System.out.println("Headers:\n"+response.headers());

        //'Time' nasil yazdirilir:
        System.out.println("Time:"+response.getTime());

        //'Size' nasil yazilir.
        System.out.println("Size : "+response.headers().size());

    }

}
