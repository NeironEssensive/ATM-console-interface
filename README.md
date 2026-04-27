# 🏧 ATM Console Interface

**Where clean OOP meets real-world logic — a terminal-based ATM simulator with a Swing-powered GUI alternative.**

Not every project needs microservices. Sometimes the best way to prove you understand encapsulation, state management, and separation of concerns is to model something everyone knows: an ATM that doesn't let you withdraw what you don't have.

---

## 🎯 What This Actually Does

A fully functional ATM simulator with two output modes:

- **Console mode** (`Main.java`) — pure terminal interaction, the old-school way.
- **GUI mode** (`ATM.java`) — same logic, wrapped in a Swing interface for a more "human" experience.

Core operations: check balance, deposit, withdraw. Core rule: the ATM refuses overdrafts. As it should.

---

## 🧱 Architecture Decisions (Even in a Small Project)
📦 atm-console-interface
├── ATM.java → Business logic + Swing UI in one class (intentional for demo compactness)
├── Main.java → Entry point, console-only flow with Scanner-based input
└── .gitignore → Because uploading .class files is a sin

text

| Design Choice | Why It Matters |
|---------------|----------------|
| **Single responsibility for operations** | Deposit/withdraw/balance methods are isolated — easy to test, easy to refactor into a service layer |
| **Swing on Event Dispatch Thread** | GUI mode doesn't freeze — thread-aware from day one |
| **State is internal** | Balance is private. No external class can mutate it directly |
| **Edge cases covered** | Negative deposits rejected. Withdrawals exceeding balance blocked. No silent failures |

---

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-6DB33F?style=for-the-badge&logo=java&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-007396?style=for-the-badge&logo=java&logoColor=white)

---

## 🚀 Quick Run

```bash
# Console version
javac Main.java ATM.java
java Main

# Or just compile ATM.java and run its main() for the Swing GUI
javac ATM.java
java ATM
