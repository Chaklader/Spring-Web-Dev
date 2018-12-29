jaxrs-tutorials
===============

RESTful Web Services with JAX-RS

## cURL requests

```
curl http://localhost:8080/api/users
curl http://localhost:8080/api/users/1
curl -v http://localhost:8080/api/exception
curl http://localhost:8080/api/users -X POST -H "Content-Type: application/json" -d '{"name":"John"}'
```
