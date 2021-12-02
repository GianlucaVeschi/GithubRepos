package com.gianlucaveschi.githubrepos.di

import com.gianlucaveschi.data.api.GithubService
import com.gianlucaveschi.githubrepos.BuildConfig
import com.gianlucaveschi.data.repo.MainRepositoryImpl
import com.gianlucaveschi.domain.repo.MainRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS);
    }

    @Singleton
    @Provides
    fun provideHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS) //If Backend is really slow
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideGithubRestService(okHttpClient: OkHttpClient): com.gianlucaveschi.data.api.GithubService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.GITHUB_ENDPOINT)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(GithubService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(githubService: GithubService): com.gianlucaveschi.domain.repo.MainRepository {
        return MainRepositoryImpl(githubService)
    }

    @Singleton
    @Provides
    fun provideGetGithubRepoListUseCase(
        mainRepository: MainRepository
    ) = com.gianlucaveschi.domain.interactors.GetGithubRepoListUseCase(mainRepository)

    @Singleton
    @Provides
    fun provideGetRepoCommitListUseCase(
        mainRepository: MainRepository
    ) = com.gianlucaveschi.domain.interactors.GetRepoCommitListUseCase(mainRepository)

}