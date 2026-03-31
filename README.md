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
