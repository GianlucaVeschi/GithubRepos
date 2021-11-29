package com.gianlucaveschi.githubrepos.interactors

import com.gianlucaveschi.githubrepos.model.Repos
import com.gianlucaveschi.githubrepos.repo.MainRepository
import com.gianlucaveschi.githubrepos.util.DataState

class GetGithubRepoListUseCase(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke() = getGithubRepos()

    private suspend fun getGithubRepos(): DataState<Repos> {
        val response = mainRepository.getGithubRepos()
        return response.takeIf { it.isSuccessful }?.body()?.let {
            DataState.success(it)
        } ?: DataState.error(response.message())
    }
}