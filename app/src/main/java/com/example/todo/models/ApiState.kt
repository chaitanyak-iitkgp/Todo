package com.fact.app.di

import com.example.todo.models.ErrorModel
import com.example.todo.utils.constants.Status

data class ApiState<out T>(val status: Status, val data: T?, val errorModel: ErrorModel?) {
    companion object {

        // In case of Success,set status as
        // Success and data as the response
        fun <T> success(data: T?): ApiState<T> {
            return ApiState(Status.SUCCESS, data, null)
        }

        // In case of failure ,set state to Error ,
        // add the error message,set data to null
        fun <T> error(errorModel: ErrorModel?): ApiState<T> {
            return ApiState(Status.ERROR, null, errorModel)
        }

        // When the call is loading set the state
        // as Loading and rest as null
        fun <T> loading(): ApiState<T> {
            return ApiState(Status.LOADING, null, null)
        }

        // By Default Pass state as Empty
        fun <T> empty(): ApiState<T> {
            return ApiState(Status.EMPTY, null, null)
        }
    }
}