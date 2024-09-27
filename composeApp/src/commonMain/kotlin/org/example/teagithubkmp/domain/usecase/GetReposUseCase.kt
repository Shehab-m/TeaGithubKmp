package org.example.teagithubkmp.domain.usecase

import org.example.teagithubkmp.domain.model.Repo
import org.example.teagithubkmp.domain.repository.GithubRepository

class GetReposUseCase(private val repository: GithubRepository) {

    suspend operator fun invoke(token: String): List<Repo> {
        return repository.getRepos(token)
    }

}