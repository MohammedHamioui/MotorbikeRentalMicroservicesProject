# Microservicesproject: Motorfietsverhuurbeheer

Dit project demonstreert een microservicesarchitectuur met drie hoofdservices en een API Gateway. Het thema is motorfietsverhuur waarbij de reservaties van de klanten kan bijhouden, welke motoren ze gehuurd hebben bijvoorbeeld.

## Overzicht
- **Motorbike Service**: Beheert motorfietsinformatie.
- **Client Service**: Beheert klantinformatie.
- **Reservation Service**: Beheert reserveringen.

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

## Endpoints
**Motorbike Service:**
- GET /motorbikes - Haal alle motorfietsen op.
- GET /motorbikes/{id} - Haal motorfiets op met specifiek ID.
- GET /motorbikes/filter - Filter op merk en/of model.
- POST /motorbikes - Voeg een nieuwe motorfiets toe.
- PUT /motorbikes/{id} - Werk een motorfiets bij.
- DELETE /motorbikes/{id} - Verwijder een motorfiets.

![image](https://github.com/user-attachments/assets/d3b2ce47-7821-415a-bb4f-ab4d35bd4ca9)
![image](https://github.com/user-attachments/assets/169b6df9-b0f0-4fdd-b22f-8193d8319619)
![image](https://github.com/user-attachments/assets/89ace7f3-4c83-47e0-917b-1b2620cbe513)
![image](https://github.com/user-attachments/assets/442a8b4f-fa82-4c49-b02a-c10d8e3d0a7e)
![image](https://github.com/user-attachments/assets/05ceb75e-b9dc-458f-bf54-22991af800cb)
![image](https://github.com/user-attachments/assets/25fbe7fc-eadb-4843-beb2-dd4fb3b8cf1f)

**Client Service:**
- GET /clients - Haal alle klanten op.
- GET /clients/{id} - Haal klant op met specifiek ID.
- GET /clients/search - Zoek een klant op naam.
- POST /clients - Voeg een nieuwe klant toe.
- PUT /clients/{id} - Werk een klant bij.
- DELETE /clients/{id} - Verwijder een klant.

![image](https://github.com/user-attachments/assets/95dcd6f9-392a-4e6a-a39b-c9562c0966cb)
![image](https://github.com/user-attachments/assets/2e07f6ab-2baa-4346-800b-76eb264e5e78)
![image](https://github.com/user-attachments/assets/88796726-2728-4a4d-bdd2-0a4681abf996)
![image](https://github.com/user-attachments/assets/af7a6965-5b3e-4bc0-8e54-7ac65d435f05)
![image](https://github.com/user-attachments/assets/9bf66194-7cf3-405b-91c4-412d75f4c056)
![image](https://github.com/user-attachments/assets/46543291-3dfb-40f5-84e3-99bf99b6848c)

**Reservation Service:**
- GET /reservations - Haal alle reserveringen op.
- GET /reservations/{id} - Haal reservering op met specifiek ID.
- GET /reservations/filter - Filter op naam van klant.
- POST /reservations - Voeg een nieuwe reservering toe.
- PUT /reservations/{id} - Werk een reservering bij.
- DELETE /reservations/{id} - Verwijder een reservering.

![image](https://github.com/user-attachments/assets/4d6c67e4-060c-44f6-9bea-6c53ab3e9c84)
![image](https://github.com/user-attachments/assets/f1a17273-650c-4c8c-87a8-cce18c0f152a)
![image](https://github.com/user-attachments/assets/ce824068-90f7-4cb0-9a21-9748bbcb4f4c)
![image](https://github.com/user-attachments/assets/fae96366-6ffd-4b2e-a9c4-a966d16c1734)
![image](https://github.com/user-attachments/assets/2c7cf951-c543-4cfa-9603-e5e844b70825)
![image](https://github.com/user-attachments/assets/fe1e026a-433c-4a7a-8b5d-e8601df18784)
