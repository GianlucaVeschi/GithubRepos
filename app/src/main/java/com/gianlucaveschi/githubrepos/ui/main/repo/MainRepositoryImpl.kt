package com.gianlucaveschi.githubrepos.ui.main.repo

import com.gianlucaveschi.githubrepos.ui.main.api.GithubService
import com.gianlucaveschi.githubrepos.ui.main.model.Repos
import retrofit2.Response

class MainRepositoryImpl(
    private val githubService: GithubService
) : MainRepository {

    override suspend fun getGithubRepos(): Response<Repos> = githubService.getGithubRepoList()

}