package post_request;
import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Post04Pojo extends HerOkuAppBaseUrl {
    /*
      Given
         https://restful-booker.herokuapp.com/booking
         {
             "firstname": "Ali",
             "lastname": "Can",
             "totalprice": 999,
             "depositpaid": true,
             "bookingdates": {
                 "checkin": "2021-09-21",
                 "checkout": "2021-12-21"
                  },
              "additionalneeds": "Breakfast with white tea"
          }
     When
          I send POST Request to the URL
      Then
          Status code is 200
      And
          Response body is like {
                                  "bookingid": 16,
                                  "booking" :{
                                     "firstname": "Ali",
                                     "lastname": "Can",
                                     "totalprice": 999,
                                     "depositpaid": true,
                                     "bookingdates": {
                                         "checkin": "2021-09-21",
                                         "checkout": "2021-12-21"
                                     }
                                     "additionalneeds": "Breakfast with white tea"
                                  }
                               }
  */
    @Test
    public void post01(){
        //1. Step: Set the Url
        spec.pathParam("first", "booking");

        //2. Step: Set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2021-09-21","2021-12-21");
        BookingPojo bookingPojo = new BookingPojo("Ali", "Can", 999,true,bookingDatesPojo, "Breakfast with white tea" );

        //3. Step: Send the Post request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(bookingPojo).when().post("/{first}");
        response.prettyPrint();

        //4. Step: Do Assertion
        BookingResponseBodyPojo actualPojo = response.as(BookingResponseBodyPojo.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(bookingPojo.getFirstname(), actualPojo.getBooking().getFirstname());
        assertEquals(bookingPojo.getLastname(), actualPojo.getBooking().getLastname());
        assertEquals(bookingPojo.getTotalprice(), actualPojo.getBooking().getTotalprice());
        assertEquals(bookingPojo.getDepositpaid(), actualPojo.getBooking().getDepositpaid());
        assertEquals(bookingPojo.getAdditionalneeds(), actualPojo.getBooking().getAdditionalneeds());

        //1. Way: Can be used
        assertEquals(bookingPojo.getBookingdates().getCheckin(), actualPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingPojo.getBookingdates().getCheckout(), actualPojo.getBooking().getBookingdates().getCheckout());

        //2. Way: Recommended
        assertEquals(bookingDatesPojo.getCheckin(), actualPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualPojo.getBooking().getBookingdates().getCheckout());
    }
}
