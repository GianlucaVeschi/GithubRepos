package com.gianlucaveschi.domain.model

import com.gianlucaveschi.domain.model.repo.GhRepoListItem
import kotlinx.serialization.Serializable

@Serializable
class GhRepoList : ArrayList<GhRepoListItem>()