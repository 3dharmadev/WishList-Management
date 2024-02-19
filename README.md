# Wishlist Management API

This project is a Spring Boot application for managing wishlists.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Wishlist Management API is designed to help users manage their wishlists. It provides endpoints for adding, retrieving, and deleting wishlist items.

## Features

- User registration
- Add wishlist items
- Retrieve wishlist items
- Delete wishlist items

## Getting Started

### Prerequisites

- [Java Development Kit (JDK)](https://adoptopenjdk.net/)
- [Apache Maven](https://maven.apache.org/download.cgi)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/wishlist-management.git
    ```

2. Navigate to the project directory:

    ```bash
    cd wishlist-management
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

The application will start, and you can access the API at `http://localhost:8080`.

## Usage

- Register a user using the `/api/users/register` endpoint.
- Manage wishlist items using the `/api/wishlists` endpoints.

## API Endpoints

- **POST /api/users/register**: Register a new user.

  ```json
  {
    "username": "exampleUser",
    "password": "examplePassword"
  }
