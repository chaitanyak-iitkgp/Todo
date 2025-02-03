package com.example.todo.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todo.data.local.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user_table WHERE id == :userId")
    suspend fun getActiveUser(userId:Int):User

    @Query("DELETE FROM user_table WHERE id == :userId")
    suspend fun deleteUser(userId:Int)
}
