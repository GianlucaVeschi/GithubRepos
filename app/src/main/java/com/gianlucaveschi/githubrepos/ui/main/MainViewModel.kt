package com.gianlucaveschi.githubrepos.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gianlucaveschi.githubrepos.ui.main.model.Repos
import com.gianlucaveschi.githubrepos.ui.main.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _githubRepos = MutableLiveData<Repos>()
    val githubRepos: LiveData<Repos> get() = _githubRepos

    fun getDataFromGithub() {
        viewModelScope.launch {
            _githubRepos.value = mainRepository.getGithubRepos().body()
            githubRepos.value?.forEach {
                Log.d(TAG, "getDataFromGithub: ${it.name}")
            }
        }
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}