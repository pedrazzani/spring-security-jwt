# spring-security-jwt

### Build and Run
```
./mvnw clean spring-boot:run
```

### Login with username: user

```
Request:

curl --location --request POST 'http://localhost:8085/api/v1/auth' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'username=user' \
--data-urlencode 'password=user'

Response:

{
    "uuid": "0be1815c-a839-4f31-841d-e09eacb770da",
    "username": "user",
    "email": "user@user.com",
    "token": "token",
    "type": "Bearer"
}
```

####Call user endpoint 
```
Request:

curl --location --request GET 'http://localhost:8085/api/v1/user' \
--header 'Authorization: Bearer token'

Response:

user has permission
```

####Call admin endpoint
```
Request:

curl --location --request GET 'http://localhost:8085/api/v1/admin' \
--header 'Authorization: Bearer token'

Response:

{
    "timestamp": "2021-11-04T13:12:43.889+00:00",
    "status": 403,
    "error": "Forbidden",
    "path": "/api/v1/admin"
}
```