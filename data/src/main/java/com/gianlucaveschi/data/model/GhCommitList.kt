package com.gianlucaveschi.data.model

import com.gianlucaveschi.data.model.commit.GhCommitListItem
import kotlinx.serialization.Serializable

@Serializable
class GhCommitList : ArrayList<GhCommitListItem>()