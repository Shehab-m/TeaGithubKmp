package org.example.teagithubkmp.data.remote

import org.example.teagithubkmp.data.remote.model.RepoDto

interface GithubApiService {
    suspend fun getAccessToken(code: String): String
    suspend fun getRepos(token: String): List<RepoDto>
}