package com.gianlucaveschi.githubrepos.model.commits

import kotlinx.serialization.Serializable

@Serializable
data class Verification(
    val payload: String,
    val reason: String,
    val signature: String,
    val verified: Boolean
)