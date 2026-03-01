# Still-In-Session 🔐

A minimal Java Servlet web application demonstrating **HTTP Session Management** — creating, using, and destroying sessions.

Built with Jakarta Servlets on an embedded Tomcat 10 server, perfect for understanding how sessions work in Java web development.

---

## 📋 Application Flow

```
┌──────────────┐    POST /login    ┌───────────────┐    GET /welcome    ┌─────────────────┐
│  login.html  │ ───────────────→  │ LoginServlet  │ ────────────────→  │ WelcomeServlet  │
│              │   (username)      │               │   (redirect)       │                 │
│ ┌──────────┐ │                   │ • getSession()│                    │ • getSession(f) │
│ │ Username │ │                   │ • setAttribute│                    │ • getAttribute  │
│ └──────────┘ │                   └───────────────┘                    │ • "Welcome, X!" │
│  [ Login ]   │                                                       │ • [Logout]      │
└──────────────┘                                                       └────────┬────────┘
       ↑                                                                        │
       │              ┌────────────────┐                              GET /logout│
       └──────────────│ LogoutServlet  │ ←──────────────────────────────────────┘
        login again   │                │
                      │ • invalidate() │
                      │ • "Logged out" │
                      └────────────────┘
```

---

## 🚀 How to Run

### Prerequisites
- **Java 17+** installed
- **Gradle** installed (or use `gradlew`)

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/Srivastava23/Still-In-Session.git
cd Still-In-Session

# 2. Run the embedded Tomcat server
gradle appRun

# 3. Open in browser
# http://localhost:8080/SessionDemo/
```

> Press any key in the terminal to stop the server.

---

## 📁 Project Structure

```
Still-In-Session/
├── build.gradle                  # Gradle + Gretty (embedded Tomcat 10)
├── settings.gradle               # Project name
└── src/main/
    ├── java/com/session/
    │   ├── LoginServlet.java     # Creates session, stores username
    │   ├── WelcomeServlet.java   # Reads session, shows welcome
    │   └── LogoutServlet.java    # Invalidates session
    └── webapp/
        ├── login.html            # Login form (entry point)
        └── WEB-INF/
            └── web.xml           # Servlet URL mappings
```

---

## 🔑 Key Session Methods

| Method | Purpose |
|--------|---------|
| `request.getSession()` | Creates new session or gets existing one |
| `request.getSession(false)` | Gets existing session only (returns `null` if none) |
| `session.setAttribute("key", val)` | Stores data in the session |
| `session.getAttribute("key")` | Reads data from the session |
| `session.invalidate()` | Destroys the session and all its data |
| `session.getId()` | Returns the unique session ID |

---

## 📄 Servlet Details

### LoginServlet (`/login`)
- Reads `username` from the POST form
- Creates a new HTTP session using `getSession()`
- Stores the username: `session.setAttribute("user", username)`
- Redirects to the welcome page

### WelcomeServlet (`/welcome`)
- Gets the existing session using `getSession(false)` — does **not** create a new one
- Reads the username using `getAttribute("user")`
- Displays "Welcome, username!" with the session ID
- If no session exists → shows "Session expired. Please login again."

### LogoutServlet (`/logout`)
- Gets the existing session
- Calls `session.invalidate()` to destroy the session
- Shows "You have been logged out successfully."
- Provides a link back to the login page

---

## 🛠 Tech Stack

| Component | Technology |
|-----------|------------|
| Language | Java 17 |
| Servlet API | Jakarta Servlet 6.0 |
| Server | Embedded Tomcat 10.1.19 (via Gretty plugin) |
| Build | Gradle 8.13 |
| Frontend | Plain HTML |

---

## 📝 License

This project is for educational/lab purposes.
