package com.example.todo.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.local.SecureStorage
import com.example.todo.data.local.entities.User
import com.example.todo.data.repo.LoginRepo
import com.example.todo.data.repo.UserRepo
import com.example.todo.models.ErrorModel
import com.example.todo.models.LoginResponseModel
import com.example.todo.models.SingleLiveEvent
import com.example.todo.models.UserModel
import com.example.todo.utils.ApiUtils
import com.example.todo.utils.SharedPrefUtils
import com.fact.app.di.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepo: UserRepo
) : ViewModel() {

    private val _activeUser = SingleLiveEvent<ApiState<UserModel>>()
    val activeUser: SingleLiveEvent<ApiState<UserModel>> = _activeUser

    suspend fun getActiveUser(context: Context) {

        // get the userId from sharedPreferences
        val userId = SharedPrefUtils.getInt(context,"userId",-1)
        val accessToken = SecureStorage.getString(context,"accessToken")

        if(userId == -1 || accessToken.isBlank()){
            _activeUser.value = ApiState.error(ErrorModel("No User Found"))
            return
        }

        userRepo.getActiveUser(userId).catch {
            _activeUser.value = ApiState.error(ErrorModel("No User Found"))
        }.collect{
            _activeUser.value = ApiState.success(it.data)
        }
    }


}