package org.example.teagithubkmp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.plugin
import io.ktor.client.request.headers
import org.example.teagithubkmp.data.local.DataStoreManager
import org.koin.core.scope.Scope

fun Scope.authorizationIntercept(client: HttpClient) {

    val localData: DataStoreManager by inject()

    client.plugin(HttpSend).intercept { request ->
        val accessToken = localData.getAccessToken()

        request.headers {
            append("Authorization", "Bearer $accessToken")
        }
        return@intercept execute(request)
    }
}
