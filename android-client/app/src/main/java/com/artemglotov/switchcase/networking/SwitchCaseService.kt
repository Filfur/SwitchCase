package com.artemglotov.switchcase.networking

import com.artemglotov.switchcase.core.models.Case
import com.artemglotov.switchcase.core.models.Skin
import com.artemglotov.switchcase.core.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface SwitchCaseService {
    @GET("api/cases")
    suspend fun getCases(): Response<List<Case>>

    @GET("api/cases/{id}")
    suspend fun getCaseSkins(@Path("id") caseId: Int): Response<List<Skin>>

    @POST("api/cases/drop")
    suspend fun dropSkin(@Body caseId: Int): Response<Skin>

    @GET("api/user/{id}")
    suspend fun getUserInfo(@Path("id") userId: Int): Response<User>
}