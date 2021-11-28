package com.gianlucaveschi.githubrepos.ui.main.interactors

import com.gianlucaveschi.githubrepos.ui.main.repo.MainRepository

class GetGithubRepoListUseCase(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke() = mainRepository.getGithubRepos()
}