package com.gianlucaveschi.data.repo

import com.gianlucaveschi.domain.repo.MainRepository
import retrofit2.Response

class MainRepositoryImpl(
    private val githubService: com.gianlucaveschi.data.api.GithubService
) : MainRepository {

    override suspend fun getGithubUserRepos(): Response<com.gianlucaveschi.domain.model.GhRepoList> =
        githubService.getGithubRepoList()

    override suspend fun getGithubRepoCommits(repoName: String): Response<com.gianlucaveschi.domain.model.GhCommitList> =
        githubService.getGithubRepoCommitList(repoName)

}