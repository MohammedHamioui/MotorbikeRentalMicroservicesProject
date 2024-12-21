# Microservicesproject: Motorfietsverhuurbeheer

Dit project demonstreert een microservicesarchitectuur met drie hoofdservices en een API Gateway. Het thema is motorfietsverhuur.

## Overzicht
- **Motorbike Service**: Beheert motorfietsinformatie.
- **Client Service**: Beheert klantinformatie.
- **Reservation Service**: Beheert reserveringen.

# Microservicesproject: Motorfietsverhuurbeheer

Dit project demonstreert een microservicesarchitectuur met drie hoofdservices en een API Gateway. Het thema is motorfietsverhuur.

## Overzicht
- **Motorbike Service**: Beheert motorfietsinformatie.
- **Client Service**: Beheert klantinformatie.
- **Reservation Service**: Beheert reserveringen.
- **API Gateway**: Verbindt de microservices en biedt beveiliging via OAuth2 en JWT.

## Technologieën
- Spring Boot
- Spring Cloud Gateway
- OAuth2 + JWT
- Docker
- MongoDB + MySQL

## Aantoonbare Werking
De werking van alle endpoints is getest via Postman en functioneert zoals verwacht.

## Installatie

1. **Clone de repository:**
   ```bash
   git clone https://github.com/MohammedHamioui/MotorbikeRentalMicroservicesProject.git

2. **Navigeer naar de projectdirectory:**
    ```bash
    cd MotorbikeRentalMicroservicesProject

3. **Start de applicatie met Docker Compose:**
    ```bash
    docker-compose up --build

## Toegang tot de services:
- **API Gateway:** http://localhost:8083
- **Motorbike Service:** http://localhost:8080
- **Client Service:** http://localhost:8081
- **Reservation Service:** http://localhost:8082

## Authenticatie en Autorisatie:
**De API Gateway maakt gebruik van OAuth2 en JWT voor beveiliging.**

**OAuth2 Server:** Verantwoordelijk voor het verstrekken van JWT-tokens.
JWT: Wordt gebruikt voor het verifiëren van verzoeken aan de microservices.

## Databaseconfiguratie
- **Motorbike Service:** Maakt gebruik van MySQL.
- **Client Service:** Maakt gebruik van MySQL.
- **Reservation Service:** Maakt gebruik van MongoDB.