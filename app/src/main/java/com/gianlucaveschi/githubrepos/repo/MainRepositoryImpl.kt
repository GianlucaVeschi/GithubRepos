package com.gianlucaveschi.githubrepos.repo

import com.gianlucaveschi.data.api.GithubService
import com.gianlucaveschi.data.model.GhCommitList
import com.gianlucaveschi.data.model.GhRepoList
import retrofit2.Response

class MainRepositoryImpl(
    private val githubService: com.gianlucaveschi.data.api.GithubService
) : MainRepository {

    override suspend fun getGithubUserRepos(): Response<com.gianlucaveschi.data.model.GhRepoList> =
        githubService.getGithubRepoList()

    override suspend fun getGithubRepoCommits(repoName: String): Response<com.gianlucaveschi.data.model.GhCommitList> =
        githubService.getGithubRepoCommitList(repoName)

}