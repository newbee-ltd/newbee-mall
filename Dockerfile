# Build stage
FROM maven:3.8.8-eclipse-temurin-8-alpine AS builder

WORKDIR /build

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Package application (skip tests for faster build)
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:8-jre-alpine

WORKDIR /app

# Create upload directory to support default path in Constants.java
RUN mkdir -p /app/upload 'D:\upload\' /opt/image/upload/

# Copy the built jar from builder stage
COPY --from=builder /build/target/newbee-mall-*.jar /app/app.jar

# Expose server port
EXPOSE 28089

# JVM options and run application
ENV JAVA_OPTS="-Xms512m -Xmx512m -Dfile.encoding=UTF-8 -Duser.timezone=Asia/Shanghai"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
