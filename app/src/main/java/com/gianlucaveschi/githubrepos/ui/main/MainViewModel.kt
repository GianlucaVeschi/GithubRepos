package com.gianlucaveschi.githubrepos.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gianlucaveschi.githubrepos.interactors.GetGithubRepoListUseCase
import com.gianlucaveschi.githubrepos.model.Repos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubRepoListUseCase: GetGithubRepoListUseCase
) : ViewModel() {

    private val _githubRepos = MutableLiveData<Repos>()
    val githubRepos: LiveData<Repos> get() = _githubRepos

    fun getDataFromGithub() {
        viewModelScope.launch {
            val state = getGithubRepoListUseCase()
            state.data?.let {
                _githubRepos.value = it
            }
            githubRepos.value?.forEach {
                Log.d(TAG, "getDataFromGithub: ${it.name}")
            }
        }
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}