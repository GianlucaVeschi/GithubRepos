package com.gianlucaveschi.githubrepos.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.gianlucaveschi.githubrepos.databinding.GhRepoDetailFragmentBinding
import com.gianlucaveschi.domain.model.GhCommitList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GhRepoDetailFragment : Fragment() {

    private val args: GhRepoDetailFragmentArgs by navArgs()
    private val viewModel: GhRepoDetailViewModel by viewModels()
    private lateinit var binding: GhRepoDetailFragmentBinding
    private lateinit var ghCommitListAdapter: GhCommitListAdapter

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
    }

    private fun initBinding() {
        binding.apply {
            githubRepoId.text = args.repoId.toString()
            githubRepoName.text = args.repoName
            commitsRecView.setHasFixedSize(true)
            commitsRecView.layoutManager = LinearLayoutManager(activity)
        }
    }
}