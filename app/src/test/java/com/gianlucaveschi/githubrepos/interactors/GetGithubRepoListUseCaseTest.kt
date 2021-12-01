package com.gianlucaveschi.githubrepos.interactors

import com.gianlucaveschi.domain.interactors.GetGithubRepoListUseCase
import com.gianlucaveschi.domain.repo.MainRepository
import com.gianlucaveschi.githubrepos.BaseJunitTest
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetGithubRepoListUseCaseTest : BaseJunitTest<GetGithubRepoListUseCase>() {

    private val mainRepository: MainRepository = mockk(relaxed = true)

    override fun initSelf() = GetGithubRepoListUseCase(mainRepository)

    @Test
    fun `should verify that usecase gets the github repos`() = runBlocking {
        systemUnderTest()

        coVerify(exactly = 1) { mainRepository.getGithubUserRepos() }
    }

}