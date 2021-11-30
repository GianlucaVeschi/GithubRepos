package com.gianlucaveschi.githubrepos.model

import com.gianlucaveschi.githubrepos.model.repo.GhRepoListItem
import kotlinx.serialization.Serializable

@Serializable
class GhRepoList : ArrayList<GhRepoListItem>()