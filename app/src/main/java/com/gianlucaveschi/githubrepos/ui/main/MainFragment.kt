package com.gianlucaveschi.githubrepos.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gianlucaveschi.githubrepos.databinding.MainFragmentBinding
import com.gianlucaveschi.githubrepos.model.Repos
import com.gianlucaveschi.githubrepos.model.ReposItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(), ReposAdapter.OnRepoClickListener {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding
    private lateinit var reposAdapter: ReposAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
        mainViewModel.getDataFromGithub()
        mainViewModel.githubRepos.observe(viewLifecycleOwner, { repos ->
            reposAdapter = ReposAdapter(this, repos)
            binding.reposRecView.adapter = reposAdapter
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
        val action = MainFragmentDirections.actionListFragmentToDetailFragment(repoId)
        findNavController().navigate(action)
    }

}