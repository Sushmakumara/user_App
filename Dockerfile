# build stage
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /src

# copy pom.xml first (to download dependencies)
COPY NIEUserApp/pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# copy source code and build
COPY NIEUserApp/src ./src
RUN mvn -q -DskipTests package

# run stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /src/target/*.war app.war

# expose default port
EXPOSE 9900

# allow overriding port via ENV PORT, fallback = 9900
ENTRYPOINT ["sh","-c","java -Dserver.port=${PORT:-9900} -jar app.war"]

