package com.gianlucaveschi.githubrepos.model.commits

import kotlinx.serialization.Serializable

@Serializable
data class Commit(
    val author: AuthorX,
    val comment_count: Int,
    val committer: Committer,
    val message: String,
    val tree: Tree,
    val url: String,
    val verification: Verification
)