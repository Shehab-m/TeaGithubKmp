package org.example.teagithubkmp.data.repository.mapper

import org.example.teagithubkmp.data.remote.model.OwnerDto
import org.example.teagithubkmp.domain.model.Owner

fun OwnerDto.toEntity(): Owner {
    return Owner(
        avatarUrl = avatarUrl ?: "",
        id = id ?: 0
    )
}
