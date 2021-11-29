package com.gianlucaveschi.githubrepos.repo

import com.gianlucaveschi.githubrepos.api.GithubService
import com.gianlucaveschi.githubrepos.model.Repos
import retrofit2.Response

class MainRepositoryImpl(
    private val githubService: GithubService
) : MainRepository {

    override suspend fun getGithubRepos(): Response<Repos> = githubService.getGithubRepoList()

}