package org.example.teagithubkmp.data.remote

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

abstract class BaseApiService {
    protected suspend inline fun <reified T> wrap(response: HttpResponse): T {
        return try {
            if (response.status.isSuccess()) {
                print("Tag1000: service done correctly")
                response.body()
            } else {
                print("Tag2000: service failed")
                when (response.status.value) {
                    else -> throw Exception(response.status.description)
                }
            }
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}