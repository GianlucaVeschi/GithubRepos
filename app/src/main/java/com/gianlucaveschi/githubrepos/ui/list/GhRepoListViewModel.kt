package com.gianlucaveschi.githubrepos.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gianlucaveschi.domain.interactors.GetGithubRepoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GhRepoListViewModel @Inject constructor(
    private val getGithubRepoListUseCase: GetGithubRepoListUseCase
) : ViewModel() {

    private val _githubRepos = MutableLiveData<com.gianlucaveschi.domain.model.GhRepoList>()
    val githubGhRepoList: LiveData<com.gianlucaveschi.domain.model.GhRepoList> get() = _githubRepos

    fun getGithubRepositoryForUser() {
        viewModelScope.launch {
            val state = getGithubRepoListUseCase()
            state.data?.let {
                _githubRepos.value = it
            }
            state.error.let {
                //In a real scenario this error should be propagated to the UI
                Log.d(TAG, "getGithubRepositoryForUser: $it")
            }
        }
    }

    companion object {
        private const val TAG = "GhRepoListViewModel"
    }
}