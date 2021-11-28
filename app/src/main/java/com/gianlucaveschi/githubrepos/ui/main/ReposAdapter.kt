package com.gianlucaveschi.githubrepos.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gianlucaveschi.githubrepos.databinding.RepoItemViewBinding
import com.gianlucaveschi.githubrepos.ui.main.model.Repos
import com.gianlucaveschi.githubrepos.ui.main.model.ReposItem

class ReposAdapter(
    private val listener: OnRepoClickListener,
    private val githubReposList: Repos
) : RecyclerView.Adapter<ReposAdapter.GithubRepoViewHolder>() {

    fun setGithubReposList(newGithubRepo: Repos) {
        this.githubReposList.clear()
        this.githubReposList.addAll(newGithubRepo)
    }

    // GithubRepo View Holder
    inner class GithubRepoViewHolder(
        private val binding: RepoItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(reposItem: ReposItem) {
            binding.repoName.text = reposItem.name
        }

        override fun onClick(v: View?) {
            listener.onRepoClicked(githubReposList[adapterPosition].name)
        }
    }

    // Called when the RecyclerView needs a view holder to represent an item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder {

        // Used to create views from XML layouts
        val layoutInflater = LayoutInflater.from(parent.context)

        //ViewHolderBinding Object
        val binding = RepoItemViewBinding
            .inflate(layoutInflater, parent, false)

        return GithubRepoViewHolder(binding)
    }

    // Tell the RecyclerView how many items the adapter has for it to display
    override fun getItemCount() = githubReposList.size

    // Called by RecyclerView to display the data for one list item at the specified position
    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {

        // Get the current GithubRepo in the list
        val githubRepoItem: ReposItem = githubReposList[position]

        // Pass the current GithubRepo to the viewHolder
        holder.bind(githubRepoItem)
    }

    interface OnRepoClickListener {
        fun onRepoClicked(repoName: String)
    }
}