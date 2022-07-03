# Simple Users API

Endpoints to register users, retrieve them, edit them and delete them.

## How to Use

1. Download the repository and let maven install all dependencies.
2. Configure application.properties with the model below with your database credentials

```
spring.jpa.database=POSTGRESQL
spring.datasource.platform=postgres
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.database.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:databaseURL
spring.datasource.username=login
spring.datasource.password=password
```
3. Run src/main/java/com/crud/mycrud/MycrudApplication.java as a Java Application


