package com.gianlucaveschi.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/$GH_USERNAME/repos")
    suspend fun getGithubRepoList(): Response<com.gianlucaveschi.domain.model.GhRepoList>

    @GET("repos/$GH_USERNAME/{repoName}/commits")
    suspend fun getGithubRepoCommitList(@Path("repoName") repoName: String): Response<com.gianlucaveschi.domain.model.GhCommitList>

    companion object {
        const val GH_USERNAME = "gianlucaveschi"
    }
}