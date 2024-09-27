package org.example.teagithubkmp.domain.usecase

import org.example.teagithubkmp.domain.repository.GithubRepository

class GetAccessTokenUseCase(private val repository: GithubRepository) {

    suspend operator fun invoke(code: String?): String {
        val tokenCode = requireNotNull(code) { "Access token code must not be null" }
        val accessToken = repository.getAccessToken(tokenCode)
        repository.saveAccessTokenLocal(accessToken)
        return accessToken
    }

}