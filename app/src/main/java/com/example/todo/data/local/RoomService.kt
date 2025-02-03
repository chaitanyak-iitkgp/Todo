package com.example.todo.data.local

import android.content.Context
import com.example.todo.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomService {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): RoomDB {
        return RoomDB.getDatabase(context)
    }

    @Provides
    fun providesUserDao(database: RoomDB): UserDao {
        return database.userDao()
    }

}
