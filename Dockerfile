FROM maven:3.5.4-jdk-8 AS resolver
WORKDIR /backend/
COPY pom.xml pom.xml
RUN mvn verify --fail-never

FROM resolver AS cleaner
COPY src/ src/
RUN mvn clean

FROM cleaner AS installer
RUN mvn install -DskipTests

FROM installer AS runner
CMD ["mvn", "spring-boot:run"]