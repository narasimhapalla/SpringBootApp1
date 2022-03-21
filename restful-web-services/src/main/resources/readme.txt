HATEOAS -> Spring HATEOAS is used to create dynamic URI links using custom objects 

Validation -> Validation package is used to validate user input

i18n -> LocaleContextHolder is good approach

Content negotiation -> fasterxml dependency is used to support xml formats

Auto generation of swagger api -> Spring open api helps us to generate document automatically <http://localhost:8080/swagger-ui/index.html>

Actuator -> Actuator provides more details about the running produciton application. you need to add relevant management.endpoints.web.exposure.include property in properties file

HAL explorer -> Visual representation of actuator

Filtering Restfull service -> @JsonIgnore will ignore the filed in response or at class level @JsonIgnoreProperties(Static filtering)

Dynamic filtering -> Can be done using MappingJacksonValue by setting filters to this class

Version -> 
	by creating different endpoint
	content negotiation approach 
		-> Using params and value