---

# FootballApp

A simple Spring Boot application that retrieves football player information using a third-party API based on a provided name.

---

## Features

- Accepts a player's name as input through a REST endpoint.
- Fetches player details (ID, name, age, country) from a third-party football API.
- Parses the JSON response and returns the first player matching the name.

---

## Prerequisites

Ensure you have the following installed:

- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/)
- A valid API key for the [Football API](https://www.api-football.com/).

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/ionutconstantin-dev/FootballApp.git
   ```
2. Navigate to the project directory:
   ```bash
   cd FootballApp
   ```
3. Open the project in your preferred IDE and ensure all dependencies are installed.

---

## Configuration

Update the API key in your application by editing the `Constants` class:
```java
public class Constants {
    public static final String API_KEY = "your-api-key-here";
}
```

---

## Usage

### Running the Application

1. Start the application:
   ```bash
   mvn spring-boot:run
   ```
2. Access the endpoint in your browser or API client (e.g., Postman):
   ```
   GET http://localhost:8080/players?name=<player_name>
   ```
   Replace `<player_name>` with the name of the football player you want to search for.

### Example Request
```bash
curl http://localhost:8080/players?name=Messi
```

### Example Response
```json
{
  "id": 12345,
  "name": "Lionel Messi",
  "age": 36,
  "country": "Argentina"
}
```

---

## Project Structure

- **Player**: Model class representing a football player (ID, name, age, country).
- **Controller**: Handles the REST API endpoint.
- **Service**: Calls the third-party API, parses the JSON response, and retrieves player data.

---

## Technologies Used

- **Spring Boot**: For building the application.
- **Gson**: For JSON parsing.
- **Java HttpClient**: For making HTTP requests.
- **API-Football**: Third-party service providing football player data.

---

## Contact

If you have any questions or suggestions, feel free to reach out:

- **Email**: ionutconstantin.dev@gmail.com
- **GitHub**: [ionutconstantin-dev](https://github.com/ionutconstantin-dev)

---
