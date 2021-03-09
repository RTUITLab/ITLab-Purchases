# ITLab-Purchases
## Service for storing purchase data 
### Configuration

Example configuration file
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://docker-mysql:3306/lab_expenses?serverTimezone=Europe/Moscow&createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=9999
spring.datasource.platform=mysql
spring.datasource.initialization-mode=always

Key=Token
```

### Build
You can use maven on your system
```
mvn clean package
```

### Build docker-compose

```
docker-compose up --build 
```
