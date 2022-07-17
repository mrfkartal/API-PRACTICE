package get_requests;

import base_urls.GorestBaseUrl;

public class Get10 extends GorestBaseUrl {
     /*
        Given
            https://gorest.co.in/public/v1/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
                {
                 https://gorest.co.in/public/v1/users/2965
        {
    "meta": null,----> 1.map suslu parantez
    "data": { ----> 2.map suslu parantez var
        "id": 2986,
        "name": "Susheel Bharadwaj",
        "email": "bharadwaj_susheel@dibbert-casper.org",
        "gender": "female",
        "status": "inactive"
   }
   }
     */
}
