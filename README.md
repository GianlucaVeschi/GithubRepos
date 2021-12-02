# GithubRepos

## Intro

This project is written in Kotlin and following MVVM Clean Architecture principles, with
LiveData/Coroutines/DataBinding. 

## Build and run

Simply clone the project, import into Android Studio and run. 

## Modules

It contains 3 modules in total:

- app: Contains the views fragment/activity and the adapters.
- domain: Contains the Repository interface and UseCases.
- data: Contains the Repository and WebSocket implementations.

## Testing

The App module contains a set of basic unit tests for the ViewModel, Repository and UseCases.

## Libraries

- Coroutines
- Dagger Hilt
- Jetpack (Navigation, Data Binding, Lifecycle, LiveData, ViewModel)
- Kotlinx Serialization
- Okhttp
- JUnit
- Mockk
- Kotlin test
