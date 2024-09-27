package org.example.teagithubkmp.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OwnerDto(
    @SerialName("avatar_url")
    val avatarUrl: String?,
    @SerialName("id")
    val id: Int?,
)