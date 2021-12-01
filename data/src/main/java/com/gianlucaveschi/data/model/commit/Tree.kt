package com.gianlucaveschi.data.model.commit

import kotlinx.serialization.Serializable

@Serializable
data class Tree(
    val sha: String,
    val url: String
)