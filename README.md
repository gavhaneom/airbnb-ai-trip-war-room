# AI Trip War Room — Java + React + MySQL starter

A beginner-friendly starter for the Internmo Full Stack Development project.
This is an independent educational project inspired by the requirements document; it is not an official Airbnb product.

## Stack
- Backend: Java 21, Spring Boot 3.3, Spring Data JPA, Bean Validation
- Database: MySQL 8
- Frontend: React + Vite
- API: REST

## Included in this starter
- Create and list trip rooms
- View and create venue records
- MySQL configuration and Docker Compose
- Simple React dashboard connected to the backend
- Basic validation and error responses

Not implemented yet: JWT/RBAC, WebSocket collaboration, AI/RAG, voting, expense splitting, recommendations, automated tests and deployment. Add these in later milestones.

## Requirements
- JDK 21+
- Maven 3.9+
- Node.js 20+
- Docker Desktop (recommended), or a local MySQL 8 server

## 1. Start MySQL
From this folder:
```bash
docker compose up -d
```
MySQL database: `trip_war_room`
Username: `tripuser`
Password: `trip_password_change_me`

For a local MySQL server, create the database manually:
```sql
CREATE DATABASE trip_war_room;
```
Then set `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` environment variables as needed.

## 2. Run the backend
```bash
cd backend
mvn spring-boot:run
```
Backend: http://localhost:8080

Useful endpoints:
- `GET http://localhost:8080/api/v1/trips`
- `POST http://localhost:8080/api/v1/trips`
- `GET http://localhost:8080/api/v1/venues`
- `POST http://localhost:8080/api/v1/venues`

Example create-trip JSON:
```json
{
  "name": "Lisbon Group Trip",
  "destination": "Lisbon, Portugal",
  "startDate": "2026-12-10",
  "endDate": "2026-12-14",
  "totalBudget": 1200.00,
  "maxParticipants": 8
}
```

Example create-venue JSON:
```json
{
  "destination": "Lisbon, Portugal",
  "name": "Sample Vegetarian Bistro",
  "category": "RESTAURANT",
  "pricePerPerson": 22.00,
  "dietaryTags": "vegetarian,vegan",
  "hoursOpen": "11:00",
  "hoursClose": "22:00",
  "latitude": 38.7139,
  "longitude": -9.1394,
  "description": "Sample locally-authored venue data for development."
}
```

## 3. Run the frontend
Open a second terminal:
```bash
cd frontend
npm install
npm run dev
```
Open the URL printed by Vite (usually http://localhost:5173).

## Configuration
Backend defaults are in `backend/src/main/resources/application.properties`.
Override credentials with environment variables:
- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`

Do not commit real passwords, API keys, or other secrets. The included Docker credentials are local development defaults; change them before sharing/deploying.

## Suggested next build order
1. Add user registration/login, password hashing, JWT and server-side roles.
2. Add trip membership and invite codes.
3. Add itinerary items and version-based conflict handling.
4. Add WebSocket room synchronization and chat.
5. Add budget split calculations and tests.
6. Add deterministic venue constraint filtering, then grounded AI/RAG.
7. Add voting, conflict detection, recommendations and analytics.
