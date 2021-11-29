package com.gianlucaveschi.githubrepos.repo

import com.gianlucaveschi.githubrepos.model.Repos
import retrofit2.Response

interface MainRepository {
    suspend fun getGithubRepos() : Response<Repos>
}