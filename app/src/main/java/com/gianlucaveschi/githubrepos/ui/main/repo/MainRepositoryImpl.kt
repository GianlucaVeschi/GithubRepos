package com.gianlucaveschi.githubrepos.ui.main.repo

import com.gianlucaveschi.githubrepos.ui.main.GithubService
import com.gianlucaveschi.githubrepos.ui.main.model.Repos
import com.gianlucaveschi.githubrepos.ui.main.model.ReposItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class MainRepositoryImpl(
    private val githubService: GithubService
) : MainRepository {

    override suspend fun getGithubRepos(): Response<List<ReposItem>> {
        return githubService.getGithubRepoList()
    }

}