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



CREATE TABLE app_users (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    user_name VARCHAR(255) NOT NULL,

    user_email VARCHAR(255) NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);





CREATE TABLE app_tasks (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    task_title VARCHAR(255) NOT NULL,

    task_description TEXT,

    task_status ENUM('TODO', 'IN_PROGRESS', 'DONE') DEFAULT 'TODO',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    owner_id BIGINT,

    CONSTRAINT fk_app_user FOREIGN KEY (owner_id) REFERENCES app_users(id) ON DELETE CASCADE

);