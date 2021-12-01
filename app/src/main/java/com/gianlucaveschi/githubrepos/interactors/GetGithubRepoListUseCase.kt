package com.gianlucaveschi.githubrepos.interactors

import com.gianlucaveschi.data.model.GhRepoList
import com.gianlucaveschi.githubrepos.repo.MainRepository
import com.gianlucaveschi.githubrepos.util.DataState

class GetGithubRepoListUseCase(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke() = getGithubRepos()

    private suspend fun getGithubRepos(): DataState<GhRepoList> {
        val response = mainRepository.getGithubUserRepos()
        return response.takeIf { it.isSuccessful }?.body()?.let {
            DataState.success(it)
        } ?: DataState.error(response.message())
    }
}