package com.gianlucaveschi.domain.repo

import com.gianlucaveschi.domain.model.GhCommitList
import com.gianlucaveschi.domain.model.GhRepoList
import retrofit2.Response

interface MainRepository {
    suspend fun getGithubUserRepos() : Response<GhRepoList>
    suspend fun getGithubRepoCommits(repoName : String) : Response<GhCommitList>
}