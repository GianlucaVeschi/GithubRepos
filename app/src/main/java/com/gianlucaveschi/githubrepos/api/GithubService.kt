package com.gianlucaveschi.githubrepos.api

import com.gianlucaveschi.githubrepos.model.Repos
import retrofit2.Response
import retrofit2.http.GET

interface GithubService {

    @GET("users/gianlucaveschi/repos")
    suspend fun getGithubRepoList() : Response<Repos>

}