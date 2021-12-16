# Check-in Microservice Demo Project

Testing a college project.

## Postgres running in docker

```
docker pull postgres
docker run --name checkin-postgres \
-p 5432:5432 -e POSTGRES_USER=postgres \ 
-e POSTGRES_PASSWORD=postgres \ 
-e POSTGRES_DB=checkindb \
-d postgres
```
