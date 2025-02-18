# Tech Challenger FIAP F4

Welcome to the **Power Programmers Customers** project repository.

## 🎓 Academic Project

Developed as part of the **Java Architecture and Development** postgraduate course at FIAP.

## 👨‍💻 Developers

- Edson Antonio da Silva Junior
- Gabriel Ricardo dos Santos
- Luiz Henrique Romão de Carvalho
- Marcelo de Souza

## 💡 Technologies

![Java](https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-3.9.9-C71A36?style=for-the-badge&logo=apachemaven)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-336791?style=for-the-badge&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-27.4.0-2496ED?style=for-the-badge&logo=docker)
![Swagger](https://img.shields.io/badge/Swagger-3.0-85EA2D?style=for-the-badge&logo=swagger)

## 📦 Project Structure

```plaintext
📦 br.com.powerprogramers.customer_ms
├── configuration       // Application settings
├── 🎯 domain
│   ├── controller      // REST controllers
│   ├── dto             // Data Transfer Objects (DTOs)
│   ├── entity          // Database models
│   ├── exception       // Custom exceptions
│   ├── gateway         // Object mapping
│   ├── mappers         // Object mapping
│   ├── repository      // Data access layer
│   └── service         // Business logic
│
└── 🚀 CustomerMsApplication.java
```

## 🎥 Introducing the Microservice

[Tech Challenge F4 - MS Customer - Introduction Video](https://www.youtube.com/watch?v=R95VSGSQ-nI)

## ▶️ How to Run the Project

Follow the steps below to run the project locally:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Power-Rangers-FIAP/tc-f4-ms-customer.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd tc-f4-ms-customer
   ```
3. **Build the project with Maven:**
   ```bash
   mvn clean install -U
   ```
4. **Start the application locally:**
   ```bash
   mvn spring-boot:run
   ```

## 🧪 Running Tests

To run unit tests, execute the following command:

```bash
mvn test
```

## 📌 API Endpoints

The API can be explored and tested using Swagger. The documentation is available at:

[Swagger UI](http://localhost:8080/swagger-ui/index.html)

## 🤝 Contributing

Contributions are welcome! To contribute, follow these steps:

1. Fork the repository.
2. Create a branch for your feature or fix (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push your changes to the repository (`git push origin feature/new-feature`).
5. Open a pull request.

## 📜 License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

