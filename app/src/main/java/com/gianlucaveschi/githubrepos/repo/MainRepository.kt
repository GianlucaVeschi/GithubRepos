package com.gianlucaveschi.githubrepos.repo

import com.gianlucaveschi.githubrepos.model.GhCommitList
import com.gianlucaveschi.githubrepos.model.GhRepoList
import retrofit2.Response

interface MainRepository {
    suspend fun getGithubUserRepos() : Response<GhRepoList>
    suspend fun getGithubRepoCommits(repoName : String) : Response<GhCommitList>
}