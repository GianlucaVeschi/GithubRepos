package com.gianlucaveschi.githubrepos.model.commits

import kotlinx.serialization.Serializable

@Serializable
data class Tree(
    val sha: String,
    val url: String
)