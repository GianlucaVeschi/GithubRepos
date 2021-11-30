package com.gianlucaveschi.githubrepos.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gianlucaveschi.githubrepos.databinding.RepoItemViewBinding
import com.gianlucaveschi.githubrepos.model.Repos
import com.gianlucaveschi.githubrepos.model.ReposItem

class GhRepoListAdapter(
    private val listener: OnRepoClickListener,
    private val githubReposList: Repos
) : RecyclerView.Adapter<GhRepoListAdapter.GithubRepoViewHolder>() {

    inner class GithubRepoViewHolder(
        private val binding: RepoItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(reposItem: ReposItem) {
            binding.repoName.text = reposItem.name
            binding.repoId.text = reposItem.id.toString()
        }

        override fun onClick(v: View?) {
            listener.onRepoClicked(githubReposList[adapterPosition].id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = RepoItemViewBinding.inflate(layoutInflater, parent, false)

        return GithubRepoViewHolder(binding)
    }

    override fun getItemCount() = githubReposList.size

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {

        val githubRepoItem: ReposItem = githubReposList[position]

        holder.bind(githubRepoItem)
    }

    interface OnRepoClickListener {
        fun onRepoClicked(repoId: Int)
    }
}