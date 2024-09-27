package org.example.teagithubkmp.data.repository.mapper

import org.example.teagithubkmp.data.remote.model.LicenseDto
import org.example.teagithubkmp.domain.model.License

fun LicenseDto.toEntity(): License {
    return License(
        key = key ?: "",
        name = name ?: ""
    )
}
