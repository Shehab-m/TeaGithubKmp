package org.example.teagithubkmp.data.repository.mapper

import org.example.teagithubkmp.data.remote.model.RepoDto
import org.example.teagithubkmp.domain.model.License
import org.example.teagithubkmp.domain.model.Owner
import org.example.teagithubkmp.domain.model.Repo


fun RepoDto.toEntity(): Repo {
    return Repo(
        id = id ?: 0,
        createdAt = createdAt ?: "",
        defaultBranch = defaultBranch ?: "",
        description = description ?: "",
        language = language ?: "",
        license = license?.toEntity() ?: License("", ""),
        name = name ?: "",
        owner = owner?.toEntity() ?: Owner("", 0),
        private = private ?: false
    )
}
