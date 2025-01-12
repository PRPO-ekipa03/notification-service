# Notification Service Microservice

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Setup and Installation](#setup-and-installation)
  - [Prerequisites](#prerequisites)
  - [Clone the Repository](#clone-the-repository)
  - [Build the Project](#build-the-project)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
  - [Locally](#locally)
  - [Using Docker](#using-docker)
- [API Documentation](#api-documentation)
- [Endpoints Overview](#endpoints-overview)
  - [Notification Endpoints](#notification-endpoints)
- [Error Handling](#error-handling)

## Overview
The **Notification Service** is a Spring Boot-based microservice for sending email notifications. It supports account confirmation and password reset emails.

## Features
- Send account confirmation emails.
- Send password reset emails.
- Customizable SMTP configuration for secure email delivery.

## Technologies Used
- **Java 21** with **Spring Boot**
- **Spring Mail** for email delivery
- **OpenAPI/Swagger** for API documentation
- **Maven** for build management
- **Docker** for containerization

## Architecture
The service is structured into:
- **Controller Layer**: Handles HTTP requests and responses.
- **Service Layer**: Contains business logic for email notifications.
- **Exception Handling**: Manages error responses.

---

## Setup and Installation

### Prerequisites
- Java Development Kit (JDK) 21
- Maven 3.9+
- Docker (optional)

### Clone the Repository
``bash
git clone https://github.com/PRPO-ekipa03/notification-service.git
cd notificationservice
``

### Build the Project
``bash
mvn clean package -DskipTests
``  

---

## Configuration
Set the following configuration parameters in your environment or `application.properties` file:

``properties
# Application
spring.application.name=notification-service
server.port=8086

# Mail configuration
spring.mail.protocol=smtp
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.sender.name=${SPRING_MAIL_NAME}
spring.mail.username=${SPRING_MAIL_USERNAME}
spring.mail.password=${SPRING_MAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# OpenAPI
springdoc.api-docs.path=/notifications/api-docs
springdoc.swagger-ui.path=/notifications/swagger-ui
``

---

## Running the Application

### Locally
Run the application with:
``bash
java -jar target/notification-service.jar
``  

The service will start on port 8086 or the port specified in your configuration.

### Using Docker
To containerize the application:

1. **Build the Docker Image**:  
``bash
docker build -t notification-service .
``  

2. **Run the Docker Container**:  
``bash
docker run -p 8086:8086 \
  -e SPRING_MAIL_USERNAME=your_email@gmail.com \
  -e SPRING_MAIL_PASSWORD=your_email_password \
  notification-service
``  

---

## API Documentation
The Swagger UI is available at:  
``  
http://localhost:8086/notifications/swagger-ui  
``  

---

## Endpoints Overview

### Notification Endpoints
- **Send Confirmation Email**: `POST /api/notifications/confirmation`
- **Send Password Reset Email**: `POST /api/notifications/password-reset`

---

## Error Handling
The service provides detailed error responses for common issues:
- **500 Internal Server Error**: Issues with email delivery or unexpected server errors.
