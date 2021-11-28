package com.gianlucaveschi.githubrepos.ui.main.repo

import com.gianlucaveschi.githubrepos.ui.main.model.Repos
import com.gianlucaveschi.githubrepos.ui.main.model.ReposItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MainRepository {
    suspend fun getGithubRepos() : Response<Repos>
}