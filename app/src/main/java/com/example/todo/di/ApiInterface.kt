package com.example.todo.di

import com.example.todo.models.LoginResponseModal

interface ApiInterface {

    @POST
    suspend fun loginUser(@Body requestBody:RequestBody):LoginResponseModal
}