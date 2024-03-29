package com.gianlucaveschi.domain.model.commit

import kotlinx.serialization.Serializable

@Serializable
data class Verification(
    val payload: String,
    val reason: String,
    val signature: String,
    val verified: Boolean
)