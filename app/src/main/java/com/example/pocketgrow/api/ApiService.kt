package com.example.pocketgrow.api

import com.example.pocketgrow.api.request.LoginRequest
import com.example.pocketgrow.api.request.RegisterRequest
import com.example.pocketgrow.api.response.LoginResponse
import com.example.pocketgrow.api.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/register")
    fun register(
        @Body signupRequest: RegisterRequest
    ): Call<RegisterResponse>

    @POST("auth/login")
    fun login(
        @Body loginRequest: LoginRequest
    ): Call<LoginResponse>
}