phase2 update
# EECS3311-ServiceBooking

GitHub Repository URL:  
https://github.com/dogran-0104/EECS3311-ServiceBooking.git

EECS 3311 Course Project – Service Booking & Consulting Platform

---

## Project Overview

This project implements a Service Booking & Consulting Platform that allows clients to browse consulting services, request bookings, manage payments, and interact with an AI-powered customer assistant. Consultants can manage availability and respond to booking requests, while admins can review and manage booking operations.

Phase 2 extends the Phase 1 system with:
- completed frontend pages for core workflows
- Docker-based deployment
- PostgreSQL database persistence
- AI Customer Assistant integration

This phase builds directly on the Phase 1 backend and frontend design.

---

## Phase 2 Features

### Client Features
- Browse consulting services
- Request bookings
- Cancel bookings
- View booking history
- Process payments
- Manage payment methods
- View payment history
- Access AI Customer Assistant chatbot

### Consultant Features
- Manage availability
- Accept or reject booking requests
- View booking schedule

### Admin Features
- Approve consultants
- View booking and payment system status
- Manage booking workflow actions

---

## Backend Overview

The backend is implemented with Spring Boot and PostgreSQL.

Main backend responsibilities include:
- service catalog management
- consultant management and approval
- booking lifecycle handling
- availability management
- payment processing and payment records
- payment method storage
- cancellation and policy handling
- AI chatbot backend integration

---

## Frontend Overview

The frontend is implemented as static HTML pages served through a separate Docker container.

Main pages:
- `index.html` – browse services and access chatbot
- `booking.html` – request booking, load services, load slots, view bookings
- `admin.html` – load bookings, accept/reject/cancel bookings, process payments, load payment history

The frontend communicates with the backend through REST APIs.

---

## AI Customer Assistant

The AI Customer Assistant is accessible from the client homepage.

### Chatbot Features
The chatbot can answer general questions about:
- how booking works
- payment methods
- cancellation information
- available services
- consultant availability
- admin functions

### Chatbot API
`POST /api/chatbot/ask`

### Current Implementation
The chatbot is implemented as a backend-integrated rule-based assistant for Phase 2 demonstration. It is designed to provide safe, general platform guidance rather than access user-specific data.

See `AI_CHATBOT_DOCUMENTATION.md` for full details.

---

## Docker Deployment

The system is deployed with Docker using three containers:
- backend service container
- frontend service container
- database container

### Required files
- `backend/service-booking/Dockerfile`
- `frontend/Dockerfile`
- `docker-compose.yml`

### Run the system
From the project root:

