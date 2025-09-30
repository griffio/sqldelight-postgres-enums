# SqlDelight 2.2.x Postgresql enum support

```sql

CREATE TYPE PRIORITY AS ENUM('low','medium','high');

CREATE TABLE Requests(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    priority PRIORITY NOT NULL,
    request_date DATE NOT NULL
);

```

See `src/main/sqldelight/griffio/migrations/V1__Initial_version.sqm` for all supported syntax.

These are mapped as "string" type, there is no compiler support yet for generating as Kotlin Enum classes.

* Recommend SqlDelight enum type adapters are used instead because they are type safe.
  https://sqldelight.github.io/sqldelight/2.1.0/jvm_postgresql/types/#enums

There maybe some performance reasons for using native enums, the trade-off is type safety outside the database is lost.

```shell
createdb enum-examples &&
./gradlew build &&
./gradlew flywayMigrate
```
