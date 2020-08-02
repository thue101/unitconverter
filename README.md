**Unit Converter App**

**Introduction** 

UnitConverter App is a conversion application for Temperature and Distance. 

## Frameworks
## Back-end
**Spring Boot**

While the Spring framework focuses on providing flexibility to you, Spring Boot aims to shorten the code length and provide you with the easiest way to develop a web application. With annotation configuration and default codes, Spring Boot shortens the time involved in developing an application. It allows loose coupling and easy testability.
##### Spring Boot Dependency Descriptors
###### spring-boot-starter-web
Which is used for building the web application, including RESTful applications using Spring MVC. It uses Tomcat as the default embedded container.
###### spring-boot-starter-validation
Which is used for Java Bean Validation with Hibernate Validator
###### spring-boot-starter-actuator
Which provides production-ready features to help monitor the application
###### spring-boot-starter-test
Which is used to test Spring Boot application with libraries including Junit, Hamcrest and Mockito

##Installation
### **Services**

**DistanceConverter**

Create methods for converting Miles to Kilometers and Kilometers to Miles using a constant Kilometer Value of 1.60934.

**TemperatureConverters**

Create methods for converting Kelvin to Celsius and Celsius to Kelvin using a constant Kelvin Value of 273.15

######  **API REST Controllers**

Create Distance Controller and TemperatureController which will handle the API endpoints which are based on REST (Representational State Transfer). By adding RestController annotation the Spring Model View Controller will know that these are controllers.

**Temperature Controllers**

Which has a mapping of ("/conversions/ktoc") with the endpoint that will produce an output amount in celsius when given an input amount in kelvin.
And another mapping of ("/conversions/ctok")  with the endpoint that will produce an output amount in kelvin when given an input amount in celsius.

**Distance Controllers**

Which has a mapping of ("/conversions/mtok") with the endpoint that will produce an output amount in miles when given an input amount in kilometers.
And another mapping of ("/conversions/ktom")  with the endpoint that will produce an output amount in kilometers when given an input amount in miles.

###### **Running the App**

**Swagger**
It is a set of open- source tool that allows you to work with REST API endpoints.The goal of Swagger is to enable client and documentation systems to update at the same pace as the server. Enable Swagger by adding Swagger dependency into your pom.xml and then create Swagger java Configuration class. Run your app and connect to the Swagger UI on http://localhost:8080/swagger-ui.htm and post to your endpoints. 

**Testing**

Testing of services and controllers.

**Spring Boot Actuator**

Spring Boot Actuator which provides secured endpoints for monitoring and managing our Unit Converter application. Run on postman http://localhost:8080/actuator/health