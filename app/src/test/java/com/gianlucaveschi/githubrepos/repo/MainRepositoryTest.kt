package com.gianlucaveschi.githubrepos.repo

import com.gianlucaveschi.data.api.GithubService
import com.gianlucaveschi.data.repo.MainRepositoryImpl
import com.gianlucaveschi.domain.repo.MainRepository
import com.gianlucaveschi.githubrepos.BaseJunitTest
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test


class MainRepositoryTest : BaseJunitTest<MainRepository>() {

    private val githubService: GithubService = mockk(relaxed = true)

    override fun initSelf() = MainRepositoryImpl(githubService)

    @Test
    fun `should verify that service calls the repos endpoint`() = runBlocking {
        systemUnderTest.getGithubUserRepos()

        coVerify(exactly = 1) { githubService.getGithubRepoList() }
    }

    @Test
    fun `should verify subscription to ticker`() = runBlocking {
        systemUnderTest.getGithubRepoCommits("Python-For-Finance")

        coVerify(exactly = 1) { githubService.getGithubRepoCommitList("Python-For-Finance") }
    }
}