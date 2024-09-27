package org.example.teagithubkmp.domain.model

import org.example.teagithubkmp.domain.model.License
import org.example.teagithubkmp.domain.model.Owner

data class Repo(
    val id: Int,
    val createdAt: String,
    val defaultBranch: String,
    val description: String,
    val language: String,
    val license: License,
    val name: String,
    val owner: Owner,
    val private: Boolean,
)