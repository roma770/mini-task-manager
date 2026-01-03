# Mini Menedżer Zadań (Fullstack Java/Spring Boot)

Projekt samouczka dotyczący tworzenia systemu zarządzania zadaniami opartego na użytkownikach.

## 🚀 Główna funkcjonalność
- **Zarządzanie użytkownikami:** Rejestracja (z walidacją adresu e-mail) i przeglądanie listy.
- **Zarządzanie zadaniami:** Tworzenie zadań dla konkretnego użytkownika wraz z opisami i statusami.
- **Status interaktywny:** Zmiana statusu (DO ZROBIENIA -> W_TOKU -> GOTOWE) za pomocą żądań PATCH.
- **UX/UI:** Wskaźnik ładowania..., powiadomienia o błędach i responsywny projekt oparty na Bootstrapie.

## 🛠 Stos technologiczny
- **Backend:** Java 17+, Spring Boot 3.x, Spring Data JPA.
- **Baza danych:** MySQL (phpMyAdmin).
- **Frontend:** HTML5, CSS3 (Bootstrap 5), JavaScript (Fetch API).

## 📂 Schemat bazy danych
Dla aplikacji utworzono dwie tabele: `app_users` i `app_tasks` z relacją jeden do wielu.

## ⚙️ Jak uruchomić
1. Sklonuj repozytorium: `git clone https://github.com/roma770/mini-task-manager.git`
2. Skonfiguruj połączenie z bazą danych w `application.properties`.
3. Uruchom projekt w IntelliJ IDEA.
4. Otwórz `http://localhost:8080` w przeglądarce.