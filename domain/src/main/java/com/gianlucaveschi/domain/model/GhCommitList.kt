package com.gianlucaveschi.domain.model

import com.gianlucaveschi.domain.model.commit.GhCommitListItem
import kotlinx.serialization.Serializable

@Serializable
class GhCommitList : ArrayList<GhCommitListItem>()