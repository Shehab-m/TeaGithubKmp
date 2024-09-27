package org.example.teagithubkmp.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessTokenDto (
    @SerialName("access_token")
    val accessToken: String?,
    @SerialName("token_type")
    val tokenType: String?,
    @SerialName("scope")
    val scope: String?
)
