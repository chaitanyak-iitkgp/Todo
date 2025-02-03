package com.example.todo.models

import com.example.todo.data.local.entities.User

data class UserModel(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val accessToken: String,
    val refreshToken: String
)


fun UserModel.toUser(isActive:Boolean): User {
    return User(
        id = this.id,
        username = this.username,
        email = this.email,
        firstName = this.firstName,
        lastName = this.lastName,
        gender = this.gender,
        image = this.image,
        isActive // assuming a default value, set this based on your needs
    )
}



