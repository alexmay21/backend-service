# backend-service
A backend service for a To-do App.

## Get started
There are multiple ways of running backend-service.

### Build from source
- Build the project
```
mvn -Dmaven.test.skip=true clean install
```
- Build the image using docker.
```
docker build -t todos-backend-service:0.0.1 .
```
- Run the image.
```
docker run -d -p 8080:8080 todos-backend-service:0.0.1
```
- View the Swagger API document on http://localhost:8080/api/swagger-ui.html

### Or just run with uploaded image
- ```docker run -d -p 8080:8080 meileim/todos-backend-service:0.0.1```