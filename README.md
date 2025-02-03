# Todo App

## Overview
The **Todo App** is a simple and efficient task management application that allows users to:
- **Register/Login** securely
- **Create, update, and delete** todos
- **Mark tasks as completed**
- **Sync todos locally and online** for seamless access across devices

## Features
- **User Authentication**: Secure login and registration system
- **Offline Support**: Store todos locally for offline access
- **Cloud Sync**: Automatically syncs todos to the online database
- **CRUD Operations**: Create, edit, delete, and mark todos as completed
- **User-Friendly UI**: Intuitive design for a smooth experience

## Tech Stack
- **Language**: Kotlin
- **Framework**: Android Jetpack
- **Local Storage**: Room Database
- **Networking**: Retrofit
- **Authentication**: Firebase Authentication
- **Cloud Storage**: Firebase Firestore

## Installation
### Prerequisites
- Android Studio installed
- Firebase project setup (for authentication and cloud storage)
- Physical device or emulator for testing

### Steps
1. **Clone the Repository**
   ```sh
   git [clone https://github.com/yourusername/todo-app.git](https://github.com/chaitanyak-iitkgp/Todo.git)
   cd Todo
   ```
2. **Open in Android Studio**
   - Open the project in Android Studio
   - Sync Gradle files
3. **Setup Firebase**
   - Add `google-services.json` to the `app` folder
   - Enable Firestore and Authentication in Firebase Console
4. **Run the App**
   ```sh
   Run on Emulator or Physical Device via Android Studio
   ```

## Roadmap
- [ ] Push notifications for due tasks
- [ ] Dark mode support
- [ ] Voice command integration

## License
This project is licensed under the MIT License.

## Contributing
Feel free to fork and contribute via pull requests!

---
Happy Developement ! 🚀
