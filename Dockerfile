FROM maven:3.5.4-jdk-8 AS resolver
WORKDIR /backend/
COPY pom.xml pom.xml
RUN mvn verify clean --fail-never
COPY . .

FROM resolver AS builder
RUN mvn compile

FROM builder AS unit-tester
RUN mvn test

FROM builder AS runner
CMD ["mvn", "spring-boot:run", "-Dspring.config.location=docker.properties"]