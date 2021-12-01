package com.gianlucaveschi.githubrepos.repo

import com.gianlucaveschi.data.model.GhCommitList
import com.gianlucaveschi.data.model.GhRepoList
import retrofit2.Response

interface MainRepository {
    suspend fun getGithubUserRepos() : Response<GhRepoList>
    suspend fun getGithubRepoCommits(repoName : String) : Response<GhCommitList>
}