package com.gianlucaveschi.domain.model.commit

import kotlinx.serialization.Serializable

@Serializable
data class Committer(
    val date: String,
    val email: String,
    val name: String
)