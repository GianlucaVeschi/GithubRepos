package com.gianlucaveschi.githubrepos.ui.main.api

import com.gianlucaveschi.githubrepos.ui.main.model.Repos
import com.gianlucaveschi.githubrepos.ui.main.model.ReposItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface GithubService {

    @GET("users/gianlucaveschi/repos")
    suspend fun getGithubRepoList() : Response<Repos>

}