package org.example.teagithubkmp.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LicenseDto(
    @SerialName("key")
    val key: String?,
    @SerialName("name")
    val name: String?,
)