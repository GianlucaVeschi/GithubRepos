package com.gianlucaveschi.githubrepos.ui.main.di

import android.content.Context
import com.gianlucaveschi.githubrepos.BuildConfig
import com.gianlucaveschi.githubrepos.ui.main.api.GithubService
import com.gianlucaveschi.githubrepos.ui.main.repo.MainRepository
import com.gianlucaveschi.githubrepos.ui.main.repo.MainRepositoryImpl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
        @ApplicationContext appContext: Context
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
    fun provideGithubRestService(okHttpClient: OkHttpClient): GithubService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.GITHUB_ENDPOINT)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(GithubService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(githubService: GithubService): MainRepository {
        return MainRepositoryImpl(githubService)
    }
}