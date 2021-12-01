package com.gianlucaveschi.domain.interactors

import com.gianlucaveschi.domain.model.GhRepoList
import com.gianlucaveschi.domain.repo.MainRepository
import com.gianlucaveschi.domain.util.DataState

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