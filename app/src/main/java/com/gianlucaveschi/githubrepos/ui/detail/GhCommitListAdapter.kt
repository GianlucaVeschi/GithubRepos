package com.gianlucaveschi.githubrepos.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gianlucaveschi.githubrepos.databinding.CommitItemViewBinding
import com.gianlucaveschi.githubrepos.model.GhCommitList
import com.gianlucaveschi.githubrepos.model.commits.GhCommitListItem

class GhCommitListAdapter(
    private val githubGhCommitListList: GhCommitList
) : RecyclerView.Adapter<GhCommitListAdapter.GithubCommitViewHolder>() {

    inner class GithubCommitViewHolder(
        private val binding: CommitItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ghCommitListItem: GhCommitListItem) {
            binding.commitMessage.text = ghCommitListItem.commit.message
            binding.commitDate.text = ghCommitListItem.commit.committer.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubCommitViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CommitItemViewBinding.inflate(layoutInflater, parent, false)
        return GithubCommitViewHolder(binding)
    }

    override fun getItemCount() = githubGhCommitListList.size

    override fun onBindViewHolder(holder: GithubCommitViewHolder, position: Int) {
        val githubCommitListItem: GhCommitListItem = githubGhCommitListList[position]
        holder.bind(githubCommitListItem)
    }
}