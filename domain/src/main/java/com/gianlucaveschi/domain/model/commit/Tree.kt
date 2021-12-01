package com.gianlucaveschi.domain.model.commit

import kotlinx.serialization.Serializable

@Serializable
data class Tree(
    val sha: String,
    val url: String
)