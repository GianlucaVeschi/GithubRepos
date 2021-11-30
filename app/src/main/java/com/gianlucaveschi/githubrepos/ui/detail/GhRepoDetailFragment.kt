package com.gianlucaveschi.githubrepos.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.gianlucaveschi.githubrepos.databinding.GhRepoDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GhRepoDetailFragment : Fragment() {

    private val args: GhRepoDetailFragmentArgs by navArgs()

    private lateinit var binding: GhRepoDetailFragmentBinding
    private val viewModel: GhRepoDetailViewModel by viewModels()

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
        binding.githubRepoId.text = args.repoId.toString()
        viewModel.doSomething()
    }
}