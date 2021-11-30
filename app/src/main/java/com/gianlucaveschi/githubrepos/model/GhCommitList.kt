package com.gianlucaveschi.githubrepos.model

import com.gianlucaveschi.githubrepos.model.commits.GhCommitListItem
import kotlinx.serialization.Serializable

@Serializable
class GhCommitList : ArrayList<GhCommitListItem>()