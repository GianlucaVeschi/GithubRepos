package com.gianlucaveschi.githubrepos.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gianlucaveschi.githubrepos.databinding.GhRepoListFragmentBinding
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
        ghRepoListViewModel.getDataFromGithub()
        ghRepoListViewModel.githubRepos.observe(viewLifecycleOwner, { repos ->
            ghRepoListAdapter = GhRepoListAdapter(this, repos)
            binding.reposRecView.adapter = ghRepoListAdapter
            binding.mainProgressBar.visibility = View.INVISIBLE
        })
    }

    private fun initBinding() {
        binding.reposRecView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onRepoClicked(repoId: Int) {
        val action = GhRepoListFragmentDirections.actionListFragmentToDetailFragment(repoId)
        findNavController().navigate(action)
    }

}