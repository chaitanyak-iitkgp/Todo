package com.example.todo.data.repo

import com.example.todo.data.local.dao.UserDao
import com.example.todo.data.local.entities.toUserModel
import com.example.todo.data.remote.ApiInterface
import com.example.todo.models.UserModel
import com.fact.app.di.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject



class UserRepo@Inject constructor(
    private val userDao: UserDao
) {

    fun getActiveUser(userId:Int):Flow<ApiState<UserModel>>{
        return flow{
            val activeUserEntity =  userDao.getActiveUser(userId)
            emit(ApiState.success(activeUserEntity.toUserModel(
                TODO(),
                refreshToken = TODO()
            )))
        }.flowOn(Dispatchers.IO)

    }

//    suspend fun deleteLocalUser( ){
//
//    }

}