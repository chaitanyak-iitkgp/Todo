package com.example.todo.utils

import okhttp3.RequestBody
import org.json.JSONObject
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.MediaType.Companion.toMediaType

object ApiUtils {

    fun prepareBody(mainObject: JSONObject): RequestBody {
        return mainObject.toString().toRequestBody("application/json".toMediaType())
    }
}