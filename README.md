# AnimeVault
 [![Platform](https://img.shields.io/badge/platform-Android-green.svg)](http://developer.android.com/index.html) [![Kotlin](https://img.shields.io/badge/kotlin-1.9.23-orange.svg)](http://kotlinlang.org) [![Gradle](https://img.shields.io/badge/gradle-8.4-%2366DCB8.svg)](https://developer.android.com/studio/releases/gradle-plugin)


AnimeVault is an Android application designed to provide users with an exceptional experience in finding the best anime. With a focus on quality and convenience, AnimeVault offers features that allow users to easily search and discover their favorite anime.

![image](https://github.com/althof-z/StaySwiftBookingApp/blob/main/assets/app.png)

## Main Features

- **Search and Discover Anime**: Easily find and discover your favorite anime.
- **Favorites Management**: Save and manage your favorite anime in a dedicated list.
- **Browser Integration**: Instantly search for your favorite anime in the browser.

## How to Run

1. Clone this repository.
2. Open the project in Android Studio.
3. Run the application on an emulator or a physical device.

## Project Structure

- `app/` - Contains the application source code and build configuration files.
- `data/` - Contains the source code for data retrieval.
- `di/` - Contains the source code for dependency injection.
- `domain/` - Contains the source code for business logic.

## Build With

- [Android Studio](https://developer.android.com/studio) (Jellyfish | 2023.3.1).
- [Kotlin](https://kotlinlang.org/) (1.9.23).
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Lifecycle-aware data holder.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - UI-related data holder, lifecycle-aware.
- [Koin](https://insert-koin.io/docs/quickstart/android/) - Dependency injection framework for Kotlin.
- [ROOM](https://developer.android.com/topic/libraries/architecture/room) - Database library for local data storage.
- [Retrofit](https://square.github.io/retrofit/) - Type-safe HTTP client for Android and Java.
- [OkHttp3](https://github.com/square/okhttp) - HTTP client for Android and Java.
- [Coil](https://github.com/coil-kt) - Image loading library for Android.
- [GSON Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) - Converter for JSON serialization/deserialization.

## API

AnimeVault uses the following API to fetch anime data:

- [Jikan API](https://jikan.moe/) - an Unofficial MyAnimeList API. It scrapes the website to satisfy the need for a complete API - which MyAnimeList lacks.


## Contributions

Contributions are highly appreciated. If you are interested in contributing, please fork this repository and create a pull request.
