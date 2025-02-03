package com.example.todo.data.repo

import com.example.todo.data.remote.ApiInterface
import com.example.todo.models.TodoListResponseModel
import com.fact.app.di.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ListingRepo@Inject constructor(
    private val apiInterface: ApiInterface
) {

    fun getTodo(): Flow<ApiState<TodoListResponseModel>> {
        // Simulate network delay
        return flow{
            val response = apiInterface.getTodo()
            emit(ApiState.success(response))
        }.flowOn(Dispatchers.IO)
    }



}