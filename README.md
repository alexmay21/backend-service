# backend-service for todos app

## How to setup
- Build the image using docker.
```
docker build -t todos-backend-service:0.0.1 .
```
- Run the image.
```
docker run -d -p 8080:8080 todos-backend-service:0.0.1
```
- View the Swagger API document on http://localhost:8080/api/swagger-ui.html