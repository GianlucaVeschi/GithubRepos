# GithubRepos

## Intro

This project is written in Kotlin and follows MVVM Clean Architecture principles, with
LiveData/Coroutines/DataBinding.
The Api endpoint is hidden in the project as it should be done for api keys for security reasons.

## Build and run

Simply clone the project, import into Android Studio and run.

## Modules

It contains 3 modules in total:

- **app**: Contains the views fragment/activity and the adapters.
- **data**: Contains the Repository implementation and Api Service declaration.
- **domain**: Contains the Models, Repository interface and UseCases.

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

# ToDos & Workflow

Notes for myself, maybe relevant for you too to understand my mental process)

## Completed

- ~~Add Data Binding~~
- ~~Add Navigation & safeArgs~~
- ~~Add XML files to res folder~~
- ~~Add Hilt & set it up~~
- ~~Add RecyclerView & Adapter (Hardcode entries)~~
- ~~Bind ViewModel~~
- ~~Display Hardcoded data from the VM~~
- ~~Create mock UseCases layer~~
- ~~Inject UseCases in the VM~~
- ~~Create Repository layer~~
- ~~Inject Repository in the UseCases~~
- ~~Test ViewModels~~
- ~~Test UseCases~~
- ~~Test Repositories~~
- ~~Test Mappers~~
- ~~Test ViewModels~~
- ~~Test UseCases~~
- ~~Test Repositories~~
- ~~Delete all unnecessary logs.~~
- ~~Modularize project~~

## What would I have done differently If I had more time?
- Mappers from Api Model to Ui Model and Test
- Test ViewModel
- Test UI
- Use Flow and datastate instead of live data
- Create Custom Views
- Add search bar to look for a specific User in Github