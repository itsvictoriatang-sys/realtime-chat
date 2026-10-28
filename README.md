# Real-Time Chat Application

A real-time web-based chat application built with Java, Spring Boot, WebSocket, and MySQL. The application supports instant message broadcasting, persistent message storage, and chat history retrieval through a RESTful API.

## Tech Stack

**Backend:** Java 21, Spring Boot, Spring WebSocket, Spring Data JPA, Hibernate

**Database:** MySQL

**Frontend:** HTML, CSS, JavaScript

**Build Tool:** Maven

## Features

- **Real-Time Messaging:** Enables instant communication between multiple connected clients using WebSocket.
- **Message Broadcasting:** Delivers incoming messages to all active WebSocket sessions.
- **Persistent Storage:** Stores chat messages and timestamps in MySQL using Spring Data JPA.
- **Chat History API:** Provides a RESTful endpoint for retrieving saved messages.
- **Automatic History Loading:** Restores previous messages when users refresh or reopen the chat page.
- **Connection Status:** Displays WebSocket connection status in the user interface.

## Architecture

The application follows a simple client-server architecture:

1. The browser establishes a WebSocket connection with the Spring Boot server.
2. The server receives incoming messages and saves them to MySQL.
3. The WebSocket handler broadcasts messages to connected clients.
4. The frontend retrieves stored messages through a REST API when the page loads.

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/messages` | Retrieve saved chat messages |
| WebSocket | `/chat` | Send and receive real-time messages |

## Getting Started

### Prerequisites

- Java 21
- MySQL
- Maven (or the included Maven Wrapper)

### Setup

**1. Clone the repository**

```bash
git clone https://github.com/itsvictoriatang-sys/realtime-chat.git
cd realtime-chat
```

**2. Create the MySQL database**

```sql
CREATE DATABASE realtime_chat;
```

**3. Configure the database connection**

Set the `DB_PASSWORD` environment variable to the password for your local MySQL account.

The application uses the following configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/realtime_chat
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
```

**4. Run the application**

```bash
./mvnw spring-boot:run
```

**5. Open the chat application**

Visit `http://localhost:8080` in your browser.

Open multiple browser tabs to test real-time message broadcasting.

## Project Structure

```text
src/main/
├── java/com/chatapp/realtimechat/
│   ├── config/
│   │   └── WebSocketConfig.java
│   ├── controller/
│   │   └── ChatMessageController.java
│   ├── handler/
│   │   └── ChatWebSocketHandler.java
│   ├── model/
│   │   └── ChatMessage.java
│   └── repository/
│       └── ChatMessageRepository.java
└── resources/
    ├── static/
    │   └── index.html
    └── application.properties
```

## Future Improvements

- User authentication and authorization
- Private messaging and chat rooms
- Message pagination
- Improved error handling and reconnection support

## Author

[GitHub](https://github.com/itsvictoriatang-sys)