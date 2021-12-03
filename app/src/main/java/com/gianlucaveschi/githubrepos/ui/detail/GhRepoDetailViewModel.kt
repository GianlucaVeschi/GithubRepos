package com.gianlucaveschi.githubrepos.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gianlucaveschi.domain.interactors.GetRepoCommitListUseCase
import com.gianlucaveschi.githubrepos.ui.list.GhRepoListViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GhRepoDetailViewModel @Inject constructor(
    private val getRepoCommitListUseCase: GetRepoCommitListUseCase
) : ViewModel() {

    private val _githubRepoCommits = MutableLiveData<com.gianlucaveschi.domain.model.GhCommitList>()
    val githubRepoCommits: LiveData<com.gianlucaveschi.domain.model.GhCommitList> get() = _githubRepoCommits

    fun getCommitsForRepo(repoName: String) {
        viewModelScope.launch {
            val state = getRepoCommitListUseCase(repoName)
            state.data?.let {
                _githubRepoCommits.value = it
            }
            state.error.let {
                //In a real scenario this error should be propagated to the UI
                Log.d(TAG, "getCommitsForRepo: $it")
            }
        }
    }

    companion object {
        private const val TAG = "GhRepoDetailViewModel"
    }
}