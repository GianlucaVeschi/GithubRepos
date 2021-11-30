package com.gianlucaveschi.githubrepos.repo

import com.gianlucaveschi.githubrepos.api.GithubService
import com.gianlucaveschi.githubrepos.model.GhCommitList
import com.gianlucaveschi.githubrepos.model.GhRepoList
import retrofit2.Response

class MainRepositoryImpl(
    private val githubService: GithubService
) : MainRepository {

    override suspend fun getGithubUserRepos(): Response<GhRepoList> =
        githubService.getGithubRepoList()

    override suspend fun getGithubRepoCommits(repoName: String): Response<GhCommitList> =
        githubService.getGithubRepoCommitList(repoName)

}