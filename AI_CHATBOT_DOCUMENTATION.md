# AI Customer Assistant Documentation

## 1. Overview
The Service Booking & Consulting Platform includes an AI-powered Customer Assistant chatbot accessible from the client homepage.

The chatbot helps users understand how the platform works. It answers general questions about:
- booking steps
- available services
- payment methods
- cancellation information
- consultant availability
- admin features

This chatbot is implemented through the backend API and displayed in the frontend client interface.

---

## 2. Where the Chatbot Appears
The chatbot is accessible from the client interface on the frontend home page.

Example access points:
- Frontend: `http://localhost:3000`
- Chatbot API endpoint: `POST /api/chatbot/ask`

---

## 3. Current Implementation Approach
This project uses a backend-integrated rule-based assistant for Phase 2 demonstration.

### Backend components
- `ChatbotController.java`
- `ChatbotService.java`

### Frontend integration
The frontend home page includes:
- a text area for entering a question
- a button to submit the question
- a visible answer area for displaying the response

### API workflow
1. Client opens the chatbot UI on the frontend
2. Client enters a question
3. Frontend sends a POST request to `/api/chatbot/ask`
4. Backend receives the question
5. `ChatbotService` generates a response based on platform knowledge and predefined rules
6. Backend returns the answer as JSON
7. Frontend displays the answer

---

## 4. Example Questions the Chatbot Can Answer
Examples supported in the current version include:

- **How do I book a consultant?**
- **What payment methods are supported?**
- **Can I cancel a booking?**
- **What services are available?**
- **How does consultant availability work?**
- **What can the admin do in the system?**

Example response:
- Booking explanation step-by-step
- Supported payment methods: credit card, debit card, PayPal, bank transfer
- General cancellation explanation
- General service categories available in the system

---

## 5. System Context Provided to the Chatbot
The chatbot only uses general platform information such as:
- public platform workflows
- service categories and descriptions
- general booking lifecycle states
- general payment method information
- general cancellation and admin workflow explanations

The chatbot does **not** use private user-specific or booking-specific details.

---

## 6. Privacy and Safety Measures
The chatbot follows the project privacy requirements:

- It is integrated through the **backend service**
- It does **not directly access the database**
- It does **not access personal user data**
- It does **not access payment details**
- It does **not access private booking details**
- It only returns **general informational responses**
- It does **not perform automated actions** such as creating, cancelling, or paying for bookings

This design reduces privacy risk and ensures the chatbot is used only as an informational assistant.

---

## 7. API Integration
### Request
`POST /api/chatbot/ask`

Example request body:
```json
{
  "question": "How do I book a consultant?"
}
{
  "answer": "To book a consulting session: 1. Open the booking page..."
}
## 8. Why This Approach Was Chosen

For Phase 2, the focus is system integration and safe design rather than model training.

A rule-based backend assistant was chosen because it:

is stable for demo purposes
does not require external API credits
avoids API key dependency for grading
respects privacy constraints
demonstrates correct frontend-backend integration
## 9. Future Improvements

Possible future enhancements:

connect to OpenAI, Gemini, or Claude
expand system context dynamically from public service descriptions
improve response quality with prompt templates
support FAQ ranking and richer conversational flow
