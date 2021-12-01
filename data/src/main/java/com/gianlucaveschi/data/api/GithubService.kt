package com.gianlucaveschi.data.api

import com.gianlucaveschi.data.model.GhCommitList
import com.gianlucaveschi.data.model.GhRepoList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/$GH_USERNAME/repos")
    suspend fun getGithubRepoList(): Response<GhRepoList>

    @GET("repos/$GH_USERNAME/{repoName}/commits")
    suspend fun getGithubRepoCommitList(@Path("repoName") repoName: String): Response<GhCommitList>

    companion object {
        const val GH_USERNAME = "gianlucaveschi"
    }
}