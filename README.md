# 🚀 Real-Time Chat Application with Spring Boot

A modern real-time chat application built with Spring Boot and WebSocket technology. This application enables instant messaging between users with support for group chats, typing indicators, and online status tracking.

## 🌟 Features

- 💬 Real-time messaging using WebSocket
- 👥 Group chat functionality
- ⌨️ Typing indicators   
- 🟢 Online/Offline status   
- 🔒 Secure authentication     
- 📱 Responsive design     
- 🔄 Message persistence    
- 🎨 Modern UI/UX 
 
## 🛠️ Tech Stack
 
- **Backend:** 
  - Spring Boot
  - WebSocket
  - STOMP Protocol
  - Spring Security
  - Spring Data JPA
  - MySQL/PostgreSQL

- **Frontend:**
  - React.js
  - Material-UI
  - Socket.io-client
  - Redux

## 📁 Project Structure

```
Directory structure:
└── hariharans24-realtime-chatapp-springboot/
    ├── README.md
    ├── LICENSE
    └── frontend & backend/
        ├── mvnw
        ├── mvnw.cmd
        ├── pom.xml
        ├── src/
        │   ├── main/
        │   │   ├── java/
        │   │   │   └── com/
        │   │   │       └── example/
        │   │   │           └── chattingapp/
        │   │   │               ├── ChatappApplication.java
        │   │   │               ├── config/
        │   │   │               │   ├── SecurityConfig.java
        │   │   │               │   └── WebSocketConfig.java
        │   │   │               ├── controller/
        │   │   │               │   ├── AccountController.java
        │   │   │               │   └── ChatController.java
        │   │   │               ├── model/
        │   │   │               │   ├── Account.java
        │   │   │               │   ├── ChatRoom.java
        │   │   │               │   ├── Message.java
        │   │   │               │   ├── Notification.java
        │   │   │               │   └── Status.java
        │   │   │               ├── repository/
        │   │   │               │   ├── AccountRepository.java
        │   │   │               │   ├── ChatRoomRepository.java
        │   │   │               │   └── MessageRepository.java
        │   │   │               └── service/
        │   │   │                   ├── AccountService.java
        │   │   │                   ├── ChatRoomService.java
        │   │   │                   └── MessageService.java
        │   │   └── resources/
        │   │       ├── application.properties
        │   │       ├── static/
        │   │       │   └── sql-script/
        │   │       │       └── SQLScript.txt
        │   │       └── templates/
        │   │           ├── index.html
        │   │           ├── login.html
        │   │           └── register.html
        │   └── test/
        │       └── java/
        │           └── com/
        │               └── example/
        │                   └── chattingapp/
        │                       └── ChatappApplicationTests.java
        └── target/
            └── classes/
                ├── application.properties
                ├── com/
                │   └── example/
                │       └── chattingapp/
                │           ├── config/
                │           ├── controller/
                │           ├── model/
                │           ├── repository/
                │           └── service/
                ├── static/
                │   └── sql-script/
                │       └── SQLScript.txt
                └── templates/
                    ├── index.html
                    ├── login.html
                    └── register.html
```

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- Node.js and npm
- MySQL/PostgreSQL

### Installation

1. Clone the repository:
```bash
git clone https://github.com/HARIHARANS24/realtime-chatapp-springboot.git
```

2. Configure the database in `application.properties`

3. Build and run the backend:
```bash
mvn clean install
mvn spring-boot:run
```

4. Install frontend dependencies and run:
```bash
cd frontend
npm install
npm start
```

## 🔧 Configuration

The application can be configured through `application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/chatapp
spring.datasource.username=your_username
spring.datasource.password=your_password

# WebSocket Configuration
websocket.endpoint=/ws
websocket.allowed-origins=*
```

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **HARIHARANS24** - *Initial work* - [GitHub Profile](https://github.com/HARIHARANS24)

## 🙏 Acknowledgments

- Spring Boot Team
- WebSocket Community
- All contributors and supporters 
