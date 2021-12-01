package com.gianlucaveschi.data.model

import com.gianlucaveschi.data.model.repo.GhRepoListItem
import kotlinx.serialization.Serializable

@Serializable
class GhRepoList : ArrayList<GhRepoListItem>()