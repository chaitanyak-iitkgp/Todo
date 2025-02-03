package com.example.todo.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todo.models.UserModel

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val isActive:Boolean = true
)
{
}


fun User.toUserModel(accessToken: String, refreshToken: String): UserModel {
    return UserModel(
        id = this.id,
        username = this.username,
        email = this.email,
        firstName = this.firstName,
        lastName = this.lastName,
        gender = this.gender,
        image = this.image,
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}
