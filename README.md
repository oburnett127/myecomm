# MyEcomm
Java Ecommerce Lombok

The sql file is located in src/main/resources/db/migration/V1__Baseline.sql
There is currently no GUI for this application.

The controller calls the service implementation class and the service implementation class calls the repository implementation class.

The row mapper classes are located in the repository\util folder of my app. The row mapper classes take the data retrieved from the database for an object and they create an instance of the object and set the attribute data of the object and return the object.

The purchase and cart classes need some work still. Not all of the crud operations for those classes work currently. I use postman to test the app. 

From the command prompt I start out in my user directory and I change directory to the git\MyEcomm\MyEcomm folder. Then use the command "mvn spring-boot:run". That starts the tomcat server and then the app is running. Then I use postman.

The database file is V1__Baseline.sql, it is in resources\db\migration, I copy it into the "C:\Program Files\MySQL\MySQL Server 8.0\bin" directory and then from the mysql prompt run "source V1__Baseline.sql". That builds the database.

A lot of the configuration of the project is done inside the pom.xml file. That is where the dependencies are. Inside the resources folder there is the jdbc-config.xml and application.properties files, you might have to make modifications to those to get the app working on your pc. In application.properties, there is the line "spring.datasource.url=jdbc:mysql://localhost/myecomm"  and "myecomm" is the database name.

Make sure you configure the JAVA_HOME env variable and the JDK env variable.

To get postman to work with it, lets use the purchase class as an example, lets look at the controller class, PurchaseController, the "/purchase" above the createPurchase method tells you what to type in the postman request. The "@RequestBody Purchase purchase" parameter tells you that you need to pass a purchase object in the postman request.
/purchases is used to get all of the purchases in the purchase table, "purchase/{id}" for ex purchase/3 is used to get the data for purchase num 3. the update method is disabled for the purchasecontroller class. /purchase/delete/3 deletes purchase 3 in the database.

In postman "http://localhost:8080/account/3" is what you want to use to get the info for acct 3 with the request type set to get.
http://localhost:8080/accounts returns all accounts in the database, req type get
http://localhost:8080/account/3 req type put, does an update on acct 3, you can specify the content type as application/json in the headers and in the body use 

{
	"accountId":3,
	"email":"fakeemail@fakeemail.com",
	"firstName":"John",
	"lastName":"Doe",
	"password":"abc123",
	"isAdmin":false
}

in the body tab set the type to raw then use the above as the json for the request.
