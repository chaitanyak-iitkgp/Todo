package com.example.todo.data.repo

import com.example.todo.data.local.dao.UserDao
import com.example.todo.data.local.entities.User
import com.example.todo.data.local.entities.toUserModel
import com.example.todo.data.remote.ApiInterface
import com.example.todo.models.LoginResponseModel
import com.example.todo.models.UserModel
import com.fact.app.di.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.RequestBody
import javax.inject.Inject

class LoginRepo@Inject constructor(
    private val apiInterface: ApiInterface,
    private val userDao: UserDao
) {


     fun login(requestBody:RequestBody): Flow<ApiState<LoginResponseModel>> {
        // Simulate network delay
        return flow{
            val response = apiInterface.loginUser(requestBody)
            emit(ApiState.success(response))
        }.flowOn(Dispatchers.IO)
    }


    fun addActiveUser(newUser:User):Flow<ApiState<Boolean>> {
        return flow {
            val activeUserEntity = userDao.insertUser(newUser)
            emit(ApiState.success(true))
        }.flowOn(Dispatchers.IO)
    }
}