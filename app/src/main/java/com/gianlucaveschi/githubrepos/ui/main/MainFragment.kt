package com.gianlucaveschi.githubrepos.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gianlucaveschi.githubrepos.databinding.MainFragmentBinding
import com.gianlucaveschi.githubrepos.ui.main.model.Repos
import com.gianlucaveschi.githubrepos.ui.main.model.ReposItem
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
    }

    private fun initBinding() {
        val repos = Repos()
        for (i in 0 until 10) {
            repos.add(ReposItem(name = "repository N$i"))
        }
        reposAdapter = ReposAdapter(this, repos)
        binding.reposRecView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = reposAdapter
        }
    }


    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onRepoClicked(repoName: String) {
        Log.d("MainFragment", "onRepoClicked: ")
    }

}