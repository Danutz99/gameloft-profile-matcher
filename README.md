## Prerequisite 
Have a MongoDB instance running before starting the server.

 Default the server points to `mongodb://localhost:27017/profile-matcher` uri, but can be changed from `application.properties:spring.data.mongodb.uri`.

 Also, the server uses `Java 17`, so you should have `JDK 17` to be able to run it.

 ## How to test
 Once the server started, you can call the following endpoint: 
 >GET http://localhost:8080/api/profilematcher/get_client_config/97983be2-98b7-11e7-90cf-082e5f28d836

 Also, you can install the `REST Client` extension in `Visual Studio Code` and open the `profilematcher.http` (`gameloft-profile-matcher\src\http\profilematcher.http`) file and test the endpoint from there.