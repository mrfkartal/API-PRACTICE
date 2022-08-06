package post_request;

import base_urls.JsonplaceholderBaseUrl;

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


}
