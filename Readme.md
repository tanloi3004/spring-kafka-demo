# Kafka Demo Application

This is a demo project for Spring Boot with Kafka. It includes a Kafka producer and consumer, and a Swagger UI for API documentation.

## Installation

1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd <repository-directory>
    ```

2. Copy the example environment file and modify it as needed:
    ```sh
    cp .env.example .env
    ```

## Running with Docker

1. Build and start the services using Docker Compose:
    ```sh
    docker-compose up --build
    ```

2. The application will be available at `http://localhost:8080`.

## Checking Swagger UI

1. Open your browser and navigate to `http://localhost:8080/swagger-ui.html` to access the Swagger UI.

## Testing

1. Run the tests using Maven:
    ```sh
    ./mvnw test
    ```

## Viewing Logs

1. View the logs of the running application:
    ```sh
    docker-compose logs -f app
    ```

## Kafka Topics and Consumer Groups

| Topic        | Consumer Group Name       |
|--------------|---------------------------|
| input-topic  | group-process-input-1     |
| input-topic  | group-process-input-2     |

## API Endpoints

### Publish a message to a Kafka topic

- **URL:** `/api/kafka/publish`
- **Method:** `POST`
- **Parameters:**
  - [topic](http://_vscodecontentref_/0) (query parameter, default: `input-topic`): The topic to publish to.
  - [message](http://_vscodecontentref_/1) (request body): The message to publish.

Example request:
```sh
curl -X POST "http://localhost:8080/api/kafka/publish?topic=input-topic" -H "Content-Type: application/json" -d "{\"key\":\"value\"}"
```