# 📱 OmniHub: All-in-One Utility Companion

OmniHub is a feature-rich, high-performance Android utility application built using **Android Studio**. Designed to be the ultimate digital Swiss Army knife, it seamlessly consolidates essential device controls, real-time cloud data management, built-in entertainment modules, and productivity tools into a single, intuitive dashboard. 

---

## 🚀 Features

### 🔐 Multi-Tier Authentication
* **Online Mode:** Cloud-powered registration and secure user authentication synced in real time via **Firebase Authentication**.
* **Offline Mode:** Fully functional, localized account management backed by an **SQLite Database** for absolute privacy and offline access.

### 🔄 Real-Time Database Entry
* Dynamic data synchronization built with **Firebase Realtime Database**.
* Instantly saves, updates, and fetches user information across multiple active devices with zero latency.

### 🛠️ Mobile Services Hub (Hardware Controls)
Take direct command of core device hardware features smoothly from within the app:
* **Connectivity:** Seamlessly toggle Wi-Fi and Bluetooth states.
* **Hardware Utilities:** Instant controls for the camera Torch/Flashlight and device Vibrator haptics.
* **Communication:** Quick-access direct calling via an integrated dialer interface.
* **Proximity Sensing:** Real-time gesture detection and visual UI responses triggered by the device’s physical proximity sensor.

### 🎭 Application Services Hub (Entertainment & Productivity)
* **Calculator Hub:** Dual-mode processing supporting both standard everyday arithmetic and an advanced Scientific Calculator (logarithmic, trigonometric functions).
* **Media Suite:** Native, fully integrated HTML5/ExoPlayer-backed Music and Video Players with streamlined media playback controls.
* **External Web Browser:** A built-in web viewer allowing you to browse the internet securely without ever leaving the application.
* **Interactive Quiz Module:** A General Knowledge trivia challenge featuring dynamic scoring ($+1$ for correct answers, $-1$ for wrong answers) and native Text-to-Speech (TTS) voice integration for interactive result announcements.

---

## 🛠️ Tech Stack & Architecture

* **IDE:** Android Studio
* **Language:** Java / Kotlin
* **Database (Cloud):** Firebase Realtime Database
* **Database (Local):** SQLite
* **Authentication:** Firebase Auth
* **UI Layouts:** XML (Material Design Components)

---

## 📸 Screenshots & Demo

| Splash & Authentication | Hardware & Database Services | Entertainment & Media |
| :---: | :---: | :---: |
| _[Insert Splash/Login Screenshot Here]_ | _[Insert Services Hub Screenshot Here]_ | _[Insert Quiz/Media Player Screenshot Here]_ |

---

## 🏗️ Getting Started

Follow these steps to set up and run the project locally on your machine.

### Prerequisites
* Android Studio (Ladybug or newer recommended)
* Android SDK Platform 33+
* A Firebase Project configuration file (`google-services.json`)

### Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/YOUR_USERNAME/OmniHub.git](https://github.com/YOUR_USERNAME/OmniHub.git)
