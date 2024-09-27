package org.example.teagithubkmp.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepoDto(
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("default_branch")
    val defaultBranch: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("forks_count")
    val forksCount: Int?,
    @SerialName("full_name")
    val fullName: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("language")
    val language: String?,
    @SerialName("license")
    val license: LicenseDto?,
    @SerialName("name")
    val name: String?,
    @SerialName("owner")
    val owner: OwnerDto?,
    @SerialName("private")
    val private: Boolean?,
)