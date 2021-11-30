package com.gianlucaveschi.githubrepos.model.commits

import kotlinx.serialization.Serializable

@Serializable
data class GhCommitListItem(
    val author: Author,
    val comments_url: String,
    val commit: Commit,
    val committer: CommitterX,
    val html_url: String,
    val node_id: String,
    val sha: String,
    val url: String
)