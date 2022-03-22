HATEOAS -> Spring HATEOAS is used to create dynamic URI links using custom objects (Hyper media as the engine of application state)

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
		-> Using request params and value
		-> Using request header and value
		-> produces via headers (MIME type version)
		
Richardson maturity model (REST)
	level 0 -> exposing SOAP service in restful style. Like an action in the form for url http://server/getPosts
	level 1 -> exposing with proper URI. http://server/accounts/10
	level 2 -> level 1+ proper use of http methods
	level 3 -> level 2 + HATEOAS. Next possible actions

Restful service best practices
	-> Understand the user(consumer First)
	-> Make best use 0f Http methods
	-> Proper response status even in case of failures
	-> No secure info in URI
	-> think about nouns (Like account not the user)
	-> consistent approach in exceptions
	
	
		