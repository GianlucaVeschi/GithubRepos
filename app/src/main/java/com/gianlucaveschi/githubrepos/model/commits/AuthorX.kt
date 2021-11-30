package com.gianlucaveschi.githubrepos.model.commits

import kotlinx.serialization.Serializable

@Serializable
data class AuthorX(
    val date: String,
    val email: String,
    val name: String
)