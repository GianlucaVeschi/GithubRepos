package com.gianlucaveschi.githubrepos.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gianlucaveschi.githubrepos.interactors.GetGithubRepoListUseCase
import com.gianlucaveschi.githubrepos.model.GhRepoList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GhRepoListViewModel @Inject constructor(
    private val getGithubRepoListUseCase: GetGithubRepoListUseCase
) : ViewModel() {

    private val _githubRepos = MutableLiveData<GhRepoList>()
    val githubGhRepoList: LiveData<GhRepoList> get() = _githubRepos

    fun getGithubRepositoryForUser() {
        viewModelScope.launch {
            val state = getGithubRepoListUseCase()
            state.data?.let {
                _githubRepos.value = it
            }
            githubGhRepoList.value?.forEach {
                Log.d(TAG, "getDataFromGithub: ${it.name}")
            }
        }
    }

    companion object {
        private const val TAG = "GhRepoListViewModel"
    }
}