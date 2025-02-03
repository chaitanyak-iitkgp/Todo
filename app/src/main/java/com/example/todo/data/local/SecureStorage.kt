package com.example.todo.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object SecureStorage {

    private const val PREF_NAME = "SecurePrefs"

    private fun getEncryptedPreferences(context: Context): SharedPreferences {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        return EncryptedSharedPreferences.create(
            context,
            PREF_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun putString(context: Context, key: String, value: String) {
        val prefs = getEncryptedPreferences(context)
        prefs.edit().putString(key, value).apply()
    }

    fun getString(context: Context, key: String, defaultValue: String = ""): String {
        val prefs = getEncryptedPreferences(context)
        return prefs.getString(key, defaultValue) ?: defaultValue
    }

    fun clear(context: Context) {
        val prefs = getEncryptedPreferences(context)
        prefs.edit().clear().apply()
    }
}
