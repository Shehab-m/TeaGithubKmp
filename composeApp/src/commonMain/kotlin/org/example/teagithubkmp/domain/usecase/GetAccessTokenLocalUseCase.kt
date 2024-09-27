package org.example.teagithubkmp.domain.usecase

import org.example.teagithubkmp.domain.repository.GithubRepository

class GetAccessTokenLocalUseCase(private val repository: GithubRepository) {

    suspend operator fun invoke(): String? {
        return repository.getAccessTokenLocal()
    }

}