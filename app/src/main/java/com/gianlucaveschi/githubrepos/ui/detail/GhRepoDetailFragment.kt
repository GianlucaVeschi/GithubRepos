package com.gianlucaveschi.githubrepos.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.gianlucaveschi.githubrepos.databinding.GhRepoDetailFragmentBinding
import com.gianlucaveschi.githubrepos.model.GhCommitList
import com.gianlucaveschi.githubrepos.ui.list.GhRepoListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GhRepoDetailFragment : Fragment() {

    private val viewModel: GhRepoDetailViewModel by viewModels()
    private lateinit var binding: GhRepoDetailFragmentBinding
    private lateinit var ghCommitListAdapter: GhCommitListAdapter
    private val args: GhRepoDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GhRepoDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        initBinding()
        viewModel.getCommitsForRepo(args.repoName)
        viewModel.githubRepoCommits.observe(viewLifecycleOwner, { commits ->
            updateUi(commits)
        })
    }

    private fun updateUi(commits: GhCommitList) {
        ghCommitListAdapter = GhCommitListAdapter(commits)
        binding.commitsRecView.adapter = ghCommitListAdapter
        binding.mainProgressBar.visibility = View.INVISIBLE
        for(commit in commits) Log.d(TAG, "updateUi: ${commit.commit.message}")
    }

    private fun initBinding() {
        binding.githubRepoId.text = args.repoId.toString()
        binding.githubRepoName.text = args.repoName
    }

    companion object {
        private const val TAG = "GhRepoDetailFragment"
    }
}