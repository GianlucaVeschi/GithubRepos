package com.gianlucaveschi.githubrepos.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gianlucaveschi.githubrepos.ui.main.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    fun getDataFromGithub() {
        viewModelScope.launch {
            mainRepository.getGithubRepos().body()?.forEach {
                Log.d(TAG, "getDataFromGithub: ${it.name}")
            }
        }
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}