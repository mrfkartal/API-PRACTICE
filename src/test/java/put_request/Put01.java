package put_request;

import base_urls.JsonplaceholderBaseUrl;

public class Put01 extends JsonplaceholderBaseUrl {


     /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									   }
     */
}
