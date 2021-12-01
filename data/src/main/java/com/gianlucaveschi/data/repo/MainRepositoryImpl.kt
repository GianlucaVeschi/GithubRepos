package com.gianlucaveschi.data.repo

import com.gianlucaveschi.data.api.GithubService
import com.gianlucaveschi.domain.model.GhCommitList
import com.gianlucaveschi.domain.model.GhRepoList
import com.gianlucaveschi.domain.repo.MainRepository
import retrofit2.Response

class MainRepositoryImpl(
    private val githubService: GithubService
) : MainRepository {

    override suspend fun getGithubUserRepos(): Response<GhRepoList> =
        githubService.getGithubRepoList()

    override suspend fun getGithubRepoCommits(repoName: String): Response<GhCommitList> =
        githubService.getGithubRepoCommitList(repoName)

}