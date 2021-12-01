package com.gianlucaveschi.domain.interactors

import com.gianlucaveschi.domain.model.GhCommitList
import com.gianlucaveschi.domain.repo.MainRepository
import com.gianlucaveschi.domain.util.DataState

class GetRepoCommitListUseCase(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(repoName: String) = getCommitsForRepo(repoName)

    private suspend fun getCommitsForRepo(repoName: String): DataState<GhCommitList> {
        val response = mainRepository.getGithubRepoCommits(repoName)
        return response.takeIf { it.isSuccessful }?.body()?.let {
            DataState.success(it)
        } ?: DataState.error(response.message())
    }
}