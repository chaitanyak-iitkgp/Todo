package com.example.todo.data.remote

import com.example.todo.models.LoginResponseModel
import com.example.todo.models.TodoListResponseModel
import com.example.todo.utils.constants.ApiConstants
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST(ApiConstants.ApiEndPoints.LOGIN)
    suspend fun loginUser(@Body requestBody:RequestBody):LoginResponseModel

    @POST(ApiConstants.ApiEndPoints.TODO)
    suspend fun getTodo():TodoListResponseModel

}