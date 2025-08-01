# spring-session-jdbc-postgres

### Start PostgreSQL Server in Docker

```bash
docker run -d \
  --name spring-session-postgres \
  -e POSTGRES_DB=session_db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=password \
  -p 5432:5432 \
  postgres:16
```

### Connect with `psql`

```bash
docker run -it --rm \
  --network host \
  postgres:16 \
  psql -h localhost -U postgres -d session_db
```

### Verify via logs

```bash
docker logs spring-session-postgres
```
