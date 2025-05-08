# Quarkus Kotlin Sample

This project is a minimalistic example demonstrating how to build a RESTful API using [Quarkus](https://quarkus.io/) with [Kotlin](https://kotlinlang.org/). It showcases the integration of Kotlin with Quarkus, including REST endpoints, JSON serialization, and native image generation using GraalVM.

## 🚀 Features

- Built with Kotlin and Quarkus
- RESTful API using JAX-RS (RESTEasy)
- JSON serialization with JSON-B
- Native image generation via GraalVM
- Docker support for containerized deployment

## 🛠 Prerequisites

Ensure you have the following installed:

- Java 1.8 or later
- [GraalVM](https://www.graalvm.org/docs/getting-started/#install-graalvm) (for native image generation)
- [Docker](https://www.docker.com/get-started)

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./gradlew build -Dquarkus.native.enabled=true
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./gradlew build -Dquarkus.native.enabled=true -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/quarkus-rest-api-1.0-SNAPSHOT-runner`


## 🧪 Running in Development Mode
Quarkus offers a development mode that enables live coding with background compilation.
   ```bash
   ./gradlew quarkusDev
```
Access the application at http://localhost:8080

Dev UI available in dev mode at <http://localhost:8080/q/dev/>.


## Related Guides

- REST resources for Hibernate ORM with Panache ([guide](https://quarkus.io/guides/rest-data-panache)): Generate Jakarta
  REST resources for your Hibernate Panache entities and repositories
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes
  with Swagger UI
- Kotlin ([guide](https://quarkus.io/guides/kotlin)): Write your services in Kotlin
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and
  more
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC
