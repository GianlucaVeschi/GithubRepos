package com.gianlucaveschi.githubrepos.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gianlucaveschi.githubrepos.databinding.RepoItemViewBinding
import com.gianlucaveschi.domain.model.GhRepoList

class GhRepoListAdapter(
    private val listener: OnRepoClickListener,
    private val githubGhRepoListList: GhRepoList
) : RecyclerView.Adapter<GhRepoListAdapter.GithubRepoViewHolder>() {

    inner class GithubRepoViewHolder(
        private val binding: RepoItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(ghRepoListItem: com.gianlucaveschi.domain.model.repo.GhRepoListItem) {
            binding.repoName.text = ghRepoListItem.name
            binding.repoId.text = ghRepoListItem.id.toString()
        }

        override fun onClick(v: View?) {
            listener.onRepoClicked(
                githubGhRepoListList[adapterPosition].id,
                githubGhRepoListList[adapterPosition].name
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RepoItemViewBinding.inflate(layoutInflater, parent, false)
        return GithubRepoViewHolder(binding)
    }

    override fun getItemCount() = githubGhRepoListList.size

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
        val githubRepoListItem: com.gianlucaveschi.domain.model.repo.GhRepoListItem = githubGhRepoListList[position]
        holder.bind(githubRepoListItem)
    }

    interface OnRepoClickListener {
        fun onRepoClicked(repoId: Int, repoName: String)
    }
}