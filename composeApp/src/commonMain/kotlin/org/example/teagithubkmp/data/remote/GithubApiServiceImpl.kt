package org.example.teagithubkmp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.example.teagithubkmp.data.remote.model.RepoDto
import org.example.teagithubkmp.util.getClientId
import org.example.teagithubkmp.util.getClientSecret

class GithubApiServiceImpl(private val client: HttpClient) : BaseApiService(), GithubApiService {

    override suspend fun getAccessToken(code: String): String {
        return wrap(client.post("https://github.com/login/oauth/access_token") {
            contentType(ContentType.Application.FormUrlEncoded)
            parameter("code", code)
            parameter("client_id", getClientId())
            parameter("client_secret", getClientSecret())
        })
    }

    override suspend fun getRepos(token: String): List<RepoDto> {
        return wrap(client.get("https://api.github.com/user/repos"))
    }


}