package com.gianlucaveschi.githubrepos.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gianlucaveschi.githubrepos.databinding.GhRepoListFragmentBinding
import com.gianlucaveschi.githubrepos.model.GhRepoList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GhRepoListFragment : Fragment(), GhRepoListAdapter.OnRepoClickListener {

    private val ghRepoListViewModel: GhRepoListViewModel by viewModels()
    private lateinit var binding: GhRepoListFragmentBinding
    private lateinit var ghRepoListAdapter: GhRepoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GhRepoListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
        ghRepoListViewModel.getGithubRepositoryForUser()
        ghRepoListViewModel.githubGhRepoList.observe(viewLifecycleOwner, { repos ->
            updateUi(repos)
        })
    }

    private fun updateUi(repos: GhRepoList) {
        ghRepoListAdapter = GhRepoListAdapter(this, repos)
        binding.reposRecView.adapter = ghRepoListAdapter
        binding.mainProgressBar.visibility = View.INVISIBLE
    }

    private fun initBinding() {
        binding.reposRecView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onRepoClicked(repoId: Int, repoName: String) {
        val toDetailScreen = GhRepoListFragmentDirections
            .actionListFragmentToDetailFragment(repoId, repoName)
        findNavController().navigate(toDetailScreen)
    }

}