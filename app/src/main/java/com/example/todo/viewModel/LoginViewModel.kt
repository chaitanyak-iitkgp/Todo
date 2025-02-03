package com.example.todo.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.local.SecureStorage
import com.example.todo.data.repo.LoginRepo
import com.example.todo.models.ErrorModel
import com.example.todo.models.LoginResponseModel
import com.example.todo.models.SingleLiveEvent
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
class LoginViewModel @Inject constructor(
    private val loginRepo: LoginRepo
) : ViewModel() {

    private val _loginState = SingleLiveEvent<ApiState<LoginResponseModel>>()
    val loginState: SingleLiveEvent<ApiState<LoginResponseModel>> = _loginState

    fun loginUser(context: Context, username: String, password: String) {
        if (username.isBlank() || password.isBlank()) {
            _loginState.value = ApiState.error(ErrorModel("Enter Details"))
        }

        viewModelScope.launch {
            val jsonObject = JSONObject()
            jsonObject.put("username", username)
            jsonObject.put("password", password)




            loginRepo.login(ApiUtils.prepareBody(jsonObject)).onStart {
                _loginState.value = ApiState.loading()
            }.catch {
                _loginState.value = ApiState.error(ErrorModel(it.message))
            }.collect {
                it.data?.id?.let { id ->
                    SharedPrefUtils.putInt(context, "userId", id)
                }
                it.data?.accessToken?.let { accessToken ->
                    SecureStorage.putString(
                        context,
                        "accessToken",
                        accessToken
                    )
                }
//                loginRepo.addActiveUser(it.data.)
                _loginState.value = ApiState.success(it.data)
                Log.i("CKS", it.toString())
            }
        }
    }


}

