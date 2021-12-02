package com.gianlucaveschi.githubrepos.interactors

import com.gianlucaveschi.domain.interactors.GetRepoCommitListUseCase
import com.gianlucaveschi.domain.repo.MainRepository
import com.gianlucaveschi.githubrepos.BaseJunitTest
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetRepoCommitListUseCaseTest : BaseJunitTest<GetRepoCommitListUseCase>() {

    private val mainRepository: MainRepository = mockk(relaxed = true)

    override fun initSelf() = GetRepoCommitListUseCase(mainRepository)

    @Test
    fun `should verify that usecase calls the main repo`() = runBlocking {
        systemUnderTest(REPO_NAME)

        coVerify(exactly = 1) { mainRepository.getGithubRepoCommits(REPO_NAME) }
    }

    companion object {
        const val REPO_NAME = "Python-For-Finance"
    }
}