```bash
docker compose up --build

### Stop the system
docker compose down

### Access points
Frontend home page: http://localhost:3000
Booking page: http://localhost:3000/booking.html
Admin page: http://localhost:3000/admin.html
Backend API example: http://localhost:8080/api/services

### Database

The project uses PostgreSQL for persistence.

Persisted entities include:

services
consultants
bookings
availability slots
payment records
saved payment methods

The database is started inside Docker and connected to the backend through environment variables.

### Environment Variables
A sample environment configuration is included in:
.env.example

Important notes:

real secrets must not be committed to GitHub
.env.example only contains template values
actual API keys or passwords should only be stored locally if needed

### Design Patterns Used

Examples of design patterns used in the project include:

Factory Pattern for payment method creation
Strategy-related behavior for payment processing and policy handling
Policy abstraction for cancellation/system rule logic

These patterns were implemented in the backend and extended through Phase 2.

### Project Structure
EECS3311-ServiceBooking/
|-- backend/
|   |-- service-booking/
|   |   |-- src/
|   |   +-- Dockerfile
|-- frontend/
|   |-- index.html
|   |-- booking.html
|   |-- admin.html
|   |-- default.conf
|   +-- Dockerfile
|-- diagrams/
|-- docker-compose.yml
|-- .env.example
|-- AI_CHATBOT_DOCUMENTATION.md
+-- README.md

Team Contributions
### Qinsong Chang — Phase 2 Integration Lead, Documentation, Docker, AI Assistant, Frontend-Backend Integration
Led the overall Phase 2 extension and integration work based on the Phase 1 system.
Updated and maintained the main project documentation:
README.md
AI_CHATBOT_DOCUMENTATION.md
.env.example
Implemented Docker deployment setup:
backend Dockerfile
frontend Dockerfile
docker-compose.yml
environment-variable-based configuration
Integrated PostgreSQL persistence into the backend and helped validate database-connected workflows.
Implemented and integrated the AI Customer Assistant:
ChatbotController.java
ChatbotService.java
chatbot frontend interface on the client homepage
Coordinated key Phase 2 frontend-backend connections to ensure:
services load correctly
booking page works with backend APIs
admin page works with backend APIs
chatbot works through backend integration
Continued maintaining diagrams and overall submission readiness.

### Kentty Alexander Li Tan — Frontend Completion and Client/Admin UI Workflow
Extended the frontend from the Phase 1 static UI into a more complete Phase 2 interface.
Updated and maintained frontend pages:
frontend/index.html
frontend/booking.html
frontend/admin.html
Implemented and refined client-side interactions for:
browsing services
requesting bookings
loading consultant slots
viewing booking results
admin booking actions
payment-related UI flow
Helped ensure the frontend pages worked correctly after Docker deployment.

###Yaohang Tang — Booking, Availability, and Consultant Workflow
Extended backend booking logic to support persistent Phase 2 workflows.
Maintained and improved:
BookingController
BookingService
Booking and BookingStatus
Supported consultant-related workflow logic, including:
booking request handling
availability validation
consultant slot loading
consultant accept/reject flow
Helped align booking lifecycle behavior with frontend and database integration.

### Eric Xu — Payment Module, Policy Logic, and Administrative Operations
Extended and maintained the payment subsystem for Phase 2:
payment processing flow
payment records
payment-related endpoints
payment history support
Continued work on design-pattern-based payment implementation:
PaymentFactory
PaymentMethod and method-specific implementations
PaymentService
PaymentRecord
Maintained and extended cancellation and policy-related backend logic:
policy abstractions
cancellation decision handling
policy service behavior
Supported admin-side operations connected to payment and booking control.
Notes

This project focuses on:

proper backend design
integration between frontend and backend
Docker-based deployment
database persistence
safe AI assistant integration

The AI assistant only provides general platform information and does not access personal booking data or private user information.


phase1
# EECS3311-ServiceBooking
https://github.com/dogran-0104/EECS3311-ServiceBooking.git
EECS 3311 Course Project - Service Booking &amp; Consulting Platform
## Team Contributions

### Kentty Alexander Li Tan — Frontend UI & User Flow
- Built and maintained the static web pages under `resources/static/`:
  - `index.html`, `booking.html`, `admin.html`
- Connected UI interactions to backend endpoints (services listing, booking submission, admin actions).
- Prepared the end-to-end user flow narrative for presentation (user view → booking → admin view).

### Yaohang Tang — Booking Workflow (Booking + Availability)
- Implemented booking-related backend logic:
  - Controllers/Services for booking operations (`BookingController`, `BookingService`).
- Implemented availability checking to validate bookings (`AvailabilityService`).
- Managed booking domain models and state transitions (`Booking`, `BookingStatus`) to support the booking lifecycle.

### Qinsong Chang — Diagrams, README, Service Catalog & Consultant Management (UC11 Support)
- Created project documentation and deliverables:
  - Produced Phase 1 diagrams in `diagrams/` (Use Case Diagram + Class Diagram).
  - Wrote and maintained `README.md` (architecture overview, patterns used, run instructions, repo link, and contributions).
- Implemented service listing functionality:
  - Service catalog source (`ServiceCatalog`) and service model (`ServiceItem`).
  - REST endpoint for services: `GET /api/services` via `ServiceController`.
- Implemented consultant management logic:
  - Consultant operations and approval state handling in `ConsultantService` with model `Consultant`.
  - Admin endpoints for UC11 consultant approval workflow via `AdminController`:
    - `GET /api/admin/consultants`
    - `POST /api/admin/consultants/{id}/approve`
    - `POST /api/admin/consultants/{id}/reject`

### Eric Xu — Payment Module & Cancellation Policy (Design Patterns Focus)
- Implemented the extensible payment subsystem:
  - Payment creation using Factory-based design (`PaymentFactory`, `PaymentMethod` + multiple implementations).
  - Payment processing and records (`PaymentService`, `PaymentRecord`).
  - Payment endpoints via `PaymentController`.
- Implemented cancellation policy subsystem:
  - Policy interface and default implementation (`CancellationPolicy`, `DefaultCancellationPolicy`).
  - Decision models and policy execution (`CancellationDecision`, `PolicyService`).